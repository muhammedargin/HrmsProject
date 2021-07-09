package HrmsProject.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.hrms.business.abstracts.EmployerService;
import HrmsProject.hrms.core.utilities.check.Abstract.EmployerCheckService;
import HrmsProject.hrms.core.utilities.results.DataResult;
import HrmsProject.hrms.core.utilities.results.ErrorResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.core.utilities.results.SuccessDataResult;
import HrmsProject.hrms.core.utilities.results.SuccessResult;
import HrmsProject.hrms.dataaccess.abstracts.EmployerDao;
import HrmsProject.hrms.entities.concretes.Employer;
import HrmsProject.hrms.validation.abstracts.MailValidationService;

@Service
public class EmployerManager implements EmployerService {
    
	
	private EmployerDao employerDao;
	private MailValidationService mailValidationService;
	private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,MailValidationService mailValidationService,EmployerCheckService employerCheckService) {
		
		this.employerCheckService=employerCheckService;
		this.mailValidationService=mailValidationService;
		this.employerDao=employerDao;
	
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Tüm işverenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
		Result result = employerCheckService.allCheck(employer);
		
		if (result.isSusccess()) {
			mailValidationService.sendMail(employer.getEMail());
			if (mailValidationService.checkValidationComplete(employer.getEMail())) {
				
				this.employerDao.save(employer);
				return new SuccessResult("Yeni işveren eklendi");
			}
			else {
				return new ErrorResult("Mail doğrulaması yapılmadı");
			}
		}
		else {
			return result;
		}
	}

}
