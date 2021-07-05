package HrmsProject.hrms.validation.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import HrmsProject.hrms.mailValidation.MailValidationManager;
import HrmsProject.hrms.validation.abstracts.MailValidationService;

@Component
public class MailValidationAdapter implements MailValidationService{
    
	MailValidationManager mailValidationmanager;
	@Autowired
	public MailValidationAdapter(MailValidationManager mailValidationmanager) {
		this.mailValidationmanager=mailValidationmanager;
	}
	@Override
	public void sendMail(String eMail) {
		this.mailValidationmanager.sendMail(eMail);
		
	}

	@Override
	public boolean checkValidationComplete(String eMail) {
		
		return this.mailValidationmanager.checkifMailClicked(eMail);
	}

}
