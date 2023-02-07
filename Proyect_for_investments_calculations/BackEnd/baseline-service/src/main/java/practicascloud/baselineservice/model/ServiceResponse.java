package practicascloud.baselineservice.model;

import java.io.Serializable;

/**
 * @author Daniel Alejandro Jiménez Cervantes 
 *
 */
public class ServiceResponse implements Serializable {
	
	private static final long serialVersionUID = 3880208519262090890L;
	
	public double investmentProfit;
	public double finalAmount;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getInvestmentProfit() {
		return investmentProfit;
	}
	public void setInvestmentProfit(double investmentProfit) {
		this.investmentProfit = investmentProfit;
	}
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

}
