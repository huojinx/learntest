package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.infinispan.util.AddressAdapter;
import org.hibernate.cfg.Configuration;


import bean.Category;
import bean.Word;

public class WordsDAO {

	
	public void add(String spelling,String meaning,int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        spelling = spelling.toLowerCase();
        meaning = meaning.toLowerCase();
        meaning = meaning.replace("£»", ";").replace("£¬", ",").replace("£¨", "(").replace("£©", ")").replace("¡£",".");
        
        
        Category c = (Category) s.get(Category.class, id);
        Word w = new Word();
        w.setSpelling(spelling);
        w.setMeaning(meaning);
        w.setCategory(c);

        
        s.save(w);
        s.getTransaction().commit();
        s.close();
        sf.close();		
	}
	
	public List<Word> list(int id){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Query q = s.createQuery("from words");
        List<Word> words = q.list();
        

        
        s.getTransaction().commit();
        s.close();
        sf.close();	
        return words;
	}
	
	public void updatemeaning(int id,String meaning) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        
        Word w = (Word) s.get(Word.class, id);
        meaning = meaning.toLowerCase();
        meaning = meaning.replace("£»", ";").replace("£¬", ",").replace("£¨", "(").replace("£©", ")").replace("¡£",".");
        w.setMeaning(meaning);

        
        s.save(w);
        s.getTransaction().commit();
        s.close();
        sf.close();		
	}
	
	public void updatespelling(int id,String spelling) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        
        Word w = (Word) s.get(Word.class, id);
        w.setSpelling(spelling);

        
        s.save(w);
        s.getTransaction().commit();
        s.close();
        sf.close();		
	}

}
