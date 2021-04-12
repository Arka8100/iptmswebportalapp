package com.cognizant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.clients.ICClient;
import com.cognizant.clients.IPTFClient;
import com.cognizant.clients.IPTOFClient;
import com.cognizant.model.Admin;
import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PackageDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.service.AuthFeignService;
import com.cognizant.service.PortalService;

@AutoConfigureMockMvc
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class IPTreatmentControllerTest {

	@Mock
	AuthenticationFeign authClient;
	@Mock
	IPTOFClient iPTFOClient;
	@Mock
	IPTFClient iPTFClient;
	@Mock
	ICClient iCClient;

	@Mock
	PortalService pService;
	@Mock
	AuthFeignService feignService;

	private IPTreatmentController iPTreatmentController;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		iPTreatmentController = new IPTreatmentController(authClient, iPTFClient, iPTFOClient, iCClient, feignService,
				pService);
		mockMvc = MockMvcBuilders.standaloneSetup(iPTreatmentController).build();
	}

	@Test
	void testGetLoginPage() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL))
				.andExpect(MockMvcResultMatchers.status().isOk());

//		Or
//		MvcResult result = this.mockMvc.perform(get("/").header("Authorization", "Bearer Token")).andReturn();
//
//		assertEquals("login2", result.getModelAndView().getViewName());
	}

//	@Test
//	void testGetLogin() throws Exception {
//		Admin user = new Admin("1", "pass", "bhupesh", "token");
//		
//		when(pService.getOnGoingTreatmentPlanList("token")).thenReturn(treatmentPlans);
//		MvcResult result = this.mockMvc.perform(get("/ongoingTreatments").header("Authorization", "Bearer Token"))
//				.andReturn();
//
//		MvcResult result1 = this.mockMvc
//				.perform(
//						get("/ongoingTreatments").header("Authorization", "Bearer token").sessionAttr("token", "token"))
//				.andReturn();
//		assertEquals("redirect:/", result.getModelAndView().getViewName());
//		assertEquals("treatplan2", result1.getModelAndView().getViewName());
//	}

	@Test
	void testGetLoginFail() throws Exception {
		Admin user = new Admin("Arka", "arka", "Arka", "token");
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("userid", user.getUserid());
		map.put("upassword", user.getUpassword());
		map.put("uname", user.getUname());
		map.put("authToken", user.getAuthToken());
		MvcResult result = this.mockMvc.perform(post("/login").header("Authorization", "Bearer token")).andReturn();
		assertEquals("login2", result.getModelAndView().getViewName());
	}

	@Test
	void testGetDashboard() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/admindashboard").header("Authorization", "Bearer Token"))
				.andReturn();
		MvcResult result1 = this.mockMvc
				.perform(get("/admindashboard").header("Authorization", "Bearer token").sessionAttr("token", "token"))
				.andReturn();
		assertEquals("redirect:/", result.getModelAndView().getViewName());
		assertEquals("AdminDashboard2", result1.getModelAndView().getViewName());
	}

	@Test
	void testGetRegister() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/register").param("pId", "1").param("cost", "10000")
				.param("pName", "bhupesh").param("aName", "Urology")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	// throwing null in Iptf client
	@Test
	void testRegisterPatient() throws Exception {
		PatientDetail pDetail = new PatientDetail(1, "Arka", 35, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan plan = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");
		when(pService.registerPatient("token", pDetail, 10000)).thenReturn(plan);
		when(iPTFClient.formulateTreatmentTimetable("token", pDetail, 2500)).thenReturn(plan);
		mockMvc.perform(MockMvcRequestBuilders.post("/registerSubmit").param("name", "sameer").param("age", "24")
				.param("ailment", "Urology").param("treatmentPackageName", "Package 1").param("cost", "12000"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	void testGetPatients() throws Exception {
		List<TreatmentPlan> treatmentPlans = new ArrayList<>();

		PatientDetail pDetail = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan plan = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");

		treatmentPlans.add(plan);
		// when(iPTFClient.getAllPatients("token")).thenReturn(treatmentPlans);
		when(pService.getTreatmentPlanList("token")).thenReturn(treatmentPlans);
		MvcResult result = this.mockMvc.perform(get("/patients").header("Authorization", "Bearer Token")).andReturn();

//		when(iPTFClient.getAllPatients("token")).thenReturn(treatmentPlans);
//		when(pService.getTreatmentPlanList("token")).thenReturn(treatmentPlans);

		MvcResult result1 = this.mockMvc
				.perform(get("/patients").header("Authorization", "Bearer token").sessionAttr("token", "token"))
				.andReturn();
		assertEquals("redirect:/", result.getModelAndView().getViewName());
		assertEquals("patients2", result1.getModelAndView().getViewName());
	}

	@Test
	void testGetTreatmentPlans() throws Exception {
		List<TreatmentPlan> treatmentPlans = new ArrayList<>();

		PatientDetail pDetail = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan plan = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");

		treatmentPlans.add(plan);
		when(pService.getOnGoingTreatmentPlanList("token")).thenReturn(treatmentPlans);
		MvcResult result = this.mockMvc.perform(get("/ongoingTreatments").header("Authorization", "Bearer Token"))
				.andReturn();

		MvcResult result1 = this.mockMvc
				.perform(
						get("/ongoingTreatments").header("Authorization", "Bearer token").sessionAttr("token", "token"))
				.andReturn();
		assertEquals("redirect:/", result.getModelAndView().getViewName());
		assertEquals("treatplan2", result1.getModelAndView().getViewName());
	}

	@Test
	void testGetTreatmentPlansNew() throws Exception {
		List<TreatmentPlan> treatmentPlans = new ArrayList<>();

		PatientDetail pDetail = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan plan = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");

		treatmentPlans.add(plan);
		when(pService.getOnGoingTreatmentPlanList("token")).thenReturn(treatmentPlans);
		MvcResult result = this.mockMvc.perform(get("/ongoingTreatmentsnew").header("Authorization", "Bearer Token"))
				.andReturn();

		MvcResult result1 = this.mockMvc.perform(
				get("/ongoingTreatmentsnew").header("Authorization", "Bearer token").sessionAttr("token", "token"))
				.andReturn();
		assertEquals("redirect:/", result.getModelAndView().getViewName());
		assertEquals("treatmentplan2", result1.getModelAndView().getViewName());
	}

	@Test
	void testGetSpecialist() throws Exception {
		List<SpecialistDetail> specialistDetail = new ArrayList<>();
		specialistDetail.add(new SpecialistDetail(1, "Arka", "Urology", 6, "99555666"));

		when(pService.getSpecialistDetail("token")).thenReturn(specialistDetail);
		MvcResult result = this.mockMvc.perform(get("/specialist").header("Authorization", "Bearer Token")).andReturn();

		MvcResult result1 = this.mockMvc
				.perform(get("/specialist").header("Authorization", "Bearer token").sessionAttr("token", "token"))
				.andReturn();
		assertEquals("redirect:/", result.getModelAndView().getViewName());
		assertEquals("Specialist2", result1.getModelAndView().getViewName());
	}

	@Test
	void testGetPackages() throws Exception {
		PackageDetail pDetail = new PackageDetail("Package 1", "Test 1", 10000, 7);
		List<IPTreatmentPackage> packageDetail = new ArrayList<>();
		packageDetail.add(new IPTreatmentPackage(1L, "Urology", pDetail));

		when(pService.getPackageDetail("token")).thenReturn(packageDetail);
		MvcResult result = this.mockMvc.perform(get("/packages").header("Authorization", "Bearer Token")).andReturn();

		MvcResult result1 = this.mockMvc
				.perform(get("/packages").header("Authorization", "Bearer token").sessionAttr("token", "token"))
				.andReturn();
		assertEquals("redirect:/", result.getModelAndView().getViewName());
		assertEquals("packages2", result1.getModelAndView().getViewName());
	}

	@Test
	void testGetInsurer() throws Exception {
		List<InsurerDetail> insurerDetail = new ArrayList<>();
		insurerDetail.add(new InsurerDetail(1, "Arka", "Urology", 6, 99));

		when(pService.getInsurerDetail("token")).thenReturn(insurerDetail);
		MvcResult result = this.mockMvc.perform(get("/insurer").header("Authorization", "Bearer Token")).andReturn();

		MvcResult result1 = this.mockMvc
				.perform(get("/insurer").header("Authorization", "Bearer token").sessionAttr("token", "token"))
				.andReturn();
		assertEquals("redirect:/", result.getModelAndView().getViewName());
		assertEquals("insurer2", result1.getModelAndView().getViewName());

	}

	@Test
	void testClaimInsurance() throws Exception {
		when(pService.claimInsurance("token")).thenReturn(Mockito.anyList());
		mockMvc.perform(MockMvcRequestBuilders.get("/claimInsurance").param("id", "2").sessionAttr("token", "token"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

//	@Test
//	void testInitiateClaim() throws Exception {
//		
//		
//		InsurerDetail ins = new InsurerDetail(1, "Arka", "Urology", 6, 99);
//		PatientDetail pt = new PatientDetail(1, "Arka", 23, "Urology", "Package 1", "12/05/2021");
//		TreatmentPlan tp = new TreatmentPlan(1, pt, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
//				"InProgress", "12/03/2021", "24/05/2021");
//		
//		InitiateClaim ic = new InitiateClaim(1, tp.getSpecialist(), tp.getTreatmentCommencementDate(),
//				tp.getTreatmentEndDate(), pt.getName(), tp.getStatus(), pt.getAilment(), tp.getPackageName(),
//				tp.getTestDetails(), ins.getInsurerName(), ins.getInsurerPackageName(),
//				ins.getInsuranceAmountLimit(), ins.getDisbursementDuration(), tp.getCost(), 6, pt.getAge(), 0);
//		
//		when(pService.initiateClaim("token",ic)).thenReturn(10000);
//		MvcResult result = this.mockMvc.perform(get("/initiateClaim").header("Authorization", "Bearer Token").param("ptId", "admin").param("pckgName", "Package 1")).andReturn();
//
//		MvcResult result1 = this.mockMvc.perform(post("/initiateClaim").header("Authorization", "Bearer token")
//				.sessionAttr("token", "token").param("ptId", "admin").param("pckgName", "Package 1")).andReturn();
//		assertEquals("redirect:/", result.getModelAndView().getViewName());
//		assertEquals("final2", result1.getModelAndView().getViewName());
//		
//
////		MvcResult result1 = this.mockMvc.perform(post("/initiateClaim").header("Authorization", "Bearer token")
////				.sessionAttr("token", "token").param("pId", "admin").param("pckgName", "Package 1")).andReturn();
////		assertEquals("final2", result1.getModelAndView().getViewName());
//
//	}

	@Test
	void testLogout() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/logout").accept(MediaType.ALL))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
	}

}
