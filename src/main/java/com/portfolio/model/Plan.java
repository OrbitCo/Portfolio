package com.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plan {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "plan_type")
	private String planType;

	@Column(name = "equity_percentage")
	private double equityFundPercentage;

	@Column(name = "bond_percentage")
	private double bondFundPercentage;

	@Column(name = "cash_percentage")
	private double cashFundPercentage;

	@Column(name = "min_age")
	private int minAge;

	@Column(name = "max_age")
	private int maxAge;

	Plan() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public double getEquityFundPercentage() {
		return equityFundPercentage;
	}

	public void setEquityFundPercentage(double equityFundPercentage) {
		this.equityFundPercentage = equityFundPercentage;
	}

	public double getBondFundPercentage() {
		return bondFundPercentage;
	}

	public void setBondFundPercentage(double bondFundPercentage) {
		this.bondFundPercentage = bondFundPercentage;
	}

	public double getCashFundPercentage() {
		return cashFundPercentage;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public void setCashFundPercentage(double cashFundPercentage) {
		this.cashFundPercentage = cashFundPercentage;
	}

}
