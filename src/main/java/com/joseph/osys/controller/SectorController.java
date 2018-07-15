package com.joseph.osys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.mapper.ChapterMapper;
import com.joseph.osys.mapper.SectorMapper;
import com.joseph.osys.pojos.Book;
import com.joseph.osys.pojos.Chapter;
import com.joseph.osys.pojos.Sector;
import com.joseph.osys.pojos.SectorExample;
import com.joseph.osys.pojos.SectorExample.Criteria;
import com.joseph.osys.util.CheckParameter;

@Controller
public class SectorController {
	
	@Autowired
	private SectorMapper sectorMapper;
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	@RequestMapping(value = "/addSectionShow")
	public String addSectionShow() throws Exception {
		return "admin/addSection";
	}
	
	@RequestMapping(value = "/deleteSectionShow")
	public String deleteSectionShow(Model model) throws Exception {
		List<Sector> sectors = sectorMapper.selectByExample(null);
		model.addAttribute("sectors", sectors);
		return "admin/deleteSection";
	}
	
	@RequestMapping(value = "/editSectionShow")
	public String editSectionShow(Model model) throws Exception {
		List<Sector> sectors = sectorMapper.selectByExample(null);
		model.addAttribute("sectors", sectors);
		return "admin/editSection";
	}
	
	@RequestMapping(value = "/listSectionShow")
	public String listSectionShow(Model model) throws Exception {
		List<Sector> sectors = sectorMapper.selectByExample(null);
		model.addAttribute("sectors", sectors);
		return "admin/listSection";
	}
	
	@RequestMapping(value = "/getChapterIds") 
	public  @ResponseBody String getChapterIds() throws Exception{
		List<Chapter> chapters = chapterMapper.selectByExample(null);
		String a = "";
		for(int i=0;i< chapters.size();i++){
		   a += chapters.get(i).getChapterid()+",";
		}
		a = a.substring(0, a.length()-1);
		return a;
	}
	
	@RequestMapping(value = "/uploadVedio") 
		public @ResponseBody ResultReturn uploadVedio(
			@RequestParam(value = "file", required = false) MultipartFile file,
			String sectorName, Integer chapterId, Integer sectorNameId, HttpServletRequest request) {
		ResultReturn data = new ResultReturn();
	    Sector sector = new Sector();
	    sector.setChapterid(chapterId);
	    sector.setSectornameid(sectorNameId);
		sector.setSectorname(sectorName);
		if(!CheckParameter.checkParameterNullOrEmpty(file) && !CheckParameter.checkParameterNullOrEmpty(file.getOriginalFilename()))
		{
			String name = file.getOriginalFilename(); // 获取文件名
			String parentPath = request.getSession().getServletContext().getRealPath("/");
			String path = parentPath+"static/pdf"; 
			String fileName = new Date().getTime()+""+new Random().nextInt(10000)+"_"+name.substring(name.lastIndexOf('.'));
			File targetFile = new File(path, fileName);
			String databaseStorePath = "static/pdf"+ "/" + fileName;
		    if(!targetFile.exists()){  
				try {
					byte[] buf = file.getBytes();// 文件二进制
					OutputStream os = new FileOutputStream(targetFile);
					os.write(buf);
					os.flush();
					os.close();
					sector.setPdfurl(databaseStorePath);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
	    if(sectorMapper.insert(sector) == 0){
	    	data.setReturnCode(CodeType.FAILURE);
	    }
	    else
	    {
	    	data.setReturnCode(CodeType.SUCCESS);
	    }
		return data;
	}
	
	
	@RequestMapping(value = "/deleteSector")
	public @ResponseBody ResultReturn deleteChat(Integer sectorId){
		ResultReturn data = new ResultReturn();
		int i = sectorMapper.deleteByPrimaryKey(sectorId);
		if(i == 0){
			data.setReturnCode(CodeType.FAILURE);
		}else{
			data.setReturnCode(CodeType.SUCCESS);
		}
		return data;
	}
	
	@RequestMapping(value = "/showExistSectionList")
	public @ResponseBody ResultReturn showExistSectionList(Integer chapterId){
		ResultReturn data = new ResultReturn();
		SectorExample sectorExample = new SectorExample();
		Criteria criteria = sectorExample.createCriteria();
		criteria.andChapteridEqualTo(chapterId);
		List<Sector> sectors = sectorMapper.selectByExample(sectorExample);
		data.setReturnCode(CodeType.SUCCESS);
		data.setMapField("sectors", sectors);
		return data;
	}
	
	@RequestMapping(value = "/showDeleteSectorList")
	public @ResponseBody ResultReturn showDeleteSectorList(Integer chapterId){
		ResultReturn data = new ResultReturn();
		SectorExample sectorExample = new SectorExample();
		Criteria criteria = sectorExample.createCriteria();
		criteria.andChapteridEqualTo(chapterId);
		List<Sector> sectors = sectorMapper.selectByExample(sectorExample);
		data.setReturnCode(CodeType.SUCCESS);
		data.setMapField("sectors", sectors);
		return data;
	}
	
	@RequestMapping(value = "/showEditSector")
	public String showEditSector(Model model, Integer sectorId)
	{
		Sector sector = sectorMapper.selectByPrimaryKey(sectorId);
		model.addAttribute("sector", sector);
		return "admin/showEditSector";
	}
	
	@RequestMapping(value = "/modifySector")
	public @ResponseBody ResultReturn modifySector(MultipartFile file,
			String sectorName, Integer sectorId, Integer sectorNameId, HttpServletRequest request)
	{
		ResultReturn data = new ResultReturn();
	    Sector sector = new Sector();
	    sector.setSectorid(sectorId);
	    sector.setSectornameid(sectorNameId);
		sector.setSectorname(sectorName);
		if(!CheckParameter.checkParameterNullOrEmpty(file) && !CheckParameter.checkParameterNullOrEmpty(file.getOriginalFilename()))
		{
			String name = file.getOriginalFilename(); // 获取文件名
			String parentPath = request.getSession().getServletContext().getRealPath("/");
			String path = parentPath+"static/pdf"; 
			String fileName = new Date().getTime()+""+new Random().nextInt(10000)+"_"+name.substring(name.lastIndexOf('.'));
			File targetFile = new File(path, fileName);
			String databaseStorePath = "static/pdf"+ "/" + fileName;
		    if(!targetFile.exists()){  
				try {
					byte[] buf = file.getBytes();// 文件二进制
					OutputStream os = new FileOutputStream(targetFile);
					os.write(buf);
					os.flush();
					os.close();
					sector.setPdfurl(databaseStorePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
	    }
	    if(sectorMapper.updateByPrimaryKeySelective(sector) == 0){
	    	data.setReturnCode(CodeType.FAILURE);
	    }else{
	    	data.setReturnCode(CodeType.SUCCESS);
	    }
		return data;
	}
}

