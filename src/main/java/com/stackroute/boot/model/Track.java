package com.stackroute.boot.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//make this class as hibernate entity
@Document("track")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Track {
	@Id
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("listeners")
	private String comment;

}