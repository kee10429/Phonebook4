package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaex.vo.PersonVO;

public class PhonebookService {
	
	//필드
	@Autowired
	private PersonVO personVO;
	//생성자
	
	//메소드gs
	
	//메소드 일반
	
	// 전체 주소록 리스트 가져오기
	public List<PersonVO> exeGetPersonList(){
		System.out.println("phonebookService.exeGetPersonList()");
		
		//dao 통해서 일한다
		List<PersonVO> personList = phonebookDAO.personSelect();
		
		return personList;
	}
	
}
