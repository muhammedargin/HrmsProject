package HrmsProject.hrms.core.utilities.check.concrete;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import HrmsProject.hrms.core.utilities.check.Abstract.EmployerCheckService;
import HrmsProject.hrms.core.utilities.results.ErrorResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.core.utilities.results.SuccessResult;
import HrmsProject.hrms.dataaccess.abstracts.EmployerDao;
import HrmsProject.hrms.entities.concretes.Candicate;
import HrmsProject.hrms.entities.concretes.Employer;

@Component
public class EmployerCheckManager implements EmployerCheckService{
	
	private EmployerDao employerDao;
	
	@Autowired
		public EmployerCheckManager(EmployerDao employerDao) {
			this.employerDao = employerDao;
		}	
	
	@Override
	public boolean nullCheck(Employer employer) {
			if (employer.getEmployerName().trim().equals("") 
				|| employer.getEmployerWebsite().trim().equals("") 
				|| employer.getEMail().trim().equals("") 
				|| employer.getPassword().trim().equals(null) 
				|| employer.getPassword2().trim().equals(null) 
				|| employer.getEmployerPhoneNumber().trim().equals("") )
		{  //herhangi bir string ifadenin sonuna .trim() getirildiğinde sağdan ve soldan boşluklar kesilir, burada
			//boşluklar yokediliyor ve isim soyisim vb alanların kullanıcı tarafından null değil ama blank yani
			// boş bırakılma ihtiamli trimden sonra equals("") ile karakter var mı yokmu kontrolü ile yok oluyor
			
			return false;
			
		}
		else {
			return true;
		}
	}
	

	@Override
	public boolean domainCheck(Employer employer) {
		
		return true;
	}

	@Override
	public boolean unusedMailCheck(Employer employer) {

		boolean result = false;
		for (Employer employers : this.employerDao.findAll()) {
			
			result = employers.getEMail().equals(employer.getEMail());
			if(result) {
				break;
			}
			else {
				continue;
			}
			
		}
		return !result;
		
	}

	@Override
	public boolean passwordLengthCheck(Employer employer) {
		if (employer.getPassword().length()<6) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean passwordRepeatCheck(Employer employer) {
		 if (employer.getPassword().equals(employer.getPassword2())) {
			 return true;
		}
		 else {
			return false;
		}
	}
	
	@Override
	public boolean regexMailCheck(Employer employer) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEMail());
		if (matcher.matches()==true) {
			return true;
		}else {
			return false;
			
		}
	}


	@Override
	public Result allCheck(Employer employer) {
		if (nullCheck(employer)) {
			
			 if (regexMailCheck(employer)) {
			
				 if (domainCheck(employer)) {
			
					 if (unusedMailCheck(employer)) {
						 
						 if (passwordLengthCheck(employer)) {
							 
							 if (passwordRepeatCheck(employer)) {
								 return new SuccessResult("Tüm alanlar doğrulandı");
							}
							 else {
								 return new ErrorResult("Parolalarınız aynı değil.Lütfen Kontrol ediniz."); 
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
					
					 return new ErrorResult("Girdiğiniz e-posta adresi, sitenizin domaini ile eşleşmelidir."); 
				}
			}
			 else {
			
				 return new ErrorResult("E-posta example@example.com standartlarında olmalıdır."); 
			}
				
			
			
		}
		else {
	

			return new ErrorResult("Kayıt olurken herhangi bir alan boş bırakılamaz."); 
		
		}
	}

	
	

}
