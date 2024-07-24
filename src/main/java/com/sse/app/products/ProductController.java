package com.sse.app.products;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sse.app.members.MemberDTO;
import com.sse.app.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Pager pager) throws Exception {

		List<ProductDTO> list = productService.getList(pager);

		model.addAttribute("pager", pager);
		model.addAttribute("list", list);

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(Model model, ProductDTO productDTO) throws Exception {

		System.out.println("detail");

		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto", productDTO);

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void addInfo() {
		System.out.println("add페이지 도착");

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addInfo2(Model model, ProductDTO productDTO, MultipartFile[] files, HttpSession session)
			throws Exception {
		System.out.println("제출");

		int num = productService.addInfo(productDTO, files, session);
		String url = "";

		if (num > 0) {

			url = "redirect:./list";

		}

		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteInfo(Model model, ProductDTO productDTO) {
		System.out.println("삭제");

		int num = productService.deleteInfo(productDTO);
		String url = "";

		if (num > 0) {
			url = "redirect:./list";
		}

		return url;

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void updateInfo(Model model, ProductDTO productDTO) throws Exception {
		System.out.println("수정");

		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto", productDTO);

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateInfo2(Model model, ProductDTO productDTO) {

		int num = productService.updateInfo(productDTO);
		String url = "";

		if (num > 0) {
			url = "redirect:/product/list";
		}
		return url;
	}

	@GetMapping("addWish")
	public String addWish(Integer item_id, HttpSession session, Model model) throws Exception {

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = productService.addWish(item_id, memberDTO.getMember_id());

		model.addAttribute("msg", result);

		return "commons/result";

	}

	@GetMapping("wishList")
	public void wishList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<ProductDTO> ar = productService.wishList(memberDTO);
		model.addAttribute("list", ar);
	}

	@GetMapping("deleteWishList")
	public String deleteWishList(Integer[] item_id, Model model, HttpSession session) throws Exception {

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		String member_id = memberDTO.getMember_id();
		int result = productService.deleteWishList(item_id, member_id);
		model.addAttribute("msg", result);

		return "commons/result";
	}
}
