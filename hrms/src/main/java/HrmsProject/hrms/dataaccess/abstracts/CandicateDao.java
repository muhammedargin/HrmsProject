package HrmsProject.hrms.dataaccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import HrmsProject.hrms.entities.concretes.Candicate;


public interface CandicateDao extends JpaRepository<Candicate, Integer> {

}
