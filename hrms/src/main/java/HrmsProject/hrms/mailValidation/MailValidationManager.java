package HrmsProject.hrms.mailValidation;

import org.springframework.stereotype.Component;

@Component
public class MailValidationManager {
//dış servis olarak simule edilmiştir
	
	public void sendMail(String eMail) {
		
		System.out.println(eMail+ " Adresine Doğrulama maili gönderilmiştir.");
		
		
	};
	
	public boolean checkifMailClicked(String eMail)  {
		System.out.println(eMail+" Adresinde doğrulama mailine tıklandı ve doğrulama gerçekleştirildi.");
		return true;
	}
}
