package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.model.TreatmentPlan;

/**
 * 
 * the class tests all the setters and getters and constructors for the
 * Treatment Plan
 *
 */
class TreatmentPlanTest {

	TreatmentPlan treatmentPlan = new TreatmentPlan();

	@Test
	void testSetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	@Test
	void testGetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	@Test
	void testSetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	@Test
	void testGetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	@Test
	void testSetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	@Test
	void testGetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	@Test
	void testSetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	@Test
	void testGetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	@Test
	void testSetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	@Test
	void testGetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	@Test
	void testSetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	@Test
	void testGetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	@Test
	void testSetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

	@Test
	void testGetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}
	
	public void toStringreturnsEmptyString()
	{
		TreatmentPlan classUnderTest = new TreatmentPlan();

	    assertEquals(classUnderTest.toString(), "");
	}

}
