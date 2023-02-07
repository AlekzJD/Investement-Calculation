package practicascloud.baselineservice.service;

import practicascloud.baselineservice.model.ServiceRequest;
import practicascloud.baselineservice.model.ServiceResponse;

/**
 * @author Daniel Alejandro Jiménez Cervantes 
 *
 */
public interface IServiceCalculation {

	public ServiceResponse calculation(ServiceRequest serviceRequest);
	
}
