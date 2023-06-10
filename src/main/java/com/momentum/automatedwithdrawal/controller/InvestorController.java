package com.momentum.automatedwithdrawal.controller;

import com.momentum.automatedwithdrawal.repository.InvestorRepository;
import com.momentum.automatedwithdrawal.model.Investor;
import com.momentum.automatedwithdrawal.service.InvestorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investors")
public class InvestorController {
    private final InvestorRepository investorRepository;
    @Autowired
    InvestorsService investorsService;

    @Autowired
    public InvestorController(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @GetMapping("/{id}")
    public Investor getInvestor(@PathVariable int id) {
          return investorsService.getInvestorById(id);
    }
}

