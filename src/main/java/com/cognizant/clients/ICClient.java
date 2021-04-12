package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;

/**
 * 
 * Feign provides an abstraction over REST-based calls via annotation, by which
 * microservices can use to communicate with each other without writing detailed
 * REST client code In the @FeignClient annotation the String value
 * ("insurance-claim-microservice") is the name of the microservice, and URL
 * field is to reach the correct Microservice
 * 
 */
@FeignClient(url = "http://Iptmsinsurance-env-1.eba-yccu6zc4.us-east-2.elasticbeanstalk.com/iptms", name = "insurance-claim-microservice")
public interface ICClient {
	/**
	 * This Method will get all of the available Insurance Providers.
	 * 
	 * @param Authorization Token
	 * @return List<InsurerDetail>
	 */
	@RequestMapping(value = "/getallinsurerdetail", method = RequestMethod.GET)
	public List<InsurerDetail> getAllInsurerDetail(@RequestHeader("Authorization") String token);

	/**
	 * This Method will get a Specific Provider from the List of the available
	 * Insurance Providers.
	 * 
	 * @param Authorization Token
	 * @param String        Package Name
	 * @return Object of InsurerDetail
	 */
	@RequestMapping(value = "/getinsurerbypackagename/{packageName}", method = RequestMethod.GET)
	public InsurerDetail getInsurerDetail(@PathVariable String packageName,
			@RequestHeader("Authorization") String token);

	/**
	 * This Method will get the details of the Insured Pateint.
	 * 
	 * @param Authorization Token
	 * @param Patient       id
	 * @return InitiateClaim Object
	 */
	@RequestMapping(value = "/getinsuredpatient/{patientId}", method = RequestMethod.GET)
	public InitiateClaim getInsurerdPatient(@RequestHeader("Authorization") String token, @PathVariable long patientId);

	/**
	 * This Method will get the details of the Insured Pateint.
	 * 
	 * @param Authorization Token
	 * @param InitiateClaim Object
	 * @return InitiateClaim Object
	 */

	@RequestMapping(value = "/initiateclaim", method = RequestMethod.POST)
	public int initiateClaim(@RequestHeader("Authorization") String token, @RequestBody InitiateClaim initiateClaim);
}
