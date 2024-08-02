package com.sse.app.boards.qnas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sse.app.boards.BoardDTO;
import com.sse.app.files.FileDTO;
import com.sse.app.members.MemberDTO;
import com.sse.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}

	@GetMapping("list")
	public ModelAndView getList(Pager pager, ModelAndView mv) throws Exception {
		List<BoardDTO> list = qnaService.getList(pager);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}

	@GetMapping("detail")
	public String getDetail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}

	@GetMapping("add")
	public String add(String write, Model model) throws Exception {
		model.addAttribute("write", write);
		return "board/write";
	}

	@PostMapping("add")
	public String add(QnaDTO qnaDTO, HttpSession session, MultipartFile[] files) throws Exception {
		MemberDTO memberDto = (MemberDTO) session.getAttribute("member");
		qnaDTO.setBoardWriter(memberDto.getMember_id());
		int result = qnaService.add(qnaDTO, files, session);
		return "redirect: ./list";
	}

	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/write";
	}

	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		return "redirect:./list";
	}

	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model, String write, String reply) throws Exception {
		model.addAttribute("reply", "reply");
		model.addAttribute("write", "add");
		model.addAttribute("boardDTO", qnaDTO);
		return "board/write";
	}

	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession session, MultipartFile[] files) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getMember_id());
		int result = qnaService.reply(qnaDTO, session, files);
		return "redirect:./list";
	}

	@GetMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}

	@GetMapping("fileDown")
	public String fileDown(FileDTO fileDTO, Model model) throws Exception {
		fileDTO = qnaService.fileDetail(fileDTO);
		model.addAttribute("file", fileDTO);
		return "fileDown";
	}
	
//	컨텐츠 내의 이미지 처리하는 방법
	@PostMapping("uploadContentImage")
	@ResponseBody
	public Map<String, String> uploadContentImage(MultipartFile upload,Model model) throws Exception{
//		서비스로 보내서 파일을 서버의 하드디스크에 저장하고, 경로와 파일명을 리턴으로 받음
		System.out.println(upload.getOriginalFilename());
		System.out.println(upload.getSize());
		String path ="/resources/images/index/img1.png";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("url", path);

		return map;
	}

}
