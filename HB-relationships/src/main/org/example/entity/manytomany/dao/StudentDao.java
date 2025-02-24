package org.example.entity.manytomany.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import org.example.entity.manytomany.Student;
import org.example.entity.onetomany.Customer;
import org.example.entity.onetomany.PhoneNumber;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

  private EntityManager entityManager;

  public StudentDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Student save(Student student) {
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(student);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
      System.out.println("Error persisting Student: " + e.getMessage());
    }
    return student;
  }

}
