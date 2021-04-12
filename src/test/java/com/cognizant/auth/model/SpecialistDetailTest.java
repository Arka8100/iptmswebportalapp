package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.model.SpecialistDetail;

/**
 * 
 * the class tests all the setters and getters and constructors for the
 * Specialist Detail
 *
 */
public class SpecialistDetailTest {

	SpecialistDetail specialistDetail = new SpecialistDetail();

	@Test
	public void testSpecialistDetail_LongStringStringIntString() {
		SpecialistDetail specialistDetail = new SpecialistDetail(1, "Dr. XYZ", "Urology", 5, "1234567890");
		assertEquals("Dr. XYZ", specialistDetail.getName());

	}

	@Test
	public void testSetId() {
		specialistDetail.setId(101);
		assertEquals(101, specialistDetail.getId());
	}

	@Test
	public void testGetId() {
		specialistDetail.setId(101);
		assertEquals(101, specialistDetail.getId());
	}

	@Test
	public void testSetName() {
		specialistDetail.setName("Dr. XYZ");
		assertEquals("Dr. XYZ", specialistDetail.getName());
	}

	@Test
	public void testGetName() {
		specialistDetail.setName("Dr. XYZ");
		assertEquals("Dr. XYZ", specialistDetail.getName());
	}

	@Test
	public void testSetAreaOfExpertise() {
		specialistDetail.setAreaOfExpertise("Urology");
		assertEquals("Urology", specialistDetail.getAreaOfExpertise());
	}

	@Test
	public void testGetAreaOfExpertise() {
		specialistDetail.setAreaOfExpertise("Urology");
		assertEquals("Urology", specialistDetail.getAreaOfExpertise());

	}

	@Test
	public void testSetExperienceInYears() {
		specialistDetail.setExperienceInYears(10);
		assertEquals(10, specialistDetail.getExperienceInYears());
	}

	@Test
	public void testGetExperienceInYears() {
		specialistDetail.setExperienceInYears(10);
		assertEquals(10, specialistDetail.getExperienceInYears());
	}

	@Test
	public void testSetContactNumber() {
		specialistDetail.setContactNumber("1234567890");
		assertEquals("1234567890", specialistDetail.getContactNumber());
	}

	@Test
	public void testGetContactNumber() {
		specialistDetail.setContactNumber("1234567890");
		assertEquals("1234567890", specialistDetail.getContactNumber());
	}

}
