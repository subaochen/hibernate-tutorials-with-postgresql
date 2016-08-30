package cn.edu.sdut.softlab.hibernate.tutorial;

import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client{
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
		// create a couple of articles...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save( new Article( "Our very first article!", new Date() ) );
		session.save( new Article( "A follow up artcle",  new Date() ) );
        session.save( new Article( "A third article", new Date()));
		session.getTransaction().commit();
		session.close();

		// now lets pull articles from the database and list them
		session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from Article" ).list();
		for ( Article article : (List<Article>) result ) {
			System.out.println( article);
		}
        session.getTransaction().commit();
        session.close();

		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
    }
}
