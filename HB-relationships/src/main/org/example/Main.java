package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.entity.manytomany.Project;
import org.example.entity.manytomany.Student;
import org.example.entity.manytomany.dao.ProjectDao;
import org.example.entity.manytomany.dao.StudentDao;
import org.example.entity.onetomany.Customer;
import org.example.entity.onetomany.PhoneNumber;
import org.example.entity.onetoone.Employee;
import org.example.entity.onetoone.License;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

  public static void main(String[] args) {

//    Employee employee = createEmployee();
//    System.out.println("Employee saved to db: " + employee);
//    Customer customer = createCustomer();
//    System.out.println("Customer saved to db: " + customer);

    Session session = HibernateUtil.getSessionFactory().openSession();

    StudentDao studentDao = new StudentDao(session);
    ProjectDao projectDao = new ProjectDao(session);

    // saving some data
    List<Project> projects = new ArrayList<>();
    Student student = new Student("Mickey", "Mouse", projects);
    Student student1 = new Student("Minnie", "Mouse", null);

    Project project = new Project("Project", null);
    Project project1 = new Project("Project1", null);
    projects.add(project);
    projects.add(project1);

    student1.setProjects(List.of(project1));

    studentDao.save(student);
    studentDao.save(student1);

  }

  public static Customer createCustomer() {
    Transaction transaction = null;
    Customer customer = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      List<PhoneNumber> numbers = new ArrayList<>();
      customer = new Customer("Mickey Mouse", numbers);
      numbers.add(new PhoneNumber("234234234"));
      numbers.add(new PhoneNumber("111111122"));

      session.persist(customer);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
      System.out.println("Error persisting Customer: " + e.getMessage());
    }
    return customer;
  }

  public static Employee createEmployee() {
    Transaction transaction = null;
    Employee employee = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      employee = new Employee("Mickey1", "Mouse1");
      License license = getLicenceById(201L, session);
      license.setDescription("description after update");
      employee.setLicense(license);
//      session.persist(license);
      session.persist(employee);

      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
      System.out.println("Error persisting Employee: " + e.getMessage());
    }
    return employee;
  }

  public static License getLicenceById(Long id, Session session) {
    License license = null;
    try {
      license = session.createQuery("select l from License l where l.id = :id", License.class)
          .setParameter("id", id).getSingleResult();
    } catch (HibernateException e) {
      System.out.println("Error reading Licence: " + e.getMessage());
    }
    return license;
  }

}