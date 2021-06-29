package HrmsProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.hrms.business.abstracts.JobPostService;
import HrmsProject.hrms.dataaccess.abstracts.JobPostDao;
import HrmsProject.hrms.entities.concretes.JobPost;

@Service
public class JobPostManager implements JobPostService{

	private JobPostDao jobPostDao;
	
	@Autowired
	public JobPostManager(JobPostDao jobPostDao) {
		super();
		this.jobPostDao = jobPostDao;
		
		
	}
	
	@Override
	public List<JobPost> getAll() {
		
		return this.jobPostDao.findAll();
	}

}
