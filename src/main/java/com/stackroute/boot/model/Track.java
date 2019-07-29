package com.stackroute.boot.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//make this class as hibernate entity
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("listeners")
	private String comment;

}