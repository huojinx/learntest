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
				System.out.println( //¼��ģʽ�£������������-1�˳�ģʽ��
						"\n++++++++++++++++++++++++++++++++++++++++++++++++++\n"
						+ "\t\t�˵�\n\n"
						+ "\t1.��ѯ���\t\t2.��ѯ֪ʶ�б�\n\n"
						+ "\t3.¼�뵥��\t\t4.¼��֪ʶ��\n\n"
						+ "\t5.���Ե���\t\t6.����֪ʶ��\n\n"
						+ "\t7.����Ӣ�ﵥ�����\t\t8.����֪ʶ���\n\n"
						+ "\t30.����\t\t0.�˳�\n\n"
						+ "++++++++++++++++++++++++++++++++++++++++++++++++++"					
						);
			}
			
			System.out.print("������ѡ�");
			
			try {
				num = Integer.parseInt(in.readLine());
			}catch(NumberFormatException e) {
				num = 9999;
			}

			switch (num) {
				case 1:
					service.listCategory();
					System.out.println("�������������...");
					in.readLine();
					break;
				case 2:
					service.listIdea();
					System.out.println("�������������...");
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
							"\n++++++++++++++++++++++++++++++++++++++++++++++++++\n"  //Ҫ���ӵĹ��ܡ�
									+ "\t\t   ����\n\n"
									+ "\t31.�޸����\t\t32.�޸�֪ʶ���\n\n"
									+ "\t33.��ѯ�ʹ����ʻ�֪ʶ��\n\n"
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
					System.out.println("���������������롣");
			}
		}
		System.out.println("���˳���");
	}
	
	
	
	
}
