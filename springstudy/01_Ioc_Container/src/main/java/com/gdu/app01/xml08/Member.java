package com.gdu.app01.xml08;

import java.util.List;

public class Member {

	private String name;
	private List<String> course;	// 등록과정(헬스, 수영, 스피닝, 필라테스 등)
	private double height;
	private double weight;
	private BMICalculator bmiCalc;
	
	public Member(String name, List<String> course, double height, double weight, BMICalculator bmiCalc) {
		super();
		this.name = name;
		this.course = course;
		this.height = height;
		this.weight = weight;
		this.bmiCalc = bmiCalc;
	}
	
	public void info() {
		System.out.println("이름: " + name);
		for(String str : course) {
			System.out.println("과정: " + str);			
		}
		System.out.println("키: " + height);
		System.out.println("몸무게: " + weight);
		bmiCalc.info();
	}
	
	
}
