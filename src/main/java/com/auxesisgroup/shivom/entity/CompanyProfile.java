package com.auxesisgroup.shivom.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "company_profile")
public class CompanyProfile {

	@Id
	@Column(name = "Id")
	public String Id;

	
	@NotNull(message = "companyId cannot be null.")
	@Column(name = "company_id")
	public String companyId;

	
	@NotNull(message = "companyName cannot be null.")
	@Column(name = "company_name")
	public String companyName;

	
	@NotNull(message = "speciality cannot be null.")
	@Column(name = "speciality")
	public String speciality;

	
	@NotNull(message = "subSpecialities cannot be null.")
	@Column(name = "sub_specialities")
	public String subSpecialities;

	
	@NotNull(message = "dataSetNeeds cannot be null.")
	@Column(name = "data_set_needs")
	public String dataSetNeeds;

	@Column(name = "created_on")
	public Timestamp createdOn;

}
