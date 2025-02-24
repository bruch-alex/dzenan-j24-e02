package org.example.util;

import org.example.entity.manytomany.Project;
import org.example.entity.manytomany.Student;
import org.example.entity.onetomany.Customer;
import org.example.entity.onetomany.PhoneNumber;
import org.example.entity.onetoone.Employee;
import org.example.entity.onetoone.License;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate-config.xml");
    configuration.addAnnotatedClass(Employee.class);
    configuration.addAnnotatedClass(License.class);
    configuration.addAnnotatedClass(Customer.class);
    configuration.addAnnotatedClass(PhoneNumber.class);
    configuration.addAnnotatedClass(Student.class);
    configuration.addAnnotatedClass(Project.class);

    return configuration.buildSessionFactory();
  }

  public static SessionFactory getSessionFactory() {
    return SESSION_FACTORY;
  }
}
