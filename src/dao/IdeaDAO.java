package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import bean.Idea;
import bean.Knowledge;


public class IdeaDAO {

	public void add(String name) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Idea idea = new Idea();
        idea.setName(name);
        
        s.save(idea);

        s.getTransaction().commit();
        s.close();
        sf.close();	
		
	}
	
	public void list() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Query q = s.createQuery("from Idea");
        List<Idea> ideas = q.list();
        System.out.println("知识类别：");
        for(Idea i : ideas) {
        	System.out.println(i.getId()+"\t"+i.getName());
        }
        


        s.getTransaction().commit();
        s.close();
        sf.close();	
	}
	
	public Set<Knowledge> listknowledge(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Idea d = (Idea)s.get(Idea.class, id);
        Set<Knowledge> ks = d.getKnowledges();
        
        


        s.getTransaction().commit();
        s.close();
        sf.close();	
        return ks;
	}
	
	public void update(int id,String name) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Idea bean = (Idea)s.get(Idea.class, id);
        bean.setName(name);
        
        s.save(bean);


        s.getTransaction().commit();
        s.close();
        sf.close();	
	}
}
