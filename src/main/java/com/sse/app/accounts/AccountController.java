package com.sse.app.accounts;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sse.app.members.MemberDTO;
import com.sse.app.trades.TradeDTO;
import com.sse.app.trades.TradeService;

@Controller
@RequestMapping(value = "/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TradeService tradeService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(AccountDTO accountDTO, Model model) throws Exception {

		model.addAttribute("account", accountDTO);

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(AccountDTO accountDTO, HttpSession session, Model model) throws Exception {

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		accountDTO.setMember_id(memberDTO.getMember_id());

		int result = accountService.add(accountDTO);

		if (result > 0) {

			model.addAttribute("result", "가입 완료");
			model.addAttribute("url", "/");
		}

		return "/commons/message";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(AccountDTO accountDTO, Model model) throws Exception {
		AccountDTO adto = new AccountDTO();
		adto.setBank_id(accountDTO.getBank_id());
		adto = accountService.detail(adto);

		model.addAttribute("acinfo", adto);

	}

//	@RequestMapping(value = "transfer", method = RequestMethod.GET)
//	public void transfer(AccountInfoDTO accountInfoDTO, Model model) throws Exception {
//		model.addAttribute("balance", accountInfoDTO);
//	}
//
//	@RequestMapping(value = "transfer", method = RequestMethod.POST)
//	public String transfer2(AccountInfoDTO accountInfoDTO, Model model) throws Exception {
//		int num = accountService.transfer(accountInfoDTO);
//
//		if (num == 4) {
//			model.addAttribute("result", "이체를 완료했습니다");
//			model.addAttribute("url", "/");
//			return "/commons/message";
//		} else if (num == 0) {
//
//			model.addAttribute("result", "비밀번호가 일치하지 않습니다");
//			model.addAttribute("url", "/member/mypage");
//			return "/commons/message";
//		} else {
//
//			model.addAttribute("result", "이체에 실패했습니다 이체 정보를 정확히 입력하세요");
//			model.addAttribute("url", "/member/mypage");
//			return "/commons/message";
//		}
//
//	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public void transfer() throws Exception {
	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transfer(TradeDTO tradeDTO) throws Exception {

		int result = tradeService.trade(tradeDTO);

		return "redirect:../member/mypage";
	}

}
