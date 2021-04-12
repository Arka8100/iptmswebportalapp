package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.model.PatientDetail;

/**
 * 
 * the class tests all the setters and getters and constructors for the Patient
 * Detail
 *
 */
class PatientDetailTest {

	PatientDetail patientDetail = new PatientDetail();

	@Test
	void testPatientDetail_LongStringIntStringStringString() {
		PatientDetail patientData = new PatientDetail(101, "Harry", 24, "Urology", "Package 1", "10/11/2020");
		assertEquals(101, patientData.getId());

	}

	@Test
	void testSetId() {
		patientDetail.setId(101);
		assertEquals(101, patientDetail.getId());

	}

	@Test
	void testGetId() {
		patientDetail.setId(101);
		assertEquals(101, patientDetail.getId());
	}

	@Test
	void testSetName() {
		patientDetail.setName("Harry");
		;
		assertEquals("Harry", patientDetail.getName());
	}

	@Test
	void testGetName() {

		patientDetail.setName("Harry");
		;
		assertEquals("Harry", patientDetail.getName());

	}

	@Test
	void testSetAge() {
		patientDetail.setAge(24);
		assertEquals(24, patientDetail.getAge());
	}

	@Test
	void testGetAge() {
		patientDetail.setAge(24);

		assertEquals(24, patientDetail.getAge());
	}

	@Test
	void testSetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology", patientDetail.getAilment());
	}

	@Test
	void testGetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology", patientDetail.getAilment());
	}

	@Test
	void testSetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1", patientDetail.getTreatmentPackageName());
	}

	@Test
	void testGetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1", patientDetail.getTreatmentPackageName());
	}

	@Test
	void testSetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", patientDetail.getTreatmentCommencementDate());
	}

	@Test
	void testGetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", patientDetail.getTreatmentCommencementDate());
	}

}
