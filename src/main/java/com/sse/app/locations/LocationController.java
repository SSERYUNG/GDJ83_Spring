package com.sse.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/location/*")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping("list")
	public void getList(Model model) throws Exception {
		System.out.println("location list");
		List<LocationDTO> ar = locationService.getList();
		model.addAttribute("list", ar);

	}

}
