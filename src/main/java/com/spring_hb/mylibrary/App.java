package com.spring_hb.mylibrary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.te.mylibrary.config.AllConfig;
import com.te.mylibrary.controller.MyController;
import com.te.mylibrary.dto.Actor;
import com.te.mylibrary.dto.Director;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello...........");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sp_hb");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AllConfig.class);
		Actor actor = (Actor) applicationContext.getBean("actor_object");
		Director director = (Director) applicationContext.getBean("director_object");
		transaction.begin();
		entityManager.persist(actor);
		entityManager.persist(director);
		transaction.commit();
		MyController controller = (MyController) applicationContext.getBean("controller");
		controller.startWork();
		

	}
}
