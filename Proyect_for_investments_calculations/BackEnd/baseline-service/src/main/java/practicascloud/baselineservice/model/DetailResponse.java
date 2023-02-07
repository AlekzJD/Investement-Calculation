package practicascloud.baselineservice.model;

import java.io.Serializable;

/**
 * @author Daniel Alejandro Jiménez Cervantes 
 *
 */
public class DetailResponse implements Serializable {
	
	private static final long serialVersionUID = -5561290306134145135L;
	
	public int year;
	public double initialInvestment;
	public double annualContribution;
	public double yiel;
	public double finalAmountPerYear;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
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
	public double getYiel() {
		return yiel;
	}
	public void setYiel(double yiel) {
		this.yiel = yiel;
	}
	public double getFinalAmountPerYear() {
		return finalAmountPerYear;
	}
	public void setFinalAmountPerYear(double finalAmountPerYear) {
		this.finalAmountPerYear = finalAmountPerYear;
	}

}
