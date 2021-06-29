package HrmsProject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobs")
public class JobPost {
	
	
	
	public JobPost() {
		
		
	}
	
	public JobPost(int id, String job_title, String company) {
		super();
		this.id = id;
		this.job_title = job_title;
		this.company = company;
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="job_title")
	private String job_title;
	@Column(name="company")
	private String company;

}
