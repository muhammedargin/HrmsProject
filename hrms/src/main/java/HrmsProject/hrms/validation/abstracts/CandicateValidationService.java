package HrmsProject.hrms.validation.abstracts;

import org.springframework.stereotype.Component;

import HrmsProject.hrms.entities.concretes.*;

@Component
public interface CandicateValidationService {
	
	public boolean checkIfRealPerson(Candicate candicate);

}
