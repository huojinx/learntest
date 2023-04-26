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
		wordsDAO.add("knowledge", "n.֪ʶ", 6);
		wordsDAO.add("describe", "v.����������", 6);
		wordsDAO.add("remark", "v.����", 6);
		wordsDAO.add("revise", "v.��ϰ", 6);
		wordsDAO.add("receive", "v.�յ�,�ӵ�", 6);
		wordsDAO.add("factory", "n.����", 1);
		wordsDAO.add("configure", "v.��װ", 1);
		wordsDAO.add("transaction", "n.���ף�������ҵ��", 1);
//		
//		System.out.println("Adding finished.");
//		String[] str = {"����","ɾ��","�޸�","������ѯ","������","��ѯ��ṹ"};
//		for(int i=0;i<str.length;i++) {
//			knowledgeDAO.add(str[i],2);
//		}

		
	}

}
