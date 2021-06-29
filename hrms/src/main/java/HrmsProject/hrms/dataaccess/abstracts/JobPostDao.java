package HrmsProject.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HrmsProject.hrms.entities.concretes.JobPost;

public interface JobPostDao extends JpaRepository<JobPost, Integer>{

}
