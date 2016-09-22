package cn.edu.sdut.softlab.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;
public class Client {

  /**
   * main method.
   * @param args 
   */
  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
            .configure() // configures settings from hibernate.cfg.xml
            .buildSessionFactory();
    // create a couple of events...
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(new Article("Our very first article by hibernate annotation!", new Date()));
    session.save(new Article("A follow up artcle by hibernate annotation", new Date()));
    session.save(new Article("A third article by hibernate annotation", new Date()));
    session.getTransaction().commit();
    session.close();

    // now lets pull events from the database and list them
    session = sessionFactory.openSession();
    session.beginTransaction();
    List result = session.createQuery("from Article").list();
    for (Article article : (List<Article>) result) {
      System.out.println(article);
    }
    session.getTransaction().commit();
    session.close();

    if (sessionFactory != null) {
      sessionFactory.close();
    }
  }
}
