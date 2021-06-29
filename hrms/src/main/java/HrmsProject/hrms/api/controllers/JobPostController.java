package HrmsProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HrmsProject.hrms.business.abstracts.JobPostService;
import HrmsProject.hrms.entities.concretes.JobPost;

@RestController
@RequestMapping("/api/jobPosts")
public class JobPostController {
	
	private JobPostService jobPostService;

	@Autowired
	public JobPostController(JobPostService jobPostService) {
		super();
		this.jobPostService = jobPostService;
	}
	@GetMapping("/getall")
	public List<JobPost> getAll() {
		return this.jobPostService.getAll();
		
	}

}
