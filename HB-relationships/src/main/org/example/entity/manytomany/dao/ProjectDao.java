package org.example.entity.manytomany.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.manytomany.Project;
import org.example.entity.manytomany.Student;
import org.hibernate.HibernateException;

public class ProjectDao {

  private EntityManager entityManager;

  public ProjectDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Project save(Project project) {
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(project);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
      System.out.println("Error persisting Project: " + e.getMessage());
    }
    return project;
  }

}
