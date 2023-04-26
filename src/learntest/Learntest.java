package learntest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import bean.Word;
import dao.CategoryDAO;
import dao.WordsDAO;
import service.service;

public class Learntest {


	
	public static void main(String[] args) throws IOException{
		int num = 9999;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		service.init();
		
		while(num!=0) {
			if(num!=30) {
				System.out.println( //录入模式下，在类别下输入-1退出模式。
						"\n++++++++++++++++++++++++++++++++++++++++++++++++++\n"
						+ "\t\t菜单\n\n"
						+ "\t1.查询类别\t\t2.查询知识列表\n\n"
						+ "\t3.录入单词\t\t4.录入知识点\n\n"
						+ "\t5.测试单词\t\t6.测试知识点\n\n"
						+ "\t7.增加英语单词类别\t\t8.增加知识类别\n\n"
						+ "\t30.其他\t\t0.退出\n\n"
						+ "++++++++++++++++++++++++++++++++++++++++++++++++++"					
						);
			}
			
			System.out.print("请输入选项：");
			
			try {
				num = Integer.parseInt(in.readLine());
			}catch(NumberFormatException e) {
				num = 9999;
			}

			switch (num) {
				case 1:
					service.listCategory();
					System.out.println("输入任意键继续...");
					in.readLine();
					break;
				case 2:
					service.listIdea();
					System.out.println("输入任意键继续...");
					in.readLine();
					break;
				case 3:
					service.addwords();
					break;
				case 4:
					service.addknowledge();
					break;
				case 5:
					service.learnwords();
					break;
				case 6:
					service.learnknowledges();
					break;
				case 7:
					service.addCategory();
					break;
				case 8:
					service.addIdea();
					break;
				case 30:
					System.out.println( 
							"\n++++++++++++++++++++++++++++++++++++++++++++++++++\n"  //要增加的功能。
									+ "\t\t   其他\n\n"
									+ "\t31.修改类别\t\t32.修改知识类别\n\n"
									+ "\t33.查询和处理单词或知识点\n\n"
									+ "++++++++++++++++++++++++++++++++++++++++++++++++++"		
							);
					break;
				case 31:
					service.updateCategory();
					break;
				case 32:
					service.updateIdea();
					break;
				case 33:
					service.dealDetail();
					break;
				case 0:
					break;
				default:
					System.out.println("输入错误，请从新输入。");
			}
		}
		System.out.println("已退出。");
	}
	
	
	
	
}
