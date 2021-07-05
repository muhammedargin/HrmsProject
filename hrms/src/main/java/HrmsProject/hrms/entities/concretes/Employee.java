package HrmsProject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int id;
	@Column(name="employee_firstName")
	private String firstName;
	@Column(name="employee_lastName")
	private String lastName;
	@Column(name="employee_eMail")
	private String eMail;

}
