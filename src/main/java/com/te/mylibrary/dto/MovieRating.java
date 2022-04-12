package com.te.mylibrary.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MovieRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingID;
	private Double reviewStars;
	
	@OneToOne
	@Autowired
	Movie movie;

}
