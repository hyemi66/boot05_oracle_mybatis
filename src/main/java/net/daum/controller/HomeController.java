package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.UserAddrService;
import net.daum.vo.UserAddrVO;

@Controller
public class HomeController {
	
	@Autowired
	private UserAddrService userAddrService;
	
	@RequestMapping(value="/mybatis_jpa", method=RequestMethod.GET)
	// GET으로 접근하는 매핑주소처리, mybatis_jpa 매핑주소 등록
	public void jpa_mybatis_test(Model m) {
		// 반환타입이 없는 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		// 뷰리졸브 경로는 /WEB-INF/views/mybatis_jpa.jsp
		
		m.addAttribute("content_title", "mybatis_jpa와 이름, 주소 폼 연동 연습");
	}
	
	@RequestMapping(value="/mybatis_jpa", method=RequestMethod.POST)
	// POST로 접근하는 매핑주소를 처리
	// public ModelAndView mybatis_jpa(String username, String address) {
	public ModelAndView mybatis_jpa(UserAddrVO useraddr) {
		/*
			mybatis_jpa.jsp의 네임 피라미터 이름과 엔티티빈 클래스 UserAddrVO.java의 변수명이 같으면
			UserAddrVO useraddr에 이름과 주소가 저장되어 있다.
		*/
		
		// System.out.println("username : " + username);
		// System.out.println("addressn : " + address);
		System.out.println("username : " + useraddr.getUsername());
		System.out.println("address : " + useraddr.getAddress());
		
		/*
		UserAddrVO useraddr = new UserAddrVO();
		useraddr.setUsername(username);
		useraddr.setAddress(address);
		*/
		
		this.userAddrService.insertUserAddr(useraddr); // 이름과 주소를 저장
		
		ModelAndView wm = new ModelAndView();
		wm.addObject("result", "이름과 주소값 출력 And JPA + Mybatis로 저장");
		wm.addObject("username", useraddr.getUsername());
		wm.addObject("address", useraddr.getAddress());
		wm.setViewName("resultSuccess"); // 뷰페이지 파일명 설정 -> /WEB-INF/views/resultSuccess.jsp
		
		return wm;
	}
	
}
