package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		split("GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,wind<10,visibility>4&operator=OR");

	}

	static String[] split(String s){

		String[] splitSentence = s.split("&", 2);
		for (String s1 : splitSentence){
			System.out.println(s1);
		}
		return splitSentence;
	}



}
