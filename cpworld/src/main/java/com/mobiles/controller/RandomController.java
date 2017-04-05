package com.mobiles.controller;

import java.util.Random;

public class RandomController {
	public static int randomNumberGeneration(){
		int minimum,maximum;
		minimum=1;
		maximum=21;
		Random ran= new Random();
		int value=ran.nextInt((maximum - minimum)+1)+minimum;
		return value;
	}
	public static int randomNumforThumbnails(){
		int min,max;
		min=1;
		max=58;
		Random random= new Random();
		int number= random.nextInt((max-min)+1)+min;
		return number;
	}
}
