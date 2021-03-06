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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candicates")
public class Candicate {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="candicate_id")
	private int id;
	@Column(name="candicate_first_Name")
	private String firstName;
	@Column(name="candicate_last_Name")
	private String lastName;
	@Column(name="candicate_nationality_id")
	private String nationalityId;
	@Column(name="candicate_birth_Year")
	private int birthYear;
	@Column(name="candicate_e_mail")
	private String eMail;
	@Column(name="candicate_password")
	private String password;
	@Column(name="candicate_password2")
	private String password2;
}
