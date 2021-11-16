package com.care.root.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.MailService;
@Controller
public class MailController {
	@Autowired MailService ms;
	@GetMapping("sendmail")
	public void sendMail(HttpServletResponse response) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<h2>제품소개</h2>");
		sb.append("<a href=\"https://www.naver.com/\">");
		sb.append("<img src=\"https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTExMDJfMTgx%2FMDAxNjM1NzgwNTUyMzU1.sEn5jOfS9odT4EFp-0vN6EpZAffeuGdDCPl6X9oJm6wg.bHHQPKZsyWoO7RmNGDvTMDbQD1kjOF8ufpCjJGOlinUg.JPEG.suk5cc8e%2F%25BD%25BD%25B6%25F3%25C0%25CC%25B5%25E53.JPG&type=sc960_832\">");
		sb.append("</a>");
		
		String msg = sb.toString();
		
		//ms.sendMail("eunoia805@naver.com", "<제목>test", "<내용>test로 보내는 메일" );
		ms.sendMail("eunoia805@naver.com", "<제목>해바라기 광고", msg);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("메일이 전송되었습니다.");
		
	}
	@GetMapping("auth_form")
	public String authForm() {
		return "auth";
	}
	@GetMapping("auth")
	public String auth(HttpServletRequest request) {
		ms.auth(request);
		return "redirect:https://www.naver.com/";	//해당 이메일로 redirect. 받는 사용자
	}
	@GetMapping("auth_check")
	public String authCheck(@RequestParam String userid,
							@RequestParam String userkey,
							HttpSession session) {
		String sessionKey = (String)session.getAttribute(userid);	//userid key를 사용해서 value 값을 가져와 sessionKey에 저장.
		if(sessionKey != null) {
			if(sessionKey.equals(userkey)) {
				session.setAttribute("userid", userid);
			}
		}
		return "redirect:auth_form";
		
	}
						
}
