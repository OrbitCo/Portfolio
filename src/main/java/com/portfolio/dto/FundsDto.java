package com.portfolio.dto;

public class FundsDto {
	private double equityFund;
	private double bondFund;
	private double cashFund;

	FundsDto() {
	}

	

	public FundsDto(double equityFund, double bondFund, double cashFund) {
		this.equityFund = equityFund;
		this.bondFund = bondFund;
		this.cashFund = cashFund;
	}



	public double getEquityFund() {
		return equityFund;
	}

	public void setEquityFund(double equityFund) {
		this.equityFund = equityFund;
	}

	public double getBondFund() {
		return bondFund;
	}

	public void setBondFund(double bondFund) {
		this.bondFund = bondFund;
	}

	public double getCashFund() {
		return cashFund;
	}

	public void setCashFund(double cashFund) {
		this.cashFund = cashFund;
	}

}
