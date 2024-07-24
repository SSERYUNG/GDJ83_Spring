package com.sse.app.members;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sse.app.accounts.AccountDAO;
import com.sse.app.files.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private FileManager fileManager;

	private String name = "members";

	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {

		int result = memberDAO.join(memberDTO);

		if (files == null) {
			return result;
		}

// 		서블릿컨텍스트 객체를 통해서 운영체제랑 대화 하려고 만드는거(서블릿컨텍스트는 인터페이스라서 객체를 만들수가 없어서 세션에서 꺼내 쓰는거임)

		ServletContext servletContext = session.getServletContext();

		String path = servletContext.getRealPath("resources/upload/members");
		System.out.println(path);

		String fileName = fileManager.fileSave(files, path);

		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setMember_id(memberDTO.getMember_id());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(files.getOriginalFilename());

		memberDAO.joinFile(memberFileDTO);
		return result;

	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {

		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getMember_pw().equals(memberDTO.getMember_pw())) {

				return result;
			} else {
				return null;
			}
		}
		return null;
	}

	public MemberDTO update(MemberDTO memberDTO) throws Exception {

		int num = memberDAO.update(memberDTO);

		if (num > 0) {
			memberDAO.login(memberDTO);
		}
		return memberDTO;
	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);

	}

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return memberDAO.detail(memberDTO);
	}

	public MemberDTO search(MemberDTO memberDTO) throws Exception {
		return memberDAO.search(memberDTO);
	}

}
