package com.gdu.app01.xml03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml03/appCtx.xml");
		Person saram = ctx.getBean("saram", Person.class);
		
		System.out.println(saram.getName());
		System.out.println(saram.getAge());
		Address address = saram.getAddr();
		System.out.println(address.getJibun());
		System.out.println(address.getRoad());
		System.out.println(address.getZipCode());
		

	}

}
