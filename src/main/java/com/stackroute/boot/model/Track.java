package com.stackroute.boot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//make this class as hibernate entity
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
	@Id
	private int id;
	private String name;
	private String comment;

}