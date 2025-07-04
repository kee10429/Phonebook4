package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.Phonebook4Application;
import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PersonVO;



@Controller
public class PhonebookController {

    private final Phonebook4Application phonebook4Application;

    PhonebookController(Phonebook4Application phonebook4Application) {
        this.phonebook4Application = phonebook4Application;
    }

	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhonebookController.phonebook()");
		
		List<PersonVO> phonebookList = phonebookService.exeGetPhonebookList();
		System.out.println("-----------------------------------------");
		System.out.println(phonebookList);
		System.out.println("-----------------------------------------");
		
		
		model.addAttribute("pList", phonebookList);
		
		return "/list";
	}
	
	
	// 전화번호 등록폼
	@RequestMapping(value="wform", method= {RequestMethod.GET, RequestMethod.POST})
	public String wForm() {
		System.out.println("PhonebookController.writeForm");
		
		
		return "writeForm";
	}
	
	//등록
	@RequestMapping(value="add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute PersonVO personVO) {
		
		System.out.println(personVO);
		PhonebookDAO phonebookDAO = new PhonebookDAO();
		phonebookDAO.personInsert(personVO);
		int count = phonebookDAO.personInsert(personVO);
		System.out.println(count);
		
		return "redirect: /list";
		
	}
	
	
	//전화번호 수정폼
	@RequestMapping(value="mform", method= {RequestMethod.GET, RequestMethod.POST})
	public String mform(@RequestParam("no") int no, Model model) {
		System.out.println("mForm");
		
		PhonebookDAO phonebookDAO = new PhonebookDAO();
		PersonVO personVO = phonebookDAO.personSelectOne(no);
		
		model.addAttribute("personVO", personVO);
		
		return "modifyForm";
	}
	
	//수정
	@RequestMapping(value="update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVO personVO) {
		
		PhonebookDAO phonebookDAO = new PhonebookDAO();
		int count = phonebookDAO.personUpdate(personVO);
		
		return "redirect:/list";
		
	}
	
}
