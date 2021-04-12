package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.PatientDetail;
import com.cognizant.model.TreatmentPlan;

/**
 * 
 * Feign provides an abstraction over REST-based calls via annotation, by which
 * microservices can use to communicate with each other without writing detailed
 * REST client code In the @FeignClient annotation the String value
 * ("iptms-treatments-microservice") is the name of the microservice, and URL
 * field is to reach the correct Microservice
 * 
 */
@FeignClient(url = "http://iptmstreatment-env.eba-uwu8wr9i.us-east-2.elasticbeanstalk.com/iptms", name = "iptms-treatments-microservice")
public interface IPTFClient {
	/**
	 * this method will create the TimeTable for a patient according to a Particular
	 * Treatment
	 * 
	 * @param token
	 * @param PatientDetail Object
	 * @param int           Cost
	 * @return TreatmentPlan Object
	 */
	@RequestMapping(value = "/formulatetreatmenttimetable/{cost}", method = RequestMethod.POST)
	public TreatmentPlan formulateTreatmentTimetable(@RequestHeader("Authorization") String token,
			@RequestBody PatientDetail patientDetail, @PathVariable int cost);

	/**
	 * this method will return a patient based on patient Id.
	 * 
	 * @param token
	 * @param Long  PatientId
	 * @return PatientDetail Object
	 */
	@GetMapping("/getpatient/{ptId}")
	public PatientDetail getPatient(@PathVariable long ptId, @RequestHeader("Authorization") String token);

	/**
	 * this method will return All the Patients Treatment Plan.
	 * 
	 * @param token
	 * @return List<TreatmentPlan>
	 */
	@GetMapping("/getallplans")
	public List<TreatmentPlan> getAllPatients(@RequestHeader("Authorization") String token);

	/**
	 * this method will return All the Patients Whose Treatment is currently Going
	 * On.
	 * 
	 * @param token
	 * @return List<TreatmentPlan>
	 */
	@GetMapping("/getallongoingtreatments")
	public List<TreatmentPlan> getAllOnGoingTreatments(@RequestHeader("Authorization") String token);

	/**
	 * this method will return the treatment plan for a particular user based on
	 * PateintId.
	 * 
	 * @param token
	 * @param Long  PatientId
	 * @return TreatmentPlan Object
	 */
	@GetMapping("/getplan/{ptId}")
	public TreatmentPlan getAPlan(@PathVariable long ptId, @RequestHeader("Authorization") String token);

	/**
	 * this method will update the patient Status from In-Progress to Complete.
	 * 
	 * @param token
	 * @param Long  PatientId
	 */
	@PutMapping("/updateplan/{pId}")
	public void updatePlan(@PathVariable long pId, @RequestHeader("Authorization") String token);
}
