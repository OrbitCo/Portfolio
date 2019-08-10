package com.portfolio.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dto.FundsDto;
import com.portfolio.dto.PortfolioRequestDto;
import com.portfolio.dto.PortfolioResponseDto;
import com.portfolio.exception.PlanNotFoundException;
import com.portfolio.model.Plan;
import com.portfolio.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);
	
	@Autowired
	private PlanRepository planRepository;

	@Override
	public Plan save(Plan plan) {
		return planRepository.save(plan);
	}

	@Override
	public List<Plan> savePlans(List<Plan> plans) {
		return planRepository.saveAll(plans);
	}

	@Override
	public PortfolioResponseDto calculateAssetAndFunds(PortfolioRequestDto portfolioRequestDto) {
		logger.info("inside calculateAssetAndFunds method");
		PortfolioResponseDto portfolioResponseDto = new PortfolioResponseDto();
		portfolioResponseDto.setFirstName(portfolioRequestDto.getFirstName());
		portfolioResponseDto.setLastName(portfolioRequestDto.getLastName());
		String portfolioName = getPortfoliioName(portfolioRequestDto.getDob());
		portfolioResponseDto.setPortfolioName(portfolioName);
		FundsDto fundsDto = getPortfolioFunds(portfolioName, portfolioRequestDto.getFundAmt());
		portfolioResponseDto.setFunds(fundsDto);
		return portfolioResponseDto;
	}

	private FundsDto getPortfolioFunds(String portfolioName, double fundAmt) {
		logger.info("calculating funds by given funds amount");
		double equityFunds = 0;
		double bondFunds = 0;
		double cashFunds = 0;
		FundsDto fundsDto = null;
		Plan plan = planRepository.findByPlanType(portfolioName);
		if(plan!=null) {
			double equityFundPercentage = plan.getEquityFundPercentage();
			double bondFundPercentage = plan.getBondFundPercentage();
			double cashFundPercentage = plan.getCashFundPercentage();
			equityFunds = (fundAmt * equityFundPercentage) / 100;
			bondFunds = (fundAmt * bondFundPercentage) / 100;
			cashFunds = (fundAmt * cashFundPercentage) / 100;
			fundsDto = new FundsDto(equityFunds, bondFunds, cashFunds);
		}else {
			throw new PlanNotFoundException("Plantype by given entered date is not found");
		}
		return fundsDto;
	}

	private String getPortfoliioName(LocalDate dob) {
		logger.info("getting model name by age");
		int calculateAge = calculateAge(dob, LocalDate.now());
		Plan plan = planRepository.findByMaxAge(calculateAge);
		if(plan==null) {
			throw new PlanNotFoundException("Plantype by given entered date is not found");
		}
		return plan.getPlanType();
	}

	public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		logger.info("calculating age by given date");

		return Period.between(birthDate, currentDate).getYears();
	}

}
