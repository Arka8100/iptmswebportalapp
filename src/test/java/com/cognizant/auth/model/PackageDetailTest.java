package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.model.PackageDetail;

/**
 * 
 * the class tests all the setters and getters and constructors for the Package
 * Detail
 *
 */
public class PackageDetailTest {

	PackageDetail packageDetail = new PackageDetail();

	@Test
	public void testPackageDetail_StringStringIntInt() {
		PackageDetail detail = new PackageDetail("Package 1", "Urology", 1000, 4);
		assertEquals(1000, detail.getCost());
	}

	@Test
	public void testPackageDetail() {
		PackageDetail detail = new PackageDetail();
		detail.setTestDetail("Urology");
		assertEquals("Urology", detail.getTestDetail());
	}

	@Test
	public void testTreatmentPackageName() {
		packageDetail.setTreatmentPackageName("Package 3");
		assertEquals("Package 3", packageDetail.getTreatmentPackageName());
	}

	@Test
	public void testTestDetails() {
		packageDetail.setTestDetail("OPT1,0PT3");
		assertEquals("OPT1,0PT3", packageDetail.getTestDetail());
	}

	@Test
	public void testCost() {
		packageDetail.setCost(5000);
		assertEquals(5000, packageDetail.getCost());
	}

	@Test
	public void testTreatmentDuration() {
		packageDetail.setTreatmentDurationinWeeks(4);
		assertEquals(4, packageDetail.getTreatmentDurationinWeeks());
	}

	@Test
	public void testtoString() {
		String string = packageDetail.toString();
		assertEquals(string, packageDetail.toString());
	}

}
