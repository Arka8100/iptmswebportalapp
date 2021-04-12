package com.cognizant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.clients.ICClient;
import com.cognizant.clients.IPTFClient;
import com.cognizant.clients.IPTOFClient;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;

@ExtendWith(MockitoExtension.class)
class PortalServiceTest {
	/*
	 * @Mock private ProcessResponseRepository processResponseRepository;
	 * 
	 * @Mock private ProcessRequestRepository processRequestRepository;
	 * 
	 * @Mock private PackagingAndDeliveryFeignClient
	 * packagingAndDeliveryFeignClient;
	 * 
	 * 
	 * private static ProcessService processService;
	 * 
	 * Random random = new Random();
	 * 
	 * @BeforeEach public void setUp() throws Exception{
	 * MockitoAnnotations.openMocks(this); processService = new
	 * ProcessAccessoryService(processResponseRepository,processRequestRepository,
	 * packagingAndDeliveryFeignClient); loadProcessResponse(); }
	 */

	@Mock
	AuthenticationFeign authClient;
	@Mock
	IPTOFClient iPTFOClient;
	@Mock
	IPTFClient iPTFClient;
	@Mock
	ICClient iCClient;

	@InjectMocks
	PortalService pService;

//	@BeforeEach
//	public void setup() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		pService = new PortalService(iPTFClient, iPTFOClient, iCClient);
//		System.out.println(iPTFOClient);
//	}

	@Test
	void testGetSpecialistDetail() {
		List<SpecialistDetail> specialistDetail = new ArrayList<>();
		specialistDetail.add(new SpecialistDetail(1, "Arka", "Urology", 6, "99555666"));
		ResponseEntity<List<SpecialistDetail>> entity = new ResponseEntity<List<SpecialistDetail>>(specialistDetail,
				HttpStatus.OK);
		when(iPTFOClient.getSpecialists("token")).thenReturn(entity);
		assertEquals("Arka", pService.getSpecialistDetail("token").get(0).getName());

	}

	@Test
	void testGetInsurerDetailString() {
		List<InsurerDetail> insurerDetail = new ArrayList<>();
		insurerDetail.add(new InsurerDetail(1, "Arka", "Urology", 6, 99));

		when(iCClient.getAllInsurerDetail("token")).thenReturn(insurerDetail);

		assertEquals("Arka", pService.getInsurerDetail("token").get(0).getInsurerName());
	}

	@Test
	void testRegisterPatient() {
		PatientDetail pDetail = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan patient = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");

		when(iPTFClient.formulateTreatmentTimetable("token", pDetail, 2500)).thenReturn(patient);

		assertEquals("Dr.Bhupesh Mahakhuda", pService.registerPatient("token", pDetail, 2500).getSpecialist());

	}

//	@Test
//	void testGetPackageDetail() {
//		PackageDetail pDetail = new PackageDetail("Package 1", "Test 1", 10000, 7);
//		List<IPTreatmentPackage> packageDetail = new ArrayList<>();
//		packageDetail.add(new IPTreatmentPackage(1L, "Urology", pDetail));
//
////		ResponseEntity<List<IPTreatmentPackage>> entity = new ResponseEntity<List<IPTreatmentPackage>>(packageDetail,HttpStatus.OK);
////		@SuppressWarnings("unchecked")
////		when((List<IPTreatmentPackage>) iPTFOClient.getIPTreatmentPackages("token").getBody())
////				.thenReturn(packageDetail);
//
//		pService.getPackageDetail("token");
//
////		assertEquals(1L, pService.getPackageDetail("token").get(0).getId());
//	}

	@Test
	void testGetTreatmentPlanList() {
		List<TreatmentPlan> treatmentPlans = new ArrayList<>();

		PatientDetail pDetail = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan plan = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");

		treatmentPlans.add(plan);
		when(iPTFClient.getAllPatients("token")).thenReturn(treatmentPlans);

		assertEquals("Dr.Bhupesh Mahakhuda", pService.getTreatmentPlanList("token").get(0).getSpecialist());
	}

	@Test
	void testGetOnGoingTreatmentPlanList() {
		List<TreatmentPlan> treatmentPlans = new ArrayList<>();

		PatientDetail pDetail = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan plan = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");

		treatmentPlans.add(plan);

		when(iPTFClient.getAllOnGoingTreatments("token")).thenReturn(treatmentPlans);
		assertEquals("InProgress", pService.getOnGoingTreatmentPlanList("token").get(0).getStatus());

	}

	@Test
	void testClaimInsurance() {
		List<InsurerDetail> insurerDetail = new ArrayList<>();
		insurerDetail.add(new InsurerDetail(1, "Arka", "Urology", 6, 99));

		when(iCClient.getAllInsurerDetail("token")).thenReturn(insurerDetail);
		assertEquals(1, pService.claimInsurance("token").get(0).getId());
	}

	@Test
	void testGetInsurerDetailStringString() {
		List<InsurerDetail> insurerDetail = new ArrayList<>();
		insurerDetail.add(new InsurerDetail(1, "Arka", "Urology", 6, 99));

		when(iCClient.getInsurerDetail("package 1", "token")).thenReturn(insurerDetail.get(0));
		assertEquals("Arka", pService.getInsurerDetail("package 1", "token").getInsurerName());
	}

	@Test
	void testGetPatientDetail() {
		PatientDetail pDetail = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
		when(iPTFClient.getPatient(1, "token")).thenReturn(pDetail);

		assertEquals(1, pService.getPatientDetail(1, "token").getId());
	}

	@Test
	void testGetTreatmentDetail() {
		PatientDetail pDetail = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan plan = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");

		when(iPTFClient.getAPlan(1, "token")).thenReturn(plan);
		assertEquals("Dr.Bhupesh Mahakhuda", pService.getTreatmentDetail(1, "token").getSpecialist());
	}

	@Test
	void testInitiateClaim() {
		InitiateClaim initiateClaim = new InitiateClaim(1L, "Dr John", "12/12/2020", "1/1/2021", "Bhupesh",
				"In progress", "Urology", "package 1", "Test 1", "LIC", "Ipackage 1", 10000, 10, 100000, 7, 25, 200000);
		when(iCClient.initiateClaim("token", initiateClaim)).thenReturn(initiateClaim.getFinalCost());

		assertEquals(200000, pService.initiateClaim("token", initiateClaim));
	}

	@Test
	void testUpdatePlan() {

//		Mockito.verify(pService, Mockito.times(1)).updatePlan(1, "token");
		pService.updatePlan(1, "token");
	}

	@Test
	void testGetTokenWithHeader() {

		assertEquals("Bearer token", pService.getTokenWithHeader("token"));
	}

}
