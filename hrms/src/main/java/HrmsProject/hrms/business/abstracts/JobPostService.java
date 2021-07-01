package HrmsProject.hrms.business.abstracts;

import java.util.List;

import HrmsProject.hrms.core.utilities.results.DataResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.entities.concretes.JobPost;

public interface JobPostService {
	
	DataResult<List<JobPost>> getAll();
	
	Result add(JobPost jobPost);

}
