package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AlienName an = new AlienName();
    	
    	an.setFname("Ajith");
    	an.setMname("Sam");
    	an.setLname("Raj");
    	
    	Alien sam = new Alien();
        
        sam.setAid(112);
        sam.setColor("Green");
        sam.setAname(an);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
       // sam = (Alien) session.get(Alien.class, 104);
        
        session.save(sam);
        
        tx.commit(); 
        
        System.out.println(sam);
               
        
    }
}
