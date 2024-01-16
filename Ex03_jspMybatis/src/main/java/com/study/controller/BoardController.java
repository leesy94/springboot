package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.Board;
import com.study.service.BoardService;
import com.study.service.BoardServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model md) {
		//List<Board> rlist = boardService.list(); 
		md.addAttribute("list",boardService.list());
		md.addAttribute("totalRecord",boardService.totalRecord());
		return "list";
	}
	/* 요청 처리 후 응답페이지로 포워딩(결과 담기)
	 * 1. Model - 뷰로 전달하고자 하는 데이터 맴형식(key-value)로 담아서 전달
	 * 			- requestScope 단, setAttribute가 아닌 addAttribute
	 * 			
	 * 2. ModelAndView - Model 영역에 뷰로 전달하고자 하는 데이터 맴형식(key-value)로 담아서 전달
	 * 				   - View 영역은 응답븅데 대한 정보를 담을 수 있는 공간
	 * 					 
	 * 					EX ) public String list(ModelAndView mv) {
								List<Board> rlist = boardService.list();
								mv.addObject("list",rlist);
								mv.setViewName("/list");
								return mv;
							}
	 * */
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	/* 파라미터 (요청시 전달 값)을 받는 방법
	 * 1. HttpServletRequest => 기존 jsp 방식
	 * 2. @RequestParam 어노테이션 이용 
	 * => 속성 - value : URI에서 바인딩하게 될 값
	 * 			required : true or false , 필수값
	 * 			defaultValue : 기본 => @RequestParam("key") 변수명
	 * 			EX)	@RequestParam(value="key",defaultValue="",required=true) 자료형 변수명	
	 * 				@RequestParam("key")
	 * 3. command 객체 : dto클래스에 담음 => 가장 많이 쓰임
	 * 					요청시 전달 값의 키(name)을 dto클래스에 담고자 하는 필드명을 작성
	 * 					스프링컨테이너가 해당 객체를 기본생성자를 생성 후 setter메소드를 찾아서 전달된 값을 해당 필드에 내부적으로 담아주는 원리
	 * 					- 반드시 기본생성자 필요
	 * 					- 키이름이 dto의 필드명과 같아야함
	 * */
	
	@PostMapping("write")
	public String write(Board board) {
		boardService.insertBoard(board);
		System.out.println("제목 : "+board.getTitle());
		System.out.println("작성자 : "+board.getWriter());
		System.out.println("내용 : "+board.getContent());
		return "redirect:list";
	}
	
	@GetMapping("detail")
	public String detailBoard(HttpServletRequest request, Model md) {
		String no = request.getParameter("no");
		System.out.println(no);
		Board board = boardService.detailBoard(no);
		md.addAttribute("dBoard",board);
		return "detail";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam(value="no",defaultValue="1") String bno) {
		boardService.deleteBoard(bno);
		return "redirect:list";
	}
}
