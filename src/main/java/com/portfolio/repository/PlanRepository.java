package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portfolio.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
	
	Plan findByPlanType(String planType);
	
	@Query("Select p from Plan p where :age between p.minAge and p.maxAge")
	Plan findByMaxAge(int age);
	
	

}
