package HrmsProject.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import HrmsProject.hrms.core.utilities.results.DataResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.entities.concretes.Candicate;

@Service
public interface CandicateService {
	
	Result add(Candicate candicate);
	
	DataResult<List<Candicate>> getAll();

}
