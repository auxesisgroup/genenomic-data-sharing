package com.auxesisgroup.shivom.entity;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "donor_health_survey")
public class DonorHealthSurvey {

	@Id
	@Column(name = "Id")
	public String Id;

	@NotNull(message = "userId cannot be null.")
	@Column(name = "user_id")
	public String userId;

	@NotNull(message = "gender cannot be null.")
	@Column(name = "gender")
	public String gender;

	@Column(name = "Bod")
	public Date Bod;

	@Column(name = "weight")
	public int weight;

	@Column(name = "smoking")
	public String smoking;

	@Column(name = "drinking")
	public String drinking;

	@Column(name = "children")
	public boolean children;

	@NotNull(message = "excercise cannot be null.")
	@Column(name = "excercise")
	public String excercise;

	@Column(name = "headaches")
	public boolean headaches;

	@Column(name = "stomach_abdominal_pain")
	public boolean stomachAbdominalPain;

	@Column(name = "tiredness_fatique")
	public boolean tirednessFatique;

	@Column(name = "chest_pain")
	public boolean chestPain;

	@Column(name = "eating_weight_problems")
	public boolean eatingWeightProblems;

	@Column(name = "skin_problems")
	public boolean skinProblems;

	@Column(name = "trouble_sleeping")
	public boolean troubleSleeping;

	@Column(name = "joint_pain")
	public boolean jointPain;

	@Column(name = "created_on")
	public Timestamp createdOn;

	@Column(name = "height")
	public int height;

}
