package HrmsProject.hrms.dataaccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HrmsProject.hrms.entities.concretes.Candicate;


public interface CandicateDao extends JpaRepository<Candicate, Integer> {


	

}
