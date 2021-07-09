package HrmsProject.hrms.business.concretes;
import HrmsProject.hrms.core.utilities.results.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import HrmsProject.hrms.business.abstracts.CandicateService;
import HrmsProject.hrms.core.utilities.check.Abstract.CandicateCheckService;
import HrmsProject.hrms.dataaccess.abstracts.CandicateDao;
import HrmsProject.hrms.entities.concretes.Candicate;

import HrmsProject.hrms.validation.abstracts.MailValidationService;


@Service
public class CandicateManager implements CandicateService{
	private CandicateDao candicateDao;
	
	private MailValidationService mailValidationService;
	private CandicateCheckService candicateCheckService;
	
	@Autowired
public CandicateManager(CandicateDao candicateDao
		,MailValidationService mailValidationService,CandicateCheckService candicateCheckService) {
	this.candicateDao=candicateDao;

	this.mailValidationService=mailValidationService;
    this.candicateCheckService=candicateCheckService;
}	
	@Override
	public Result add(Candicate candicate) {
		//checkService deki metotlarımız Result dönüyor, döndüğü resultu burada tutabilmek için referasını result ile tuttum
		//ve kontrolü aynı anda yapmış oldum,aşağıda da  result döndüğü için success kontrolü üzerinden mail servise devam
		
		Result result=candicateCheckService.allCheck(candicate);
		
		
	if(result.isSusccess()==true) {
		mailValidationService.sendMail(candicate.getEMail());
		if (mailValidationService.checkValidationComplete(candicate.getEMail())) {
			
				this.candicateDao.save(candicate);
				return new SuccessResult("Yeni üye eklendi");
		} 
		else {
		  return new ErrorResult("Mail doğrulanması yapılmadı");
		}
		
	}else {
		
		return result;
	}
		
	
		
	}

	@Override
	public DataResult<List<Candicate>> getAll() {
		return  new SuccessDataResult<List<Candicate>>(this.candicateDao.findAll(),"Adaylar Listelendi");
	}
	
	

}
