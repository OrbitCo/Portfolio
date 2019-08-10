package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.PortfolioRequestDto;
import com.portfolio.dto.PortfolioResponseDto;
import com.portfolio.service.PlanService;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {
	
	@Autowired
	private PlanService planService;
	
	@PostMapping(value="/submitPortfolio")
	public PortfolioResponseDto submitPortfolio(@RequestBody PortfolioRequestDto portfolioRequestDto) {
		return this.planService.calculateAssetAndFunds(portfolioRequestDto);
		
	}

}
