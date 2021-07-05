package HrmsProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.hrms.business.abstracts.JobPostService;
import HrmsProject.hrms.core.utilities.results.DataResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.core.utilities.results.SuccessDataResult;
import HrmsProject.hrms.core.utilities.results.SuccessResult;
import HrmsProject.hrms.dataaccess.abstracts.JobPostDao;
import HrmsProject.hrms.entities.concretes.JobPost;
import HrmsProject.hrms.validation.abstracts.CandicateValidationService;
import HrmsProject.hrms.validation.abstracts.MailValidationService;

@Service
public class JobPostManager implements JobPostService{

	private JobPostDao jobPostDao;
	
	
	
	@Autowired
	public JobPostManager(JobPostDao jobPostDao,CandicateValidationService candicateValidationService
			, MailValidationService mailValidationService) {
		
		this.jobPostDao = jobPostDao;
		
		
	}
	
	@Override
	public DataResult<List<JobPost>> getAll() {
		
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(JobPost jobPost) {
		this.jobPostDao.save(jobPost);
		return new SuccessResult("Data kaydedildi");
	}

}
