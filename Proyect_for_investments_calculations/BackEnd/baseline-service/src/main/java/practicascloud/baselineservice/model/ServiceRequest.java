package practicascloud.baselineservice.model;

import java.io.Serializable;

/**
 * @author Daniel Alejandro Jiménez Cervantes 
 *
 */
public class ServiceRequest implements Serializable{

	private static final long serialVersionUID = -1030414346418094978L;

	public double initialInvestment;
	public double annualContribution;
	public double annualIncrease;
	public int investmentYears;
	public double investmentReturn;
	
	public double getInitialInvestment() {
		return initialInvestment;
	}
	public void setInitialInvestment(double initialInvestment) {
		this.initialInvestment = initialInvestment;
	}
	public double getAnnualContribution() {
		return annualContribution;
	}
	public void setAnnualContribution(double annualContribution) {
		this.annualContribution = annualContribution;
	}
	public double getAnnualIncrease() {
		return annualIncrease;
	}
	public void setAnnualIncrease(double annualIncrease) {
		this.annualIncrease = annualIncrease;
	}
	public int getInvestmentYears() {
		return investmentYears;
	}
	public void setInvestmentYears(int investmentYears) {
		this.investmentYears = investmentYears;
	}
	public double getInvestmentReturn() {
		return investmentReturn;
	}
	public void setInvestmentReturn(double investmentReturn) {
		this.investmentReturn = investmentReturn;
	}

}
