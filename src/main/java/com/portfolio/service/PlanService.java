package com.portfolio.service;

import java.util.List;

import com.portfolio.dto.PortfolioRequestDto;
import com.portfolio.dto.PortfolioResponseDto;
import com.portfolio.model.Plan;

public interface PlanService {
	
	Plan save(Plan plan);

	List<Plan> savePlans(List<Plan> plans);

	PortfolioResponseDto calculateAssetAndFunds(PortfolioRequestDto portfolioRequestDto);
}
