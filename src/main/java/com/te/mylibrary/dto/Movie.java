package com.te.mylibrary.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int movieID;
	private String movieTitle;
	private Date movieYear;
	private String movieLanguage;
	//Actor actor;
	
	
	@ManyToOne
	@JoinColumn(name = "directorID")
//	@Qualifier(value ="director_object")
	@Autowired
	private Director director;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
	@Autowired
	private List<MovieCast> casts;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "movie")
	@Autowired
	private MovieRating rating;

}
