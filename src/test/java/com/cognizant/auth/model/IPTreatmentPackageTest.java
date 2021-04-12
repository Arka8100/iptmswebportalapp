package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.PackageDetail;

/**
 * 
 * the class tests all the setters and getters and constructors for the IP
 * Treatment Package
 *
 */
public class IPTreatmentPackageTest {

	IPTreatmentPackage ipTreatment = new IPTreatmentPackage();

	@Test
	public void testIPTreatmentPackageDetail_LongStringPackage() {
		PackageDetail detail = new PackageDetail();
		IPTreatmentPackage treatment = new IPTreatmentPackage(101, "Urology", detail);

		assertEquals(101, treatment.getId());
	}

	@Test
	public void testSetId() {
		ipTreatment.setId(10);
		assertEquals(10, ipTreatment.getId());
	}

	@Test
	public void testGetId() {
		ipTreatment.setId(10);
		assertEquals(10, ipTreatment.getId());

	}

	@Test
	public void testSetAilmentCategory() {
		ipTreatment.setAilmentCategory("Urology");
		assertEquals("Urology", ipTreatment.getAilmentCategory());
	}

	@Test
	public void testGetAilmentCategory() {
		ipTreatment.setAilmentCategory("Urology");
		assertEquals("Urology", ipTreatment.getAilmentCategory());
	}

	@Test
	public void testSetPackageDetail() {
		PackageDetail detail = new PackageDetail();
		ipTreatment.setPackageDetail(detail);
		assertEquals(detail, ipTreatment.getPackageDetail());
	}

	@Test
	public void testGetPackageDetail() {
		PackageDetail detail = new PackageDetail();
		ipTreatment.setPackageDetail(detail);
		assertEquals(detail, ipTreatment.getPackageDetail());
	}

}
