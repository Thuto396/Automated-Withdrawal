package com.momentum.automatedwithdrawal.repository;

import com.momentum.automatedwithdrawal.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
