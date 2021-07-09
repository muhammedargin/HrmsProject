package HrmsProject.hrms.core.utilities.check.Abstract;

import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.entities.concretes.Candicate;
import HrmsProject.hrms.entities.concretes.Employer;

public interface EmployerCheckService{
	
	
	

	public boolean nullCheck(Employer employer);
	
	boolean regexMailCheck(Employer employer);
	
	public boolean domainCheck(Employer employer);
	
	public boolean unusedMailCheck(Employer employer);
	
	public boolean passwordLengthCheck(Employer employer);
	
	public boolean passwordRepeatCheck(Employer employer);
	
	
	Result allCheck(Employer employer);
	
	

}
