package HrmsProject.hrms.core.utilities.check.Abstract;
import HrmsProject.hrms.core.utilities.results.Result;
import HrmsProject.hrms.entities.concretes.Candicate;

public interface CandicateCheckService {

	boolean nullCheck(Candicate candicate);
	boolean nameAndSurnameCheck(Candicate candicate);
	boolean regexMailCheck(Candicate candicate);
	boolean unusedMailCheck(Candicate candicate);
	boolean nationalityIdCheck(Candicate candicate);
	boolean passwordLengthCheck(Candicate candicate);
	boolean passwordRepeatCheck(Candicate caandicate);
	Result allCheck(Candicate candicate);
}
