package org.example;

import jakarta.persistence.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String tech;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Student{id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
    public void updateStudent(int id, String newName, String newTech) {
        EntityManager em = Persistence
                .createEntityManagerFactory("studentPU")
                .createEntityManager();

        try {
            em.getTransaction().begin();

            Student student = em.find(Student.class, id);

            if (student != null) {
                student.setName(newName);
                student.setTech(newTech);
            }

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
}