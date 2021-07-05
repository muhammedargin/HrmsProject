package HrmsProject.hrms.validation.abstracts;

import org.springframework.stereotype.Component;

@Component
public interface MailValidationService {
	
	void sendMail(String eMail);
	
	boolean checkValidationComplete(String eMail);

}
