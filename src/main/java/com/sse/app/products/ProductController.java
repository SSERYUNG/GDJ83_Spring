package com.sse.app.products;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Long page) throws Exception {

		Map<String, Object> map = productService.getList(page);

		model.addAttribute("map", map);

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
	public String addInfo2(Model model, ProductDTO productDTO) throws Exception {
		System.out.println("제출");

		int num = productService.addInfo(productDTO);
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

}
