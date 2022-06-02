package kz.projectestimate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/project")
	public String projectPage() {
		return "project";
	}
	
	@GetMapping("/geodesy")
	public String geodesyPage() {
		return "geodesy";
	}
	
	@GetMapping("/geology")
	public String geologyPage() {
		return "geology";
	}
	
	@GetMapping("/engineering")
	public String engineeringPage() {
		return "engineering";
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
	
	@GetMapping("/new_estimate")
	public String newEstimatePage() {
		return "new_estimate";
	}

}

