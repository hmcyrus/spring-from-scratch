package com.cyrus;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFromScratch {
	private static Logger logger = Logger.getAnonymousLogger();

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
		
		Hello hello = ctx.getBean("hello", Hello.class);		
		System.out.println(hello.content);
		
		if(ctx.containsBean("hello")) {
			System.out.println("there's a hello bean");
		}
		
		
		System.out.println("bean count " + ctx.getBeanDefinitionCount());
		Arrays.stream(ctx.getBeanDefinitionNames())
//				.map(it -> it.toLowerCase())
//				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

}
