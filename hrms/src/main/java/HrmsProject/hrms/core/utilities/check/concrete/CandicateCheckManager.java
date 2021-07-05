package HrmsProject.hrms.core.utilities.check.concrete;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import HrmsProject.hrms.core.utilities.check.Abstract.CandicateCheckService;
import HrmsProject.hrms.core.utilities.results.ErrorResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.core.utilities.results.SuccessResult;
import HrmsProject.hrms.dataaccess.abstracts.CandicateDao;
import HrmsProject.hrms.entities.concretes.Candicate;

@Component
public class CandicateCheckManager implements CandicateCheckService{
	CandicateDao candicateDao;
	
	@Autowired
	public CandicateCheckManager(CandicateDao candicateDao) {
		this.candicateDao=candicateDao;
	}
	@Override
	public boolean nullCheck(Candicate candicate) {
		if (candicate.getFirstName().equals(null) || candicate.getLastName().equals(null) || candicate.getEMail().equals(null) 
				|| candicate.getPassword().equals(null) )
		{
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean nameAndSurnameCheck(Candicate candicate) {
		
		if (candicate.getFirstName().length()<2 || candicate.getLastName().length()<2  ) {
			return false;
			
		}
		else {
			return true;
		}
	}

	@Override
	public boolean regexMailCheck(Candicate candicate) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candicate.getEMail());
		if (matcher.matches()==true) {
			return true;
		}else {
			return false;
			
		}
	}

	@Override
	public boolean unusedMailCheck(Candicate candicate) {
		
		boolean result = false;
		for (Candicate candicates : this.candicateDao.findAll()) {
			if (candicate.getEMail()==candicates.getEMail()) {
				
				result = false;
				
				
			}
			else {
				
				result = true;
			}
		}
		return result;
		
	}

	@Override
	public boolean passwordLengthCheck(Candicate candicate) {
		if (candicate.getPassword().length()<6) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean passwordRepeatCheck(Candicate candicate) {
		
		if (candicate.getPassword()==candicate.getPassword2()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public boolean nationalityIdCheck(Candicate candicate) {
		boolean result = false;
		for (Candicate candicates : this.candicateDao.findAll()) {
			if (candicate.getNationalityId()==candicates.getNationalityId()) {
				
				result = false;
				
				
			}
			else {
				
				result = true;
			}
		}
		return result;
	}
	@Override
	public Result allCheck(Candicate candicate) {
if (nullCheck(candicate)) {
			
			if (nameAndSurnameCheck(candicate)) {
				
			 if (regexMailCheck(candicate)) {
				
				 if (unusedMailCheck(candicate)) {
					 
					 if (passwordLengthCheck(candicate)) {
						 if (passwordRepeatCheck(candicate)) {
							
							 return new SuccessResult("Tüm alanlar doğrulandı");
						}
						 else {
							return new ErrorResult("Parolalar eşleşmedi."); 
						}
						
					}
					 else {
						 return new ErrorResult("Parola en az 6 karakterden oluşmalıdır"); 
					}
					
				}
				 else {
					 return new ErrorResult("Bu e-posta adresi daha önce kullanılmıştır."); 
				}
			}
			 else {
				 return new ErrorResult("E-posta example@example.com standartlarında olmalıdır."); 
			}
				
			}
			else {
				return new ErrorResult("İsim ve Soyisim iki veya daha fazla harf içermelidir"); 
			}
			
		}
		else {
			return new ErrorResult("İsim,Soyiyim,E-mail ve parola alanlarından herhangi biri boş olamaz."); 
			
		}
	}

}
