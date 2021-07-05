package HrmsProject.hrms.business.concretes;
import HrmsProject.hrms.core.utilities.results.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import HrmsProject.hrms.business.abstracts.CandicateService;
import HrmsProject.hrms.core.utilities.check.Abstract.CandicateCheckService;
import HrmsProject.hrms.dataaccess.abstracts.CandicateDao;
import HrmsProject.hrms.entities.concretes.Candicate;
import HrmsProject.hrms.validation.abstracts.CandicateValidationService;
import HrmsProject.hrms.validation.abstracts.MailValidationService;


@Service
public class CandicateManager implements CandicateService{
	private CandicateDao candicateDao;
	private CandicateValidationService candicateValidationService;
	private MailValidationService mailValidationService;
	private CandicateCheckService candicateCheckService;
	
	@Autowired
public CandicateManager(CandicateDao candicateDao,CandicateValidationService candicateValidationService
		,MailValidationService mailValidationService,CandicateCheckService candicateCheckService) {
	this.candicateDao=candicateDao;
	this.candicateValidationService=candicateValidationService;
	this.mailValidationService=mailValidationService;
    this.candicateCheckService=candicateCheckService;
}	
	@Override
	public Result add(Candicate candicate) {
		//checker.candicateChecker(candicate).isSusccess()==true
	
	if(candicateCheckService.allCheck(candicate).isSusccess()==true) {
		mailValidationService.sendMail(candicate.getEMail());
		if (mailValidationService.checkValidationComplete(candicate.getEMail())) {
			
			if (candicateValidationService.checkIfRealPerson(candicate)) {
				this.candicateDao.save(candicate);
				return new SuccessResult("Yeni üye eklendi");
			}
			else {
				return new ErrorResult("Mernis Doğrulaması Başarısız");
			}
		
		} 
		else {
		  return new ErrorResult("Mail doğrulanması yapılmadı");
		}
		
	}else {
		return new ErrorResult("Doğrulama başarısız oldu.");
	}
		
	
		
	}

	@Override
	public DataResult<List<Candicate>> getAll() {
		return  new SuccessDataResult<List<Candicate>>(this.candicateDao.findAll(),"Adaylar Listelendi");
	}
	
	

}
