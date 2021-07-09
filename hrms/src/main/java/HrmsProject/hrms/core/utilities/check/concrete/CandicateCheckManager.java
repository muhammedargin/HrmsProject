package HrmsProject.hrms.core.utilities.check.concrete;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import HrmsProject.hrms.core.utilities.check.Abstract.CandicateCheckService;
import HrmsProject.hrms.core.utilities.results.ErrorResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.core.utilities.results.SuccessResult;
import HrmsProject.hrms.dataaccess.abstracts.CandicateDao;
import HrmsProject.hrms.entities.concretes.Candicate;

@Component
public class CandicateCheckManager implements CandicateCheckService{
	private CandicateDao candicateDao;
	
	@Autowired
	public CandicateCheckManager(CandicateDao candicateDao) {
		this.candicateDao=candicateDao;
	}
	@Override
	public boolean nullCheck(Candicate candicate) {
		//başarılı çalışıyor
		
			if (candicate.getFirstName().trim().equals("") 
				|| candicate.getLastName().trim().equals("") 
				|| candicate.getEMail().trim().equals("") 
				|| candicate.getPassword().trim().equals(null) 
				||candicate.getPassword2().trim().equals(null)
				|| candicate.getNationalityId().trim().equals("") 
				|| candicate.getBirthYear()==0)
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
	public boolean nameAndSurnameCheck(Candicate candicate) {
		//başarılı çalışıyor
		if (candicate.getFirstName().length()<2 || candicate.getLastName().length()<2  ) {
			return false;
			
		}
		else {
			return true;
		}
	}

	@Override
	public boolean regexMailCheck(Candicate candicate) {
		//başarılı çalışıyor
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
		//başarılı çalışıyor
		
		
		boolean result = false;
		for (Candicate candicates : this.candicateDao.findAll()) {
			
			result = candicates.getEMail().equals(candicate.getEMail());
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
	public boolean passwordLengthCheck(Candicate candicate) {
		//başarılı çalışıyor
		if (candicate.getPassword().length()<6) {
			return false;
		}
		else {
			return true;
		}
	}

	
		
	

	@Override
	public boolean nationalityIdCheck(Candicate candicate) {
		boolean result = false;
		for (Candicate candicates : this.candicateDao.findAll()) {
			
			result = candicates.getNationalityId().equals(candicate.getNationalityId());
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
	public boolean passwordRepeatCheck(Candicate candicate) {
		//başarılı çalışıyor
		 if (candicate.getPassword().equals(candicate.getPassword2())) {
			 return true;
		}
		 else {
			return false;
		}
		
	}
	
	
	@Override
	public Result allCheck(Candicate candicate) {
		//BURADAKİ ALLCHECKTEN RESULT DÖNDÜRRÜP KULLANICININ HANGİ HATAYI ALDIĞINI gösteriyoruz
		if (nullCheck(candicate)) {
			
			if (nameAndSurnameCheck(candicate)) {
			
			 if (regexMailCheck(candicate)) {
			
				 if (unusedMailCheck(candicate)) {
			
					 if (passwordLengthCheck(candicate)) {
						 
						 if (passwordRepeatCheck(candicate)) {
							 
							 if (nationalityIdCheck(candicate)) {
								 return new SuccessResult("Tüm alanlar doğrulandı");
							}
							 else {
								 return new ErrorResult("Girdiğiniz TC. numarası ile daha önce kayıt olunmuştur."); 
							}
							
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
			
				 return new ErrorResult("E-posta example@example.com standartlarında olmalıdır."); 
			}
				
			}
			else {
				
				return new ErrorResult("İsim ve Soyisim iki veya daha fazla harf içermelidir"); 
				
			}
			
		}
		else {
	

			return new ErrorResult("İsim,Soyiyim,TC.Kimlik Numarası,Doğum Yılı,E-mail ve Parola alanlarından herhangi biri boş olamaz."); 
		
		}
	}
	

}
