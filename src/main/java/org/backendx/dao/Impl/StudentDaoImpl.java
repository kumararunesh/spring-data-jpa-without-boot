package org.backendx.dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.backendx.dao.StudentDao;
import org.backendx.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public class StudentDaoImpl  {
//
//   // @PersistenceContext(unitName = "mysqldb")
//    @Autowired
//    EntityManager entityManager ;
//
//
//    @Transactional
//    public void saveStudent(Student student) {
//        entityManager.persist(student);
//        System.out.println("record inserted");
//
//    }
//
//    public List<Student> getStudents() {
//        return entityManager.createQuery("from Student").getResultList();
//    }
//
//}
