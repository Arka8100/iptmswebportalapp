package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.model.InsurerDetail;

/**
 * 
 * the class tests all the setters and getters and constructors for the Insurer
 * Detail
 *
 */
class InsurerDetailTest {

	InsurerDetail insurerDetail = new InsurerDetail();

	@Test
	void testSetId() {
		insurerDetail.setId(12);
		assertEquals(12, insurerDetail.getId());
	}

	@Test
	void testGetId() {
		insurerDetail.setId(12);
		assertEquals(12, insurerDetail.getId());
	}

	@Test
	void testSetInsurerName() {
		insurerDetail.setInsurerName("XYZ");
		assertEquals("XYZ", insurerDetail.getInsurerName());
	}

	@Test
	void testGetInsurerName() {
		insurerDetail.setInsurerName("XYZ");
		assertEquals("XYZ", insurerDetail.getInsurerName());
	}

	@Test
	void testSetInsurerPackageName() {
		insurerDetail.setInsurerPackageName("Package 1");
		assertEquals("Package 1", insurerDetail.getInsurerPackageName());
	}

	@Test
	void testGetInsurerPackageName() {
		insurerDetail.setInsurerPackageName("Package 1");
		assertEquals("Package 1", insurerDetail.getInsurerPackageName());
	}

	@Test
	void testSetInsuranceAmountLimit() {
		insurerDetail.setInsuranceAmountLimit(123456);
		assertEquals(123456, insurerDetail.getInsuranceAmountLimit());
	}

	@Test
	void testGetInsuranceAmountLimit() {
		insurerDetail.setInsuranceAmountLimit(123456);
		assertEquals(123456, insurerDetail.getInsuranceAmountLimit());
	}

	@Test
	void testSetDisbursementDuration() {
		insurerDetail.setDisbursementDuration(10);
		assertEquals(10, insurerDetail.getDisbursementDuration());
	}

	@Test
	void testGetDisbursementDuration() {
		insurerDetail.setDisbursementDuration(10);
		assertEquals(10, insurerDetail.getDisbursementDuration());
	}

	@Test
	void testInsurerDetail_LongStringStringIntInt() {
		InsurerDetail insurer = new InsurerDetail(12, "XYZ", "Package 1", 123456, 10);
		assertEquals("XYZ", insurer.getInsurerName());
	}

}
