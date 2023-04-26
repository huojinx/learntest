package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bean.Knowledge;
import dao.CategoryDAO;
import dao.IdeaDAO;
import dao.KnowledgeDAO;
import dao.WordsDAO;

class serviceTest{

	CategoryDAO categoryDAO = new CategoryDAO();
	WordsDAO wordsDAO = new WordsDAO();
	IdeaDAO ideaDAO = new IdeaDAO();
	KnowledgeDAO knowledgeDAO = new KnowledgeDAO();

	
	@Test
	void add() {
		wordsDAO.add("knowledge", "n.知识", 6);
		wordsDAO.add("describe", "v.描述；形容", 6);
		wordsDAO.add("remark", "v.评论", 6);
		wordsDAO.add("revise", "v.复习", 6);
		wordsDAO.add("receive", "v.收到,接到", 6);
		wordsDAO.add("factory", "n.工厂", 1);
		wordsDAO.add("configure", "v.安装", 1);
		wordsDAO.add("transaction", "n.交易，买卖，业务", 1);
//		
//		System.out.println("Adding finished.");
//		String[] str = {"插入","删除","修改","条件查询","创建表","查询表结构"};
//		for(int i=0;i<str.length;i++) {
//			knowledgeDAO.add(str[i],2);
//		}

		
	}

}
