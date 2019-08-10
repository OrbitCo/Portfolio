package com.portfolio.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PortfolioRequestDto {

	private String firstName;
	private String lastName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	private double fundAmt;

	public PortfolioRequestDto() {
	}

	public PortfolioRequestDto(PortfolioRequestDto portfolioDto) {
		this.lastName = portfolioDto.getLastName();
		this.firstName = portfolioDto.getFirstName();
		this.fundAmt = portfolioDto.getFundAmt();
	}

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

	public double getFundAmt() {
		return fundAmt;
	}

	public void setFundAmt(double fundAmt) {
		this.fundAmt = fundAmt;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
