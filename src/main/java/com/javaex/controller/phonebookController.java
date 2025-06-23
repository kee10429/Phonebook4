package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class phonebookController {

	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	
	@RequestMapping(value="/phonebook", method= {RequestMethod.GET, RequestMethod.POST})
	public String phonebook() {
		System.out.println("PhonebookController.phonebook");
		
		return "";
	}
	
}
