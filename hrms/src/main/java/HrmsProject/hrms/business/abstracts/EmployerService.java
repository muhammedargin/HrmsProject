package HrmsProject.hrms.business.abstracts;
import java.util.List;
import HrmsProject.hrms.core.utilities.results.DataResult;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.entities.concretes.Employer;


public interface EmployerService {

	
	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);

}
