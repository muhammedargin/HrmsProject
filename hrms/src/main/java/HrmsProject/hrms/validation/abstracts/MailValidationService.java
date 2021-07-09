package HrmsProject.hrms.validation.abstracts;


public interface MailValidationService {
	
	void sendMail(String eMail);
	
	boolean checkValidationComplete(String eMail);

}
