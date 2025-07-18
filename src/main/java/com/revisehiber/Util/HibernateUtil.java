package com.revisehiber.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static SessionFactory sessionFactory;
  
  static {
    try {
      sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();
      
    } catch (Exception e) {
      throw new RuntimeException("SessionFactory creation failed: " + e.getMessage());
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
