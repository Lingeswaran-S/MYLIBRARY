package com.te.mylibrary.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int actID;
	private String actName;
	private String actGender;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "actor")
	@Autowired
	private List<MovieCast> cast;
	
//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "actor")
//	@Autowired
//	private MovieCast cast;
	
}
