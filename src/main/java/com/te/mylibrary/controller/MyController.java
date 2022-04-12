package com.te.mylibrary.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.te.mylibrary.dao.MyDAO;
import com.te.mylibrary.service.MyService;

@Controller
public class MyController {
	Scanner input = new Scanner(System.in);
	@Autowired
	private MyService myService;
	@Autowired
	private MyDAO myDAO;

	public void startWork() {
		acotorDetailsGetter();
		directorDetailsGetter();
//		myDAO.myDAOprocess();

	}

	public void acotorDetailsGetter() {
		System.out.println("Enter Actor Details :");
		String actorName = stringGetter("Actor Name");
		String actorGender = stringGetter("Actor Gender");
		myService.actorService(actorName, actorGender);
		//movieCastDetailsGetter();
	}

	public void movieCastDetailsGetter() {
		String role = stringGetter("Actor Role");
		myService.movieCastService(role);
	}

	public void directorDetailsGetter() {
		String directorName = stringGetter("Director Name");
		Long mobileNumber = mobileNumberGetter("");
		myService.directorService(directorName, mobileNumber);
		movieDetailsGetter();
	}

	public void movieDetailsGetter() {
		String movieTitle = stringGetter("Movie title", 1);
		String dateFormatMode = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatMode);

		System.out.println("Enter movie released year ?");
		Date date = null;
		try {
			date = dateFormat.parse(input.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String movieLanguage=stringGetter("Movie Language");
		
		myService.movieService(movieTitle, date, movieLanguage);
//		System.out.println(parse);
		movieCastDetailsGetter();
		movieRatingDetailsGetter();
		
	}
	public void movieRatingDetailsGetter() {
		Double movieRating=movieRatingGetter("");
		myService.movieRatingService(movieRating);
		
	}

	public String stringGetter(String displayString) {
		System.out.format("Enter %s ?", displayString);
		String string = input.next();
		if (myService.nameChecker(string)) {
			return string;
		} else {
			System.out.println("NOT A VALID " + displayString + " ::ENTER AGAIN ?");
			return stringGetter(displayString);
		}

	}

	public String stringGetter(String displayString, int pointer) {
		System.out.format("Enter %s ?", displayString);
		String string = input.next();
		if (myService.nameChecker(string) & pointer == 1) {
			return string;
		} else {
			System.out.println("NOT A VALID " + displayString + " ::ENTER AGAIN ?");
			return stringGetter(displayString, 1);
		}

	}

	public Long mobileNumberGetter(String dispString) {
		System.out.format("%sEnter 10-Digit mobile numer (Don't Put Country Code +91) ?", dispString);
		Long mobileNumber = input.nextLong();
		if (myService.mobileNumerChecker(mobileNumber)) {
			return mobileNumber;
		} else {
			return mobileNumberGetter("Wrong Mobile Number ! \n");
		}

	}
	public Double movieRatingGetter(String displayString) {
		System.out.format("%s Enter Movie Rating ?",displayString);
		Double rating=input.nextDouble();
		if(myService.movieRatingChecker(rating)) {
			return rating;
		}else {
			return movieRatingGetter("Invalid Rating \nRating Should be between 0 to 5\n");
		}
		
	}

}
