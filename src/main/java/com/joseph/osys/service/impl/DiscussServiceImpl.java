package com.joseph.osys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.joseph.osys.Exception.ParameterException;
import com.joseph.osys.mapper.QuestionMapper;
import com.joseph.osys.pojos.Question;
import com.joseph.osys.pojos.QuestionExample;
import com.joseph.osys.service.DiscussService;
import com.joseph.osys.util.CheckParameter;

public class DiscussServiceImpl implements DiscussService {

	@Autowired
	private QuestionMapper questionMapper;
	
	public HashMap<String, Object> queryQuestionList(String keywords,
			Integer currentPage, Integer pageSize) throws ParameterException,
			Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Question> questionList = new ArrayList<Question>();
		if (CheckParameter.checkParameterNullOrEmpty(pageSize)) {
			pageSize = 20;
		}
		if (CheckParameter.checkParameterNullOrEmpty(currentPage)) {
			currentPage = 1;
		}
		QuestionExample example = new QuestionExample();
		if (!CheckParameter.checkParameterNullOrEmpty(keywords)) {
			example.setKeywords(keywords);
		}
		int totalCount = questionMapper.countByExample(example);
		if (totalCount % pageSize == 0) {
			totalCount = totalCount / pageSize;
		} else {
			totalCount = totalCount / pageSize + 1;
		}
		example.setLimit(pageSize);
		example.setStart(pageSize * (currentPage - 1));
		example.setOrderByClause("questionid desc");
		questionList = (ArrayList<Question>) questionMapper.selectByExampleWithBLOBs(example);
		hashMap.put("totalCount", totalCount);
		hashMap.put("questionList", questionList);
		System.out.println(totalCount + "|" + questionList.size());
		return hashMap;
	}

}
