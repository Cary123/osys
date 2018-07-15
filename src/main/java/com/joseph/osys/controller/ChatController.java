package com.joseph.osys.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.mapper.NoteMapper;
import com.joseph.osys.pojos.Note;

@Controller
public class ChatController {
	
	@Autowired
	public NoteMapper noteMapper;
	
	@RequestMapping(value = "/addChatShow")
	public String addChatShow() throws Exception {
		return "admin/addChat";
	}
	
	@RequestMapping(value = "/deleteChatShow")
	public String deleteChatShow(HttpSession session) throws Exception {
		List<Note> notes = noteMapper.selectByExample(null);
		session.setAttribute("notes", notes);
		return "admin/deleteChat";
	}
	
	@RequestMapping(value = "/listChatShow")
	public String listChatShow(HttpSession session) throws Exception {
		List<Note> notes = noteMapper.selectByExample(null);
		session.setAttribute("notes", notes);
		return "admin/listChat";
	}
	
	@RequestMapping(value = "/addChat")
	public @ResponseBody ResultReturn addChat(String noteDes,String sectorId) throws Exception {
		ResultReturn data = new ResultReturn();
		Note note= new Note();
		note.setBookid(Integer.parseInt(sectorId));
		note.setNotecontent(noteDes);
		note.setNotetime(new Date());
		note.setCreater("admin");
		int i = noteMapper.insert(note);
		if(i!=0){
			data.setReturnCode(CodeType.SUCCESS);
		}else{
			data.setReturnCode(CodeType.FAILURE);
		}
		return data;
	}
	
	@RequestMapping(value = "/deleteChat")
	public @ResponseBody String deleteChat(String noteid){
		int i = noteMapper.deleteByPrimaryKey(Integer.parseInt(noteid));
		if(i!=0){
			return "success";
		}else{
			return "failed";
		}
	}
}
