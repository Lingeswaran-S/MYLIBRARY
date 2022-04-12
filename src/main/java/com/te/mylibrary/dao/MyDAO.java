package com.te.mylibrary.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.te.mylibrary.dto.Actor;
import com.te.mylibrary.dto.Director;
import com.te.mylibrary.dto.Movie;
import com.te.mylibrary.dto.MovieCast;
import com.te.mylibrary.dto.MovieRating;

public class MyDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("sp_hb");
	EntityManager entityManager = factory.createEntityManager();
	EntityTransaction transaction = entityManager.getTransaction();
	DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

//	public void myDAOprocess() {
//		BeanDefinitionBuilder b = BeanDefinitionBuilder.rootBeanDefinition(Actor.class)
//				.addPropertyValue("actName", "Lingessssssssss").addPropertyValue("actGender","MAle");
//		beanFactory.registerBeanDefinition("actor_object", b.getBeanDefinition());
//		beanFactory.getBean(Actor.class);
//		persistData(beanFactory.getBean(Actor.class));
//	}
	public void actorBeanCreate(String actorName, String actorGender) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Actor.class)
				.addPropertyValue("actName", actorName).addPropertyValue("actGender", actorGender);
		beanFactory.registerBeanDefinition("actor_object", builder.getBeanDefinition());
		beanFactory.getBean(Actor.class);
		persistData(beanFactory.getBean(Actor.class));
	}

	public void movieCastBeanCreate(String role) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(MovieCast.class)
				.addPropertyValue("role", role).addPropertyReference("actor", "actor_object")
				.addPropertyReference("movie","single_movie_object");
		beanFactory.registerBeanDefinition("moviecast_list_object", builder.getBeanDefinition());
		beanFactory.getBean(MovieCast.class);
		persistData(beanFactory.getBean(MovieCast.class));
	}

	public void directorBeanCreate(String directorName, Long mobileNumber) {

		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Director.class)
				.addPropertyValue("dirName", directorName).addPropertyValue("dirPhone", mobileNumber);

		beanFactory.registerBeanDefinition("director_object", builder.getBeanDefinition());
		beanFactory.getBean(Director.class);
		persistData(beanFactory.getBean(Director.class));
	}
	public void movieBeanCreate(String movieTitle,Date date,String movieLanguage) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Movie.class)
				.addPropertyValue("movieTitle",movieTitle)
				.addPropertyValue("movieYear", date)
				.addPropertyValue("movieLanguage", movieLanguage)
				.addPropertyReference("director","director_object");
		//.addPropertyReference("director","director_object")

		beanFactory.registerBeanDefinition("single_movie_object", builder.getBeanDefinition());
		beanFactory.getBean(Movie.class);
		persistData(beanFactory.getBean(Movie.class));
		
	}
	
	public void movieRatingBeanCreater(Double movieRating) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(MovieRating.class)
				.addPropertyValue("reviewStars", movieRating)
				.addPropertyReference("movie","single_movie_object");
		beanFactory.registerBeanDefinition("movie_rating", builder.getBeanDefinition());
		beanFactory.getBean(MovieRating.class);
		persistData(beanFactory.getBean(MovieRating.class));
		
		
	}

	public void persistData(Object object) {
		transaction.begin();
		entityManager.persist(object);
		transaction.commit();
	}

}
