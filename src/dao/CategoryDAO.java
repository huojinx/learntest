package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Category;
import bean.Knowledge;
import bean.Word;

public class CategoryDAO {

	public CategoryDAO() {
		// TODO Auto-generated constructor stub
	}
	//����ĳ������µĵ��ʺ�����
	public Set<Word> listWords(int id){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Category c = (Category) s.get(Category.class, id);
        Set<Word> words = c.getWords();

        

        
        s.getTransaction().commit();
        s.close();
        sf.close();	
        return words;
	}
	
	//�������
	public void add(String name) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Category c = new Category();
        c.setName(name);

        s.save(c);

        
        s.getTransaction().commit();
        s.close();
        sf.close();	
        return ;
	}
	//��������б�
	public List<Category> list(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Query q = s.createQuery("from Category");
        List<Category> categories = q.list();

        

        
        s.getTransaction().commit();
        s.close();
        sf.close();	
        return categories;
	}
	//��ӡ����б�
	public void printList() {
		List<Category> cs = list();
		System.out.println("Ӣ�����");
		for(Category c: cs) {
			System.out.println(c.getId()+"\t"+c.getName());
		}
	}
	
	public void update(int id,String name) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
        Session s = sf.openSession();
        s.beginTransaction();
        
        Category c = (Category)s.get(Category.class, id);
        c.setName(name);
       

        s.save(c);

        
        s.getTransaction().commit();
        s.close();
        sf.close();	
        
	}
}
