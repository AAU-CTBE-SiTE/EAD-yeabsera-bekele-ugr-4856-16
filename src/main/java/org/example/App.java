
package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    // Create the EntityManagerFactory once
    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("studentPU");

    // Create an EntityManager whenever needed
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Find a student by ID
    public static Student getStudentById(int id) {
        EntityManager entityManager = getEntityManager();

        try {
            return entityManager.find(Student.class, id);
        } finally {
            entityManager.close();
        }
    }

    // Save a new student
    public static void createStudent(Student student) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(student);

            entityManager.getTransaction().commit();

            System.out.println("Student saved successfully!");

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    // Delete a student by ID
    public static void deleteStudentById(int id) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Student student =
                    entityManager.find(Student.class, id);

            if (student != null) {
                entityManager.remove(student);
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    public static void checkContains(int id) {
        EntityManager em = getEntityManager();

        try {
            Student student = em.find(Student.class, id);

            System.out.println("Is student managed? "
                    + em.contains(student));

        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {

        // Create and save a student
        Student student = new Student();
        student.setName("Abebe");
        student.setTech("Java");

        createStudent(student);
        checkContains(1);
        // Example: find a student
        Student foundStudent = getStudentById(1);

        if (foundStudent != null) {
            System.out.println("Student found: "
                    + foundStudent.getName());
        } else {
            System.out.println("Student not found!");
        }

        // Example: delete a student
        // deleteStudentById(1);
    }
}
