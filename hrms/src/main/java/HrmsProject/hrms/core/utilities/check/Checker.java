package HrmsProject.hrms.core.utilities.check;
import org.springframework.beans.factory.annotation.Autowired;



import HrmsProject.hrms.core.utilities.check.Abstract.CandicateCheckService;
import HrmsProject.hrms.core.utilities.results.ErrorResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.core.utilities.results.SuccessResult;
import HrmsProject.hrms.entities.concretes.Candicate;
public class Checker {
	private CandicateCheckService candicateCheckService;
	
	@Autowired
	public Checker(CandicateCheckService candicateCheckService) {
		this.candicateCheckService=candicateCheckService;
	}
	public  Result candicateChecker(Candicate candicate) {
if (candicateCheckService.nullCheck(candicate)) {
			
			if (candicateCheckService.nameAndSurnameCheck(candicate)) {
				
			 if (candicateCheckService.regexMailCheck(candicate)) {
				
				 if (candicateCheckService.unusedMailCheck(candicate)) {
					 
					 if (candicateCheckService.passwordLengthCheck(candicate)) {
						 
							 return new SuccessResult("Tüm alanlar doğrulandı");
						
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
