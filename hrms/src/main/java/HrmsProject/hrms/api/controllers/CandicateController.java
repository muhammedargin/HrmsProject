package HrmsProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HrmsProject.hrms.business.abstracts.CandicateService;
import HrmsProject.hrms.core.utilities.results.DataResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.entities.concretes.Candicate;

@RestController
@RequestMapping("/api/candicates")
public class CandicateController {
	
	private CandicateService candicateService;
	
	@Autowired
	public CandicateController(CandicateService candicateService) {
		this.candicateService=candicateService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candicate>> getAll() {
		return this.candicateService.getAll();
		
	}
	
	@PostMapping("/add")
	
	public Result add (@RequestBody Candicate candicate) {
		
		return this.candicateService.add(candicate);
		
	}

}
