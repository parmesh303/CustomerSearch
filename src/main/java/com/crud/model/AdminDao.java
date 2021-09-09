package com.crud.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdminDao {

	
	private SessionFactory factory ;
	private Session session;
	private Transaction t;
	
	private Configuration con = new Configuration().configure("hibernate.cfg.xml");
	public void saveData(Movie m) 
	{
		
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		session .save(m);
		t.commit();
		
	}
	
	@SuppressWarnings("rawtypes")
	public List displayData() {
		
	
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list = session.createQuery("from Movie").list();
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List searchData(Movie m) 
	{
		List li=new ArrayList();
	
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list = session.createQuery("from Movie").list();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			Movie mov=(Movie)it.next();
			if((m.getMovieId()==mov.getMovieId()) || (m.getMovieName().equals(mov.getMovieName())  || (m.getLocation().equals(mov.getLocation()) )))
			{
				Movie obj=new Movie();
				obj.setMovieId(mov.getMovieId());
				obj.setMovieName(mov.getMovieName());
				obj.setPrice(mov.getPrice());
				obj.setCinemaHall(mov.getCinemaHall());
				obj.setLocation(mov.getLocation());
				obj.setLanguage(mov.getLanguage());
				li.add(obj);
			}
		}
		return li;
	}
	public void updateData(Movie m) 
	{

		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		Movie obj = session.get(Movie.class, m.getMovieId());
		obj.setMovieName(m.getMovieName());
		obj.setCinemaHall(m.getCinemaHall());
		obj.setPrice(m.getPrice());
		obj.setLocation(m.getLocation());
		obj.setLanguage(m.getLanguage());
		session.update(obj);
		t.commit();
	}
	public void deleteData(Movie m)
	{
	
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		Movie obj = session.get(Movie.class, m.getMovieId());
		session.delete(obj);
		t.commit();
	}
	

	

}
