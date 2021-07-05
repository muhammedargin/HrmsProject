package HrmsProject.hrms.core.utilities.check.concrete;
import org.springframework.stereotype.Component;

import HrmsProject.hrms.core.utilities.check.Abstract.EmployerCheckService;
import HrmsProject.hrms.entities.concretes.Employer;

@Component
public class EmployerCheckManager implements EmployerCheckService{
	
	
	@Override
	public boolean nullCheck(Employer employer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean passwordCheck(Employer employer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean domainCheck(Employer employer) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
