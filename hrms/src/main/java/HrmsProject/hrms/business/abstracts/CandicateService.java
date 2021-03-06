package HrmsProject.hrms.business.abstracts;

import java.util.List;
import HrmsProject.hrms.core.utilities.results.DataResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.entities.concretes.Candicate;


public interface CandicateService {
	
	Result add(Candicate candicate);
	
	DataResult<List<Candicate>> getAll();

}
