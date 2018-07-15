package com.joseph.osys.controller;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.HardString;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.mapper.UserMapper;
import com.joseph.osys.pojos.User;
import com.joseph.osys.util.ImageCut;

@Controller
public class UserInfoController {
	@Autowired
	UserMapper userMapper;
	
	//显示用户界面
	@RequestMapping(value = "/userInfoShow")
	public String userInfoShow()
	{
		return "main/userinfo/userInfo";
	}
	
	//显示用户界面
	@RequestMapping(value = "/userInfoMetaShow")
	public String userInfoMetaShow()
	{
		return "common/userInfoMeta";
	}
	
	//显示用户界面
	@RequestMapping(value = "/uploadPhotoShow")
	public String uploadPhotoShow()
	{
		return "common/upload_photo";
	}
	
	//显示用户界面
	@RequestMapping(value = "/changePwdShow")
	public String changePwdShow()
	{
		return "common/change_pwd";
	}
	
	//显示用户界面
	@RequestMapping(value = "/bindEmailShow")
	public String bindEmailShow()
	{
		return "common/bind_email";
	}
	
    @RequestMapping(value = "/imgCut",method = RequestMethod.POST)  
    public @ResponseBody ResultReturn profileImgCut(MultipartFile avatar_file,String avatar_src,String avatar_data, HttpSession session, HttpServletRequest request) {
    	ResultReturn data = new ResultReturn();
    	String name = avatar_file.getOriginalFilename();
    	String parentPath = request.getSession().getServletContext().getRealPath("/");
		String path = parentPath+"static/photo"; 
        //判断文件的MIMEtype
        String type = avatar_file.getContentType();
        if(type == null || !type.toLowerCase().startsWith("image/")){
        	data.setReturnCode(CodeType.FAILURE);
        	data.setMapField("result", "不支持的文件类型，仅支持图片！");
        }
        System.out.println("file type:"+type);
        String fileName = new Date().getTime()+""+new Random().nextInt(10000)+"_"+name.substring(name.lastIndexOf('.'));
        System.out.println("文件路径："+path+":"+fileName); 
        String databaseStorePath = "static/photo"+ "/" + fileName;
        //开始上传
        File targetFile = new File(path, fileName);
        //保存  
        try {  
        	if(!targetFile.exists()){  
	            targetFile.mkdirs();
	            
	            JSONObject joData = JSONObject.fromObject(avatar_data);
	            long photoX = joData.getLong("x");
	            long photoY = joData.getLong("y");
	            long photoW = joData.getLong("height");
	            long photoH = joData.getLong("width");
	            System.out.println(avatar_data);
	            InputStream in = avatar_file.getInputStream();
	            ImageCut.cut(in, targetFile, (int)photoX,(int)photoY,(int)photoW,(int)photoH);  
	            in.close();
	            User currentUser = (User)session.getAttribute("currentUser");
	            String primaryKey = currentUser.getUsername();
	            User newUser = new User();
	            newUser.setUsername(primaryKey);
	            newUser.setPhoto(databaseStorePath);
	            File oldFile = new File(parentPath+currentUser.getPhoto());
	            currentUser.setPhoto(databaseStorePath);
	            userMapper.updateByPrimaryKeySelective(newUser);
	            session.setAttribute("currentUser",currentUser);
				if(!currentUser.getPhoto().equals(HardString.defaultPhoto) && oldFile.exists()){
					oldFile.delete();            	
				}
	            data.setReturnCode(CodeType.SUCCESS);
	            data.setMapField("url", databaseStorePath);
        	}
        } catch (Exception e) {  
            data.setReturnCode(CodeType.FAILURE);
            data.setMapField("result", "服务器异常");
        }  
       return  data;
    }
}
