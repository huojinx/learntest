package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import bean.Knowledge;
import dao.IdeaDAO;

public class printin {

	public printin() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
//		IdeaDAO ideaDAO = new IdeaDAO();
//		java.util.Set<Knowledge> ks =  ideaDAO.listknowledge(3);
//		Knowledge[] ks1 = new Knowledge[ks.size()];
//		ks.toArray(ks1);
//		System.out.println(ks1[2].getDescribe());
//		Arrays.sort(objects,(a,b)->(a.toString().compareTo(b.toString())));
//		for(Object b: objects) {
//			Knowledge k = (Knowledge)b;
//			System.out.println(k.getId()+"\t"+k.getDescribe()+"\t\t"+k.getRemarks());
//		}
		System.out.printf("%d\t%-30s%s",1,"a ggffgfg","的地方的发射点的ttttttttttt");
		System.out.println();
		System.out.printf("%d\t%-30s%s%n",1,"a ggffgfgddgfdfgdf","的地方的发射点的");
		System.out.printf("%-8d%-24s%s%n",1,"a ","的地方射点的");
	}
}
