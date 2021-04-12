package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * model class for Treatment Plan of a Patient
 * 
 * 
 * @Data is a convenient shortcut annotation that bundles the features
 *       of @ToString , @EqualsAndHashCode , @Getter / @Setter
 *       and @RequiredArgsConstructor together
 *
 */
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TreatmentPlan {

	private long id;
	private PatientDetail ptDetail; // added
	private String testDetails; // changed
	private String packageName; // changed
	private String specialist;
	private int cost;
	private String status;
	private String treatmentCommencementDate;
	private String treatmentEndDate;

}
