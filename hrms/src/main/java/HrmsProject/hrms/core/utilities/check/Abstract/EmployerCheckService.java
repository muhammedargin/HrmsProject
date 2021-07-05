package HrmsProject.hrms.core.utilities.check.Abstract;

import HrmsProject.hrms.entities.concretes.Employer;

public interface EmployerCheckService{
	
	
	

	public boolean nullCheck(Employer employer);
	
	public boolean passwordCheck(Employer employer);
	
	public boolean domainCheck(Employer employer);
	
	

}
