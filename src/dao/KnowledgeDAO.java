package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Category;
import bean.Idea;
import bean.Knowledge;
import bean.Word;

public class KnowledgeDAO {

	public KnowledgeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(String describe,int iid) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Idea idea = (Idea)s.get(Idea.class, iid);
        Knowledge k = new Knowledge();
        k.setDescribe(describe);
        k.setIdea(idea);
        
        s.save(k);
        
        s.getTransaction().commit();
        s.close();
        sf.close();
	}
	

	
	public List<Knowledge> list(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Query q = s.createQuery("from knowledge");
        List<Knowledge> ks = q.list();
        

        
        s.getTransaction().commit();
        s.close();
        sf.close();	
        return ks;
		
	}
	
	public void update(int id,String decribe) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        
        Knowledge knowledge = (Knowledge) s.get(Knowledge.class, id);
        knowledge.setDescribe(decribe);

        
        s.save(knowledge);
        
        s.getTransaction().commit();
        s.close();
        sf.close();		
	}
}
