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
	
	public static void init() {  //��Ԥ����
		categoryDAO.list();
	}

	
	public static void addwords() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.print("���������(����-1�˳�)��");
				int id = Integer.parseInt(br.readLine()); 
				if(id==-1) break;
				if(id==0) {
					listCategory();
					System.out.println("���������: ");
					id = Integer.parseInt(br.readLine());
				}
				System.out.print("�����뵥�ʣ�");
				String word = br.readLine();
				System.out.print("�����뵥�����壺");
				String meaning = br.readLine();
				wordsDAO.add(word, meaning, id);
				System.out.println("¼��ɹ�");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("�������");
		}

		System.out.println("runing end.");
	}
	
	public static void addknowledge() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.print("���������(����-1�˳�)��");
				int id = Integer.parseInt(br.readLine()); 
				if(id==-1) break;
				if(id==0) {
					listIdea();
					System.out.println("���������");
					id = Integer.parseInt(br.readLine());
				}
				System.out.print("���������ƣ�");
				String describe = br.readLine();
				System.out.print("�����뵥�����壨���ޣ���");
				String remark = br.readLine();
				knowledgeDAO.add(describe, id);
				System.out.println("¼��ɹ�");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("�������");
		}

		System.out.println("runing end.");
	}
	
	public static void addCategory() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
				System.out.print("����������ƣ�");
				String name = br.readLine();
				if(name=="-1") return ;
				categoryDAO.add(name);
				System.out.println("¼��ɹ�");

		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("runing end.");
	}
	
	public static void addIdea() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("������������ƣ�");
			String name = in.readLine();
			if(name=="-1") return ;
			ideaDAO.add(name);
			System.out.println("¼��ɹ�");
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
		System.out.println("��ʼ���鵥��");
		System.out.println("���������");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			int id = Integer.parseInt(in.readLine());
			if(id==0) {
				listCategory();
				System.out.println("���������: ");
				id = Integer.parseInt(in.readLine());
			}
			
			Set<Word> words = categoryDAO.listWords(id);
			
			for(Word word :words) {
				System.out.println("\t���壺"+word.getMeaning());
				in.readLine();
				System.out.println("\tƴд��"+word.getSpelling());
				in.readLine();
			}
			System.err.println("\t\t���������");
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("�������");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("���Դ���");
		}
		
	}
	
	public static void learnknowledges() {
		System.out.println("��ʼ����֪ʶ��");
		System.out.println("���������");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			int id = Integer.parseInt(in.readLine());
			if(id==0) {
				listIdea();
				System.out.println("���������");
				id = Integer.parseInt(in.readLine());
			}
			
			Set<Knowledge> knowledges = ideaDAO.listknowledge(id);
			
			for(Knowledge k:knowledges) {
				System.out.println("\t���ƣ�"+k.getDescribe());
				in.readLine();
			}
			System.err.println("\t\t���������");
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("�������");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("���Դ���");
		}
	}
	
	public static void updateIdea() {
		
		System.out.println("��ʼ�޸�֪ʶ���");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("���������ID:");
			int id = Integer.parseInt(br.readLine());
			if(id==0) {
				listCategory();
				System.out.println("���������ID��");
				id = Integer.parseInt(br.readLine());
			}
			System.out.print("�������޸ĺ������:");
			String name = br.readLine();
			ideaDAO.update(id, name);
			System.out.println("�޸ĳɹ���");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("�޸�ʧ�ܣ�");
		}
		
	}
	
	public static void updateCategory() {
		System.out.println("��ʼ�޸�Ӣ�ﵥ�����");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("���������ID:");
			int id = Integer.parseInt(br.readLine());
			if(id==0) {
				listIdea();
				System.out.println("���������ID��");
				id = Integer.parseInt(br.readLine());
			}
			System.out.print("�������޸ĺ������:");
			String name = br.readLine();
			categoryDAO.update(id, name);
			System.out.println("�޸ĳɹ���");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("�޸�ʧ�ܣ�");
		}
	}
	//��ʵ���Կ���ʹ�ö�̬�������Ż�����
	public static  void dealDetail() {
		System.out.println("���������������a.Ӣ�ﵥ�����b.֪ʶ���");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine();
			if(str.equals("b")) {
				System.out.println("�����������Щ");
				listIdea();
				System.out.print("���������ID:");
				int id = Integer.parseInt(br.readLine());
				
				Set<Knowledge> knowledges = ideaDAO.listknowledge(id);
				Knowledge[] ks = new Knowledge[knowledges.size()];
				knowledges.toArray(ks);
				Arrays.sort(ks,(a,b)->(a.getId()-b.getId()));
				for(Knowledge k: ks) {
					
					System.out.printf("%-8d%-24s%s%n",k.getId(),k.getDescribe(),k.getRemarks());
				}
				
				System.out.println("�Ƿ��޸�֪ʶ�㣨yes or no):");
				if(br.readLine().equals("no")) return;
				System.out.println("������֪ʶ��ID:");
				int id2 = Integer.parseInt(br.readLine());
				System.out.println("���������ݣ�");
				String s = br.readLine();
				knowledgeDAO.update(id2, s);
				System.out.println("�޸ĳɹ���");
			}
			else if(str.equals("a")) {
				System.out.println("�����������Щ");
				listCategory();
				System.out.print("���������ID:");
				int id = Integer.parseInt(br.readLine());
				
				Set<Word> words =  categoryDAO.listWords(id);
				Word[] wds = new Word[words.size()];
				words.toArray(wds);
				Arrays.sort(wds,(a,b)->(a.getId()-b.getId()));
				for(Word w :wds) {
					System.out.printf("%-8d%-24s%s%n",w.getId(),w.getSpelling(),w.getMeaning());
				}
				
				System.out.println("�Ƿ��޸ĵ��ʣ�yes or no):");
				if(br.readLine().equals("no")) return;
				System.out.println("������֪ʶ��ID:");
				int id2 = Integer.parseInt(br.readLine());
				System.out.println("������ƴд�����壺");
				String s = br.readLine();
				if(s.charAt(s.length()-1)<250) {
					wordsDAO.updatespelling(id2, s);
				}else {
					wordsDAO.updatemeaning(id2, s);
				}
				System.out.println("�޸ĳɹ���");
			}else {
				System.out.println("�������");
			}
			
		}catch(NumberFormatException e) {
			System.out.println("�������");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("�����쳣��");
		}
	}
	
	

	
}
