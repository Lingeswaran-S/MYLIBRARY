package com.te.mylibrary.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.te.mylibrary.dao.MyDAO;

public class MyService {
	@Autowired
	private MyDAO myDAO;

	// save and passing method
	public void actorService(String actorName, String actorGender) {
		myDAO.actorBeanCreate(actorName, actorGender);
	}

	public void movieCastService(String role) {
		myDAO.movieCastBeanCreate(role);
	}

	public void directorService(String directorName, Long mobileNumber) {
		myDAO.directorBeanCreate(directorName, mobileNumber);
	}
	
	public void movieService(String movieTitle,Date date,String movieLanguage) {
		myDAO.movieBeanCreate(movieTitle, date, movieLanguage);
	}
	public void movieRatingService(Double movieRating) {
		myDAO.movieRatingBeanCreater(movieRating);
		
	}

	// Checker
	public boolean nameChecker(String name) {
		boolean response = true;
		char[] charNameArray = name.toCharArray();
		for (char c : charNameArray) {
			if (!Character.isLetter(c)) {
				response = false;
			}
		}
		return response;
	}

	public boolean nameCheckerIncludeNumber(String name) {
		boolean response = true;
		char[] charNameArray = name.toCharArray();
		for (char c : charNameArray) {
			if (!Character.isLetter(c) & !Character.isDigit(c)) {
				response = false;
			}
		}
		return response;
	}

	public boolean mobileNumerChecker(Long mobileNumber) {
		boolean response = false;

		if (mobileNumber.toString().length() == 10) {
			response = true;
			return response;
		} else {
			return response;
		}

	}
	public boolean movieRatingChecker(double rating) {
		boolean response=true;
		if(rating>5 || rating<0) {
			response=false;
			return response;
		}else {
			return response;
		}
		
	}

}
