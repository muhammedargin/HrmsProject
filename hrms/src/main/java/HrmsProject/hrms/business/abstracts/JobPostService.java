package HrmsProject.hrms.business.abstracts;

import java.util.List;

import HrmsProject.hrms.entities.concretes.JobPost;

public interface JobPostService {
	
	List<JobPost> getAll();

}
