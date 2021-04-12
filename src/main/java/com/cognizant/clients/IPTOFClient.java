package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.SpecialistDetail;

/**
 * 
 * Feign provides an abstraction over REST-based calls via annotation, by which
 * microservices can use to communicate with each other without writing detailed
 * REST client code In the @FeignClient annotation the String value
 * ("ipt-offering-microservice") is the name of the microservice, and URL field
 * is to reach the correct Microservice
 * 
 */
@FeignClient(url = "http://iptmsoffering-env.eba-wxzc3nms.us-east-2.elasticbeanstalk.com/iptms", name = "ipt-offering-microservice")
public interface IPTOFClient {
	/**
	 * this method will return All the Treatment Packages available in the Hospital
	 * 
	 * @param token
	 * @return List<IPTreatmentPackages>
	 */
	@RequestMapping(path = "/iptreatmentpackages", method = RequestMethod.GET)
	public ResponseEntity<?> getIPTreatmentPackages(@RequestHeader(name = "Authorization") String token);

	/**
	 * this method will return the Treatment Package based on PackageName and
	 * Category
	 * 
	 * @param token
	 * @param Category
	 * @param packageName
	 * @return IPTreatmentPackages Object
	 */
	@RequestMapping(path = "/iptreatmentpackagebyname/{category}/{packageName}", method = RequestMethod.GET)
	public ResponseEntity<?> getIPTreatmentPackageByAilmentCategoryAndName(@PathVariable String category,
			@PathVariable String packageName, @RequestHeader(name = "Authorization") String token);

	/**
	 * this method will return All the Specialist available in the Hospital
	 * 
	 * @param token
	 * @return List<SpecialistDetails>
	 */
	@RequestMapping(path = "/specialists", method = RequestMethod.GET)
	public ResponseEntity<List<SpecialistDetail>> getSpecialists(@RequestHeader(name = "Authorization") String token);
}
