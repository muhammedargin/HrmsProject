package HrmsProject.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import HrmsProject.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employer {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int id;
	@Column(name="employer_name")
	private String employerName;
	@Column(name="employer_website")
	private String employerWebsite;
	@Column(name="employer_e_mail")
	private String eMail;
	@Column(name="employer_phone")
	private String employerPhoneNumber;
	@Column(name="employer_password")
	private String password;
	@Column(name="employer_password2")
	private String password2;

}
