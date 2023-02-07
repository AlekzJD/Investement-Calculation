package practicascloud.baselineservice.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicascloud.baselineservice.model.ServiceRequest;
import practicascloud.baselineservice.model.ServiceResponse;
import practicascloud.baselineservice.service.IServiceCalculation;

/**
 * @author Daniel Alejandro Jiménez Cervantes 
 *
 */
@RestController
@RequestMapping(value = "/service")
public class ServiceController {
	
	@Autowired
	private IServiceCalculation iServiceCalculation;
	
	@CrossOrigin
	@PostMapping(value = "/calculation", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> investmentCalculation(@Valid @RequestBody ServiceRequest request, Errors errors) {
		
		ServiceResponse response = new ServiceResponse();
		
		if(errors.hasErrors()) {
			response.setMessage(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(response);
		}
		
		response = iServiceCalculation.calculation(request);
		
		return ResponseEntity.ok(response);
		
	}
	
	

}
