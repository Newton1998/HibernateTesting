package tests;

import model.Employee;
import model.Project;
import model.Rank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test1 {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ManyToMany");

        EntityManager entitymanager = emfactory.createEntityManager();

        Employee employee1 = new Employee("Vadim", Rank.JUNIOR);
        Employee employee2 = new Employee("Serhii", Rank.SENIOR);

        Project project1 = new Project("java");
        Project project2 = new Project(".net");
        Project project3 = new Project("php");
        Project project4 = new Project("groovy");

        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);

        employee2.getProjects().add(project2);
        employee2.getProjects().add(project3);
        employee2.getProjects().add(project4);

        project1.getEmployees().add(employee1);

        project2.getEmployees().add(employee1);
        project2.getEmployees().add(employee2);

        project3.getEmployees().add(employee2);

        project4.getEmployees().add(employee2);

        entitymanager.getTransaction().begin();

        entitymanager.persist(employee1);
        entitymanager.persist(employee2);
        entitymanager.persist(project1);
        entitymanager.persist(project2);
        entitymanager.persist(project3);
        entitymanager.persist(project4);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}
