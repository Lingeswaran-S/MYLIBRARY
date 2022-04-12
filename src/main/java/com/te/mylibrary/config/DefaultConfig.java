package com.te.mylibrary.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.te.mylibrary.dto.Actor;
import com.te.mylibrary.dto.Director;
import com.te.mylibrary.dto.Movie;
import com.te.mylibrary.dto.MovieCast;
import com.te.mylibrary.dto.MovieRating;

@Configuration
public class DefaultConfig {
	@Bean(name = "actor_object")
	@Primary
	public Actor getActorObj() {
		Actor actor = new Actor();
		actor.setActName("Surya");
		actor.setActGender("Male");
		return actor;
	}

	@Bean(name = "moviecast_list_object")
	@Primary
	public ArrayList<MovieCast> getCastListObj() {
		ArrayList<MovieCast> movieCasts = new ArrayList<MovieCast>();
		movieCasts.add(getCastObj());
		return movieCasts;
	}

	@Bean(name = "moviecast_single_object")
	@Primary
	public MovieCast getCastObj() {
		MovieCast cast = new MovieCast();
		cast.setRole("Police");
		return cast;
	}

	@Bean(name = "director_object")
	@Primary
	public Director getDirectorObj() {
		Director director = new Director();
		director.setDirName("Nelson");
		director.setDirPhone(3456565464L);
		return director;
	}

	@Bean(name = "movie_list_object")
	@Primary
	public ArrayList<Movie> getMovieObjList() {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
//		Movie movie=new Movie();
//		movie.setMovieTitle("Singam");
//		movie.setMovieLanguage("Universal-Lang");
//		movie.setMovieYear("2018");
//		movieList.add(movie);
		// DefaultConfig config=new DefaultConfig();
		movieList.add(getMovieObj());
		return movieList;
	}

	@Bean(name = "single_movie_object")
	@Primary
	public Movie getMovieObj() {
		Movie movie = new Movie();
		movie.setMovieTitle("Singam");
		movie.setMovieLanguage("Universal-Lang");
		String dateFormatMode="dd/MM/yyyy";
		SimpleDateFormat dateFormat=new SimpleDateFormat(dateFormatMode);
		System.out.println("date ?");
		Date parse = null;
		try {
			parse = dateFormat.parse("01/05/2001");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie.setMovieYear(parse);
		return movie;
	}

	@Bean(name = "movie_rating")
	@Primary
	public MovieRating getMovieRating() {
		MovieRating movieRating = new MovieRating();
		movieRating.setReviewStars(4D);
		return movieRating;
	}

}
