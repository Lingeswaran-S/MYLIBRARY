package com.te.mylibrary.dto;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MovieCast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mcID;
	private String role;
	@ManyToOne
	@JoinColumn(name = "Act_ID")
	@Autowired
	private Actor actor;
	
	@ManyToOne
	@JoinColumn(name = "Movie_ID")
	@Autowired
	private Movie movie;

	// Movie movie;

}
