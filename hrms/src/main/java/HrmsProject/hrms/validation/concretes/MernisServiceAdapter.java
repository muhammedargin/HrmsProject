package HrmsProject.hrms.validation.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Component;

import HrmsProject.hrms.entities.concretes.Candicate;
import HrmsProject.hrms.validation.abstracts.CandicateValidationService;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


@Component
public class MernisServiceAdapter implements CandicateValidationService{

	@Override
	public boolean checkIfRealPerson(Candicate candicate) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
boolean result=true;
		
		try {
			result=client.TCKimlikNoDogrula(Long.parseLong(candicate.getNationalityId()), candicate.getFirstName().toUpperCase(new Locale("tr")),
					candicate.getLastName().toUpperCase(new Locale("tr")), candicate.getBirthYear());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

}
