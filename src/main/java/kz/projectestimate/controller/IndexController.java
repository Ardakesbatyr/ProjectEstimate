package kz.projectestimate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String indexPage() {
		return "ajax_crud";
	}
	
	@GetMapping("/index/calculation")
	public String calculationPage() {
		return "calculation";
	}
	
	@GetMapping("/view")
	public String viewPage() {
		return "view";
	}
	
	@GetMapping("/view2")
	public String view2Page() {
		return "view2";
	}
	
	@GetMapping("/category")
	public String categoryPage() {
		return "category";
	}

}

