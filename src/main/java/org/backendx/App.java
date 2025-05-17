package org.backendx;

import org.backendx.config.AppConfig;
import org.backendx.dao.StudentDao;
import org.backendx.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);


//        StudentDao studentDao = new StudentDaoImpl();
        Student abhilash = new Student();
        abhilash.setStudentName("Abhidlash");
        abhilash.setMobile(99200);
        abhilash.setAddress("bldr");

        //studentDaoImpl.saveStudent(abhilash);

        studentDao.save(abhilash);
        List<Student> students = studentDao.findAll();
        students.forEach(System.out::println);

        Optional<Student> student = studentDao.findById(5);
        System.out.println("FINDING STUDENT WITH ID 5");
        System.out.println(student.get());
    }
}
