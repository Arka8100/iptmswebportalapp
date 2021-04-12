package com.cognizant.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * model class for Specialist Details
 * 
 * @Data is a convenient shortcut annotation that bundles the features
 *       of @ToString , @EqualsAndHashCode , @Getter / @Setter
 *       and @RequiredArgsConstructor together
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpecialistDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String areaOfExpertise;
	private int experienceInYears;
	private String contactNumber;

	@Override
	public String toString() {
		return "SpecialistDetail [id=" + id + ", name=" + name + ", areaOfExpertise=" + areaOfExpertise
				+ ", experienceInYears=" + experienceInYears + ", contactNumber=" + contactNumber + "]";
	}

}
