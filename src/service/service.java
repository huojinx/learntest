package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.dom4j.Branch;

import bean.Knowledge;
import bean.Word;
import dao.CategoryDAO;
import dao.IdeaDAO;
import dao.KnowledgeDAO;
import dao.WordsDAO;

public class service {
	
	static WordsDAO wordsDAO = new WordsDAO();
	static CategoryDAO categoryDAO = new CategoryDAO();
	static KnowledgeDAO knowledgeDAO = new KnowledgeDAO();
	static IdeaDAO ideaDAO = new IdeaDAO();
	
	public static void init() {  //先预加载
		categoryDAO.list();
	}

	
	public static void addwords() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.print("请输入类别(输入-1退出)：");
				int id = Integer.parseInt(br.readLine()); 
				if(id==-1) break;
				if(id==0) {
					listCategory();
					System.out.println("请输入类别: ");
					id = Integer.parseInt(br.readLine());
				}
				System.out.print("请输入单词：");
				String word = br.readLine();
				System.out.print("请输入单词释义：");
				String meaning = br.readLine();
				wordsDAO.add(word, meaning, id);
				System.out.println("录入成功");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入错误");
		}

		System.out.println("runing end.");
	}
	
	public static void addknowledge() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.print("请输入类别(输入-1退出)：");
				int id = Integer.parseInt(br.readLine()); 
				if(id==-1) break;
				if(id==0) {
					listIdea();
					System.out.println("请输入类别：");
					id = Integer.parseInt(br.readLine());
				}
				System.out.print("请输入名称：");
				String describe = br.readLine();
				System.out.print("请输入单词释义（可无）：");
				String remark = br.readLine();
				knowledgeDAO.add(describe, id);
				System.out.println("录入成功");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入错误");
		}

		System.out.println("runing end.");
	}
	
	public static void addCategory() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
				System.out.print("输入类别名称：");
				String name = br.readLine();
				if(name=="-1") return ;
				categoryDAO.add(name);
				System.out.println("录入成功");

		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("runing end.");
	}
	
	public static void addIdea() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("请输入类别名称：");
			String name = in.readLine();
			if(name=="-1") return ;
			ideaDAO.add(name);
			System.out.println("录入成功");
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	public static void listCategory() {
		categoryDAO.printList();
	}
	public static void listIdea() {
		ideaDAO.list();
	}
	
	public static void learnwords() {
		System.out.println("开始测验单词");
		System.out.println("请输入类别：");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			int id = Integer.parseInt(in.readLine());
			if(id==0) {
				listCategory();
				System.out.println("请输入类别: ");
				id = Integer.parseInt(in.readLine());
			}
			
			Set<Word> words = categoryDAO.listWords(id);
			
			for(Word word :words) {
				System.out.println("\t释义："+word.getMeaning());
				in.readLine();
				System.out.println("\t拼写："+word.getSpelling());
				in.readLine();
			}
			System.err.println("\t\t测验结束。");
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("输入错误");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("测试错误");
		}
		
	}
	
	public static void learnknowledges() {
		System.out.println("开始测验知识点");
		System.out.println("请输入类别：");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			int id = Integer.parseInt(in.readLine());
			if(id==0) {
				listIdea();
				System.out.println("请输入类别：");
				id = Integer.parseInt(in.readLine());
			}
			
			Set<Knowledge> knowledges = ideaDAO.listknowledge(id);
			
			for(Knowledge k:knowledges) {
				System.out.println("\t名称："+k.getDescribe());
				in.readLine();
			}
			System.err.println("\t\t测验结束。");
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("输入错误");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("测试错误");
		}
	}
	
	public static void updateIdea() {
		
		System.out.println("开始修改知识类别");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("请输入类别ID:");
			int id = Integer.parseInt(br.readLine());
			if(id==0) {
				listCategory();
				System.out.println("请输入类别ID：");
				id = Integer.parseInt(br.readLine());
			}
			System.out.print("请输入修改后的名称:");
			String name = br.readLine();
			ideaDAO.update(id, name);
			System.out.println("修改成功！");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("修改失败！");
		}
		
	}
	
	public static void updateCategory() {
		System.out.println("开始修改英语单词类别");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("请输入类别ID:");
			int id = Integer.parseInt(br.readLine());
			if(id==0) {
				listIdea();
				System.out.println("请输入类别ID：");
				id = Integer.parseInt(br.readLine());
			}
			System.out.print("请输入修改后的名称:");
			String name = br.readLine();
			categoryDAO.update(id, name);
			System.out.println("修改成功！");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("修改失败！");
		}
	}
	//其实可以考虑使用动态，可以优化代码
	public static  void dealDetail() {
		System.out.println("请输入是哪种类别：a.英语单词类别；b.知识类别");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine();
			if(str.equals("b")) {
				System.out.println("类别有以下这些");
				listIdea();
				System.out.print("请输入类别ID:");
				int id = Integer.parseInt(br.readLine());
				
				Set<Knowledge> knowledges = ideaDAO.listknowledge(id);
				Knowledge[] ks = new Knowledge[knowledges.size()];
				knowledges.toArray(ks);
				Arrays.sort(ks,(a,b)->(a.getId()-b.getId()));
				for(Knowledge k: ks) {
					
					System.out.printf("%-8d%-24s%s%n",k.getId(),k.getDescribe(),k.getRemarks());
				}
				
				System.out.println("是否修改知识点（yes or no):");
				if(br.readLine().equals("no")) return;
				System.out.println("请输入知识点ID:");
				int id2 = Integer.parseInt(br.readLine());
				System.out.println("请输入内容：");
				String s = br.readLine();
				knowledgeDAO.update(id2, s);
				System.out.println("修改成功！");
			}
			else if(str.equals("a")) {
				System.out.println("类别有以下这些");
				listCategory();
				System.out.print("请输入类别ID:");
				int id = Integer.parseInt(br.readLine());
				
				Set<Word> words =  categoryDAO.listWords(id);
				Word[] wds = new Word[words.size()];
				words.toArray(wds);
				Arrays.sort(wds,(a,b)->(a.getId()-b.getId()));
				for(Word w :wds) {
					System.out.printf("%-8d%-24s%s%n",w.getId(),w.getSpelling(),w.getMeaning());
				}
				
				System.out.println("是否修改单词（yes or no):");
				if(br.readLine().equals("no")) return;
				System.out.println("请输入知识点ID:");
				int id2 = Integer.parseInt(br.readLine());
				System.out.println("请输入拼写或释义：");
				String s = br.readLine();
				if(s.charAt(s.length()-1)<250) {
					wordsDAO.updatespelling(id2, s);
				}else {
					wordsDAO.updatemeaning(id2, s);
				}
				System.out.println("修改成功！");
			}else {
				System.out.println("输入错误");
			}
			
		}catch(NumberFormatException e) {
			System.out.println("输入错误！");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("运行异常！");
		}
	}
	
	

	
}
