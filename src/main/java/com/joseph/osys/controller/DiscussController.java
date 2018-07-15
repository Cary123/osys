package com.joseph.osys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joseph.osys.Exception.ParameterException;
import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.mapper.QuestionMapper;
import com.joseph.osys.mapper.QuestionanswerMapper;
import com.joseph.osys.mapper.UserMapper;
import com.joseph.osys.model.AnswerUser;
import com.joseph.osys.model.QuestionUser;
import com.joseph.osys.pojos.Question;
import com.joseph.osys.pojos.Questionanswer;
import com.joseph.osys.pojos.QuestionanswerExample;
import com.joseph.osys.pojos.User;
import com.joseph.osys.pojos.QuestionanswerExample.Criteria;
import com.joseph.osys.service.DiscussService;

@Controller
@RequestMapping(value = "/main")
public class DiscussController {
	@Autowired
	private QuestionMapper questionMapper;

	@Autowired
	private QuestionanswerMapper questionanswerMapper;

	@Autowired
	private DiscussService discussService;

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = "/discuss")
	public String discuss(Model model) {
		return showQuestionList(model, null,
				null);
	}

	@RequestMapping(value = "/publishQuestion")
	public @ResponseBody ResultReturn publishQuestion(Model model, String editorValue, HttpSession session) {
		ResultReturn data = new ResultReturn();
		try {
			String content = editorValue;
			Question question = new Question();
			User user = (User) session.getAttribute("currentUser");
			user.setPassword(null);
			question.setCreater(user.getUsername());
			question.setQuestioncontent(content);
			question.setQuestiontime(new Date());
			questionMapper.insert(question);
			data.setReturnCode(CodeType.SUCCESS);
			data.setMapField("question", question);
			data.setMapField("user", user);
		} catch (Exception e) {
			data.setReturnCode(CodeType.FAILURE);
		}
		return data;
	}

	@RequestMapping(value = "/showQuestionList")
	public String showQuestionList(Model model, String keywords,
			Integer currentPage) {
		HashMap<String, Object> hashMap;
		try {
			if (currentPage == null) {
				currentPage = 1;
			}
			hashMap = discussService.queryQuestionList(keywords, currentPage,20);
			List<Question> questions = (List<Question>) hashMap.get("questionList");
			List<QuestionUser> questionList = new ArrayList<QuestionUser>();
			for (Question question : questions) {
				QuestionUser quser = new QuestionUser();
				if (question != null) {
					Questionanswer answer =null;
					QuestionanswerExample example = new QuestionanswerExample();
					Criteria criteria = example.createCriteria();
					criteria.andQuestionidEqualTo(question.getQuestionid());
					example.setOrderByClause("answerid desc");
					List<Questionanswer> answers = questionanswerMapper.selectByExample(example);
					if(answers != null && answers.size() >0)
					{
						answer = answers.get(0);
					}
					User user = userMapper.selectByPrimaryKey(question.getCreater());
					user.setPassword(null);
					quser.setQuestion(question);
					quser.setUser(user);
					quser.setAnswer(answer);
					questionList.add(quser);
				}
			}
			model.addAttribute("questionList", questionList);
			model.addAttribute("totalCount", hashMap.get("totalCount"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("keywords", keywords);
		} catch (ParameterException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main/discuss/discussIndex";
	}
	
	
	@RequestMapping(value = "/publishAnswer")
	public @ResponseBody ResultReturn publishAnswer(Model model, Integer questionId, String editorValue, HttpSession session) {
		ResultReturn data = new ResultReturn();
		try {
			String content = editorValue;
			Questionanswer answer = new Questionanswer();
			User user = (User) session.getAttribute("currentUser");
			user.setPassword(null);
			answer.setCreater(user.getUsername());
			answer.setAnswercontent(content);
			answer.setAnswertime(new Date());
			answer.setQuestionid(questionId);
			questionanswerMapper.insert(answer);
			data.setReturnCode(CodeType.SUCCESS);
			data.setMapField("answer", answer);
			data.setMapField("user", user);
		} catch (Exception e) {
			data.setReturnCode(CodeType.FAILURE);
		}
		return data;
	}

	@RequestMapping(value = "/showAnswerList")
	public String showAnswerList(Model model, Integer id) {
		try {
			Question question = questionMapper.selectByPrimaryKey(id);
			User user = userMapper.selectByPrimaryKey(question.getCreater());
			QuestionUser quser = new QuestionUser();
			quser.setUser(user);
			quser.setQuestion(question);
			
			QuestionanswerExample example = new QuestionanswerExample();
			Criteria criteria = example.createCriteria();
			criteria.andQuestionidEqualTo(id);
			example.setOrderByClause("answerid desc");
			List<Questionanswer> questions = questionanswerMapper.selectByExampleWithBLOBs(example);
			List<AnswerUser> answers = new ArrayList<AnswerUser>();
		    for (Questionanswer questionanswer : questions) {
		    	AnswerUser ans = new AnswerUser();
				if(questionanswer != null){
					if(questionanswer.getCreater() != null){
						User tempUser = userMapper.selectByPrimaryKey(questionanswer.getCreater());
						ans.setAnswer(questionanswer);
						ans.setUser(tempUser);
						answers.add(ans);
					}
				}
			}
			model.addAttribute("question", quser);
			model.addAttribute("answer", answers);
			model.addAttribute("count", answers.size());
		} catch (ParameterException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main/discuss/answer";
	}
}
