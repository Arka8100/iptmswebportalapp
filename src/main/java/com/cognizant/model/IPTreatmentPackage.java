package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * model class for IP Treatment Packages
 * 
 * @Data is a convenient shortcut annotation that bundles the features
 *       of @ToString , @EqualsAndHashCode , @Getter / @Setter
 *       and @RequiredArgsConstructor together
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IPTreatmentPackage {

	private long id;
	private String ailmentCategory;
	PackageDetail packageDetail;

	@Override
	public String toString() {
		return "IPTreatmentPackage [id=" + id + ", ailmentCategory=" + ailmentCategory + ", packageDetail="
				+ packageDetail + "]";
	}

}