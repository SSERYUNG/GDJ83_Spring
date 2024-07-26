package com.sse.app.products;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sse.app.members.MemberDTO;
import com.sse.app.util.Pager;
import com.sse.app.util.ProductCommentPager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("commentAdd")
	public String commentAdd(ProductCommentDTO productCommentDTO, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		productCommentDTO.setBoardWriter(memberDTO.getMember_id());
		int result = productService.addComments(productCommentDTO);

		model.addAttribute("msg", result);

		return "commons/result";
	}

	@GetMapping("commentList")
	public void commentList(ProductCommentPager productCommentPager, Model model) throws Exception {
		List<ProductCommentDTO> ar = productService.commentList(productCommentPager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", productCommentPager);
	}

	@GetMapping("deleteComment")
	public String deleteComment(ProductCommentDTO productCommentDTO, Model model) throws Exception {

		int result = productService.deleteComment(productCommentDTO);
		model.addAttribute("msg", result);

		return "commons/result";
	}

	@PostMapping("commentUpdate")
	public String commentUpdate(ProductCommentDTO productCommentDTO, Model model) throws Exception {

		int result = productService.commentUpdate(productCommentDTO);
		model.addAttribute("msg", result);

		return "commons/result";

	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Pager pager) throws Exception {

		List<ProductDTO> list = productService.getList(pager);

		model.addAttribute("pager", pager);
		model.addAttribute("list", list);

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(Model model, ProductDTO productDTO) throws Exception {

		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto", productDTO);

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void addInfo() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addInfo2(Model model, ProductDTO productDTO, MultipartFile[] files, HttpSession session)
			throws Exception {

		int num = productService.addInfo(productDTO, files, session);
		String url = "";

		if (num > 0) {

			url = "redirect:./list";

		}

		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteInfo(Model model, ProductDTO productDTO) {

		int num = productService.deleteInfo(productDTO);
		String url = "";

		if (num > 0) {
			url = "redirect:./list";
		}

		return url;

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void updateInfo(Model model, ProductDTO productDTO) throws Exception {

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
