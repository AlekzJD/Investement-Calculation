package practicascloud.baselineservice.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import practicascloud.baselineservice.model.DetailResponse;
import practicascloud.baselineservice.model.ServiceRequest;
import practicascloud.baselineservice.model.ServiceResponse;

/**
 * @author Daniel Alejandro Jiménez Cervantes 
 *
 */
@Service
public class ServiceCalculationImpl implements IServiceCalculation{

	@Override
	public ServiceResponse calculation(ServiceRequest serviceRequest) {
		
		ArrayList<DetailResponse> detailResponseList = new ArrayList<DetailResponse>();
		ServiceResponse serviceResponse = new ServiceResponse();
		DetailResponse detailResponse;
		
		int investmentYears = serviceRequest.getInvestmentYears();
		double initialInvestment = serviceRequest.getInitialInvestment();
		double annualContribution = serviceRequest.getAnnualContribution();
		double investmentReturn = serviceRequest.getInvestmentReturn();
		double annualIncrease = serviceRequest.getAnnualIncrease();
		double totalYield;
		double consequentContribution;
		
		for(int i = 1; i <= investmentYears; i ++) {//rendimiento por cada año
			
			detailResponse = new DetailResponse();
			
			detailResponse.setYear(i);//año
			totalYield = i <= 1 ? (initialInvestment + annualContribution) * (investmentReturn / 100) : detailResponseList.get(i-2).getFinalAmountPerYear();
			detailResponse.setInitialInvestment(i <= 1 ? initialInvestment : totalYield);//saldo inicial
			consequentContribution = annualContribution != 0 && i <= 1 ? annualContribution : detailResponseList.get(i-2).getAnnualContribution() + (annualIncrease * detailResponseList.get(i-2).getAnnualContribution() / 100);//aportacion con porcentaje de incremento si se reinvierte
			detailResponse.setAnnualContribution(consequentContribution);//aportacion
			
			detailResponse.setYiel(i <= 1 ? totalYield : (detailResponseList.get(i-2).getFinalAmountPerYear() + consequentContribution) * (investmentReturn / 100));//renidimiento
			
			detailResponse.setFinalAmountPerYear(i <= 1 ? initialInvestment + annualContribution + totalYield : detailResponse.getInitialInvestment() + detailResponse.getAnnualContribution() + detailResponse.getYiel());//saldo final
			
			detailResponseList.add(detailResponse);
		
		}
		
		serviceResponse = getFinalValues(detailResponseList);
		
		return serviceResponse;
	}

	private ServiceResponse getFinalValues(ArrayList<DetailResponse> detailResponseList) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		
		double finalAmount = 0;
		double investmentProfit = 0;
		
		for(DetailResponse detail: detailResponseList) {
			
			finalAmount =+ detail.getFinalAmountPerYear();
			investmentProfit = investmentProfit + detail.getYiel();
			
		}
		
		serviceResponse.setFinalAmount(finalAmount);
		serviceResponse.setInvestmentProfit(investmentProfit);
		
		return serviceResponse;
	}

}
