package test;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Category;
import bean.Word;

public class hibernatetest {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Category c = (Category) s.get(Category.class, 1);
        Set<Word> words = c.getWords();
        System.out.println(words);
        

        
        s.getTransaction().commit();
        s.close();
        sf.close();	
	}

}
