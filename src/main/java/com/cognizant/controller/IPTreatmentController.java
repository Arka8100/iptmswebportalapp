package com.cognizant.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.clients.ICClient;
import com.cognizant.clients.IPTFClient;
import com.cognizant.clients.IPTOFClient;
import com.cognizant.model.Admin;
import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.service.AuthFeignService;
import com.cognizant.service.PortalService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Controller annotation is used to mark any java class as a controller class
 * 
 * @Slf4j (Simple Logging Facade for Java) provides a simple abstraction of all
 *        the logging frameworks
 */

@RestController
@Slf4j
public class IPTreatmentController {

	/**
	 * autowires the AuthClient(feign client) to communicate with authorization
	 */

	@SuppressWarnings("unused")
	@Autowired
	private AuthenticationFeign authClient;
	/**
	 * autowires the IPTFClient(IP-treatments-Microservice feign client) to
	 * communicate with authorization
	 *
	 */
	@Autowired
	IPTFClient iPTFClient;
	/**
	 * autowires the IPTFOClient(IP-treatment-Offernings feign client) to
	 * communicate with authorization
	 *
	 */
	@Autowired
	IPTOFClient iPTFOClient;
	/**
	 * autowires the ICClient(Insurance-Claim-Microservice feign client) to
	 * communicate with authorization
	 *
	 */
	@Autowired
	ICClient iCClient;
	/**
	 * autowires the AuthFeignService Class for Authorization Purpose
	 *
	 */
	@Autowired
	private AuthFeignService feignService;
	/**
	 * autowires the PortalService Class for Application FLow
	 *
	 */
	@Autowired
	private PortalService portalService = new PortalService();

	public IPTreatmentController(AuthenticationFeign authClient, IPTFClient iPTFClient, IPTOFClient iPTFOClient,
			ICClient iCClient, AuthFeignService feignService, PortalService portalService) {
		super();
		this.authClient = authClient;
		this.iPTFClient = iPTFClient;
		this.iPTFOClient = iPTFOClient;
		this.iCClient = iCClient;
		this.feignService = feignService;
		this.portalService = portalService;
	}

	/**
	 * Method-GET, http://localhost:8098/ This method will return the login page
	 * 
	 * @return login jsp page
	 */
	@GetMapping(value = "/")
	public ModelAndView getLoginPage() {
		log.info("START :: Method :: getLoginPage() :: ");
		return new ModelAndView("login2");
	}

	/**
	 * Method-POST, http://localhost:8098/login This method will perform the Login
	 * Opertaion by Validating the User Credentials
	 * 
	 * @param Admin              Object
	 * @param HttpServletRequest object
	 *
	 * @return AdminDashboard JSP Page after Successful Authentication
	 */
	@PostMapping(value = "/login")
	public ModelAndView getLogin(@ModelAttribute("user") Admin user, HttpServletRequest request) {
		log.info("START :: Method :: getLogin() :: ");
		Admin admin = null;
		try {
			@SuppressWarnings("unchecked")
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) feignService.getToken(user).getBody();
			// response = feignService.getToken(user);
			admin = new Admin(map.get("userid"), map.get("upassword"), map.get("uname"), map.get("authToken"));

		} catch (Exception e) {
			ModelAndView mAV = new ModelAndView("login2");
			String invalidLogin = "Username or password is Incorrect";
			mAV.addObject("error", invalidLogin);

			return mAV;
		}
		request.getSession().setAttribute("token", "Bearer " + admin.getAuthToken());
		request.getSession().setAttribute("name", admin.getUserid());
		return new ModelAndView("AdminDashboard2");
	}

	/**
	 * Method-GET, http://localhost:8098/admindashboard This method will return the
	 * Admin Dashboard
	 * 
	 * @return AdminDashboard jsp page
	 */
	@GetMapping(value = "/admindashboard")
	public ModelAndView getDashboard(HttpServletRequest request) {
		log.info("START :: Method :: getDashboard() :: ");
		String token = (String) request.getSession().getAttribute("token");
		if (token != null) {

			return new ModelAndView("AdminDashboard2");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	/**
	 * Method-POST, http://localhost:8098/register This method will register a
	 * Patient based on the Ailment and treatment Package Chosen
	 * 
	 * @param pid
	 * @param cost
	 * @param packageName
	 * @param Aliment
	 * @param HttpServletRequest object
	 * @return Registration jsp page
	 */
	@PostMapping(value = "/register")
	public ModelAndView getRegister(@RequestParam("pId") String id, @RequestParam("cost") int cost,
			@RequestParam("pName") String pack, @RequestParam("aName") String ailment) {
		log.info("START :: Method :: getRegister() :: ");
		ModelAndView mAV = new ModelAndView("registration2");
		mAV.addObject("pack", pack);
		mAV.addObject("ailment", ailment);
		mAV.addObject("cost", cost);
		return mAV;
	}

	/**
	 * Method-POST, http://localhost:8098/registerSubmit This method will register a
	 * Patient based on the Ailment and treatment Package Chosen and Create a
	 * Treatment Plan
	 * 
	 * @param name
	 * @param age
	 * @param aliment
	 * @param packagename
	 * @param cost
	 * @param HttpServletRequest object
	 * @return Treatplan jsp page
	 */
	@PostMapping(value = "/registerSubmit")
	public ModelAndView registerPatient(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("ailment") String ailment, @RequestParam("treatmentPackageName") String pkg,
			@RequestParam("cost") int cost, HttpServletRequest request) {
		log.info("START :: Method :: registerPatient() :: ");
		PatientDetail patient = new PatientDetail(0, name, age, ailment, pkg, null);
		if (patient.getTreatmentPackageName().equalsIgnoreCase("Package 1"))
			patient.setTreatmentPackageName("package1");
		else if (patient.getTreatmentPackageName().equalsIgnoreCase("Package 2"))
			patient.setTreatmentPackageName("package2");
		String token = (String) request.getSession().getAttribute("token");
		TreatmentPlan tp = portalService.registerPatient(token, patient, cost);
		log.debug("tp", tp);
		ModelAndView mAV = new ModelAndView("particulartreatplan2");
		mAV.addObject("plan", tp);
		return mAV;
	}

	/**
	 * Method-GET, http://localhost:8098/patients
	 * 
	 * this method will return the List of the Patient whose Treatment is going On.
	 * 
	 * @param HttpServletRequest object
	 * @return Patient JSP page
	 * 
	 */

	@GetMapping(value = "/patients")
	public ModelAndView getPatients(HttpServletRequest request) {
		log.info("START :: Method :: getPatients() :: ");
		String token = (String) request.getSession().getAttribute("token");
//		@SuppressWarnings("unused")
//		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("patients2");
			List<TreatmentPlan> patient = portalService.getTreatmentPlanList(token);
			mAV.addObject("patient", patient);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * Method-GET, http://localhost:8098/ongoingTreatments
	 * 
	 * this method will return the List of the Patient whose Treatment is going On
	 * And Status can be changed.
	 * 
	 * @param HttpServletRequest object
	 * @return treatplan JSP page
	 *
	 */
	@GetMapping(value = "/ongoingTreatments")
	public ModelAndView getTreatmentPlans(HttpServletRequest request) {
		log.info("START :: Method :: getTreatmentPlans() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("treatplan2");
			List<TreatmentPlan> patient = portalService.getOnGoingTreatmentPlanList(token);
			mAV.addObject("patient", patient);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * Method-GET, http://localhost:8098/ongoingTreatmentsnew
	 * 
	 * this method will return the List of the Patient whose Treatment is going On.
	 * 
	 * @param HttpServletRequest object
	 * @return treatmentplan JSP page
	 *
	 */
	@GetMapping(value = "/ongoingTreatmentsnew")
	public ModelAndView getTreatmentPlansNew(HttpServletRequest request) {
		log.info("START :: Method :: getTreatmentPlans() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("treatmentplan2");
			List<TreatmentPlan> patient = portalService.getOnGoingTreatmentPlanList(token);
			mAV.addObject("patient", patient);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * Method-GET, http://localhost:8098/specialist
	 * 
	 * this method will return the List of Specialist Available in the Hospital.
	 * 
	 * @param HttpServletRequest object
	 * @return Specialist jsp page
	 * 
	 */
	@GetMapping(value = "/specialist")
	public ModelAndView getSpecialist(HttpServletRequest request) {
		log.info("START :: Method :: getSpecialist() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("Specialist2");
			List<SpecialistDetail> specialists = portalService.getSpecialistDetail(token);
			mAV.addObject("specialist", specialists);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	/**
	 * Method-GET, http://localhost:8098/packages
	 * 
	 * this method will return the List of Treatment Packages Available at the
	 * Hospital.
	 * 
	 * @param HttpServletRequest object
	 * @return packages jsp page
	 * 
	 */
	@GetMapping(value = "/packages")
	public ModelAndView getPackages(HttpServletRequest request) {
		log.info("START :: Method :: getPackages() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");

		if (token != null) {
			ModelAndView mAV = new ModelAndView("packages2");
			List<IPTreatmentPackage> pckgresponse = portalService.getPackageDetail(token);
			mAV.addObject("package", pckgresponse);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	/**
	 * Method-GET, http://localhost:8098/insurer
	 * 
	 * this method will return the List of Insurance Providers Available in the
	 * Hospital.
	 * 
	 * @param HttpServletRequest object
	 * @return insurer jsp page
	 * 
	 */

	@GetMapping(value = "/insurer")
	public ModelAndView getInsurer(HttpServletRequest request) {
		log.info("START :: Method :: getInsurer() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("insurer2");
			List<InsurerDetail> insurer = portalService.getInsurerDetail(token);
			mAV.addObject("insurer", insurer);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	/**
	 * Method-GET, http://localhost:8098/claimInsurance
	 * 
	 * this method will return the List of Insurer Available in the Hospital for a
	 * Particular Patient.
	 * 
	 * @param pid
	 * @param HttpServletRequest object
	 * @return Claim jsp page
	 * 
	 */
	@GetMapping(value = "/claimInsurance")
	public ModelAndView claimInsurance(@RequestParam("id") int ptId, HttpServletRequest request) {
		log.info("START :: Method :: claimInsurance() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {

			ModelAndView mAV = new ModelAndView("claim2");
			List<InsurerDetail> insurers = portalService.claimInsurance(token);
			mAV.addObject("ptId", ptId);
			mAV.addObject("insurers", insurers);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * Method-POST, http://localhost:8098/initiateClaim
	 * 
	 * this method will return the FInal Amount payable by a patient after the
	 * insurance claim is Settled.
	 * 
	 * @param pid
	 * @param packageName
	 * @param HttpServletRequest object
	 * @return final jsp page
	 * 
	 */

	@PostMapping(value = "/initiateClaim")
	public ModelAndView initiateClaim(@RequestParam("ptId") long ptId, @RequestParam String pckgName,
			HttpServletRequest request) {
		log.info("START :: Method :: initiateClaim() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");

		if (token != null) {
			InsurerDetail ins = portalService.getInsurerDetail(pckgName, token);
			PatientDetail pt = portalService.getPatientDetail(ptId, token);
			TreatmentPlan tp = portalService.getTreatmentDetail(ptId, token);
			if (log.isDebugEnabled()) {
				log.debug("date", tp.getTreatmentCommencementDate());
				log.debug("", pt.getId() + " " + tp.getSpecialist() + " " + tp.getTreatmentCommencementDate() + " "
						+ tp.getTreatmentEndDate() + " " + pt.getName() + " " + tp.getStatus() + " " + pt.getAilment()
						+ " " + tp.getPackageName() + " " + tp.getTestDetails() + " " + ins.getInsurerName() + " "
						+ ins.getInsurerPackageName() + " " + ins.getInsuranceAmountLimit() + " "
						+ ins.getDisbursementDuration() + " " + tp.getCost() + " " + 6 + " " + pt.getAge() + " " + 0);
			}
			InitiateClaim ic = new InitiateClaim(1, tp.getSpecialist(), tp.getTreatmentCommencementDate(),
					tp.getTreatmentEndDate(), pt.getName(), tp.getStatus(), pt.getAilment(), tp.getPackageName(),
					tp.getTestDetails(), ins.getInsurerName(), ins.getInsurerPackageName(),
					ins.getInsuranceAmountLimit(), ins.getDisbursementDuration(), tp.getCost(), 6, pt.getAge(), 0);
			int amt = portalService.initiateClaim(token, ic);
			portalService.updatePlan(ptId, token);
			ModelAndView mAV = new ModelAndView("final2");
			mAV.addObject("Outstanding", amt);
			mAV.addObject("InsurAmt", ins.getInsuranceAmountLimit());
			mAV.addObject("total", tp.getCost());

			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * Method-get, http://localhost:8098/logout
	 * 
	 * this method will inValidate the session of the Current User
	 *
	 * @param HttpServletRequest object
	 * @return login jsp page
	 * 
	 */
	@GetMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		log.info("START :: Method :: logout() :: ");
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}

}
