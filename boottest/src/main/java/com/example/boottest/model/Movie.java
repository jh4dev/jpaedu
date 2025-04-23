package com.example.boottest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	Long id;
	String poster;
	String title;
	String date;
	String aor;
	String director;
	
	
	
}
