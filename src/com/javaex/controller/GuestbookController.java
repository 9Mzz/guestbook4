package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/gbc")
public class GuestbookController {

	// 필드
	@Autowired
	private GuestbookDao guestbookDao;

	// 생성자

	// 메소드

	// 메소드 일반

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("guest > addList");

		List<GuestbookVo> guestbookList = guestbookDao.getList();
		System.out.println(guestbookList.toString());

		model.addAttribute("guestbookList", guestbookList);

		return "list";
	}

	// 등록
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("guest > add");

		guestbookDao.insert(guestbookVo);

		return "redirect:/gbc/addlist";
	}

	// 삭제폼
	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("guest > deleteForm");

		return "deleteForm";
	}

	// 삭제
	@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {

		GuestbookVo guestbookVo = new GuestbookVo();

		guestbookDao.delete(guestbookVo);

		return "redirect:/guest/addlist";
	}

}
