package com.portfolio.dto;

public class PortfolioResponseDto {

	private String lastName;
	private String firstName;
	private String portfolioName;
	private FundsDto funds;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public FundsDto getFunds() {
		return funds;
	}

	public void setFunds(FundsDto funds) {
		this.funds = funds;
	}

}
