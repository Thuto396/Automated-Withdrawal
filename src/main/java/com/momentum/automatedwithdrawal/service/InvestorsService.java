package com.momentum.automatedwithdrawal.service;

import com.momentum.automatedwithdrawal.model.Investor;
import com.momentum.automatedwithdrawal.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvestorsService {
    public Investor investors;


    static List<Investor> investorList;
    static {
        investorList = new ArrayList<Investor>();
        investorList.add(new Investor(1,"Thuto", "Malesa", "123 Main St", "0810896497", "malesathuto@gmail.com", LocalDate.parse("2002-01-13")));
    }
    public Investor getInvestorById(int id){
        for (Investor investor:investorList ){
            if (investor.getId() == id){
                investors = investor;
                break;
            }

        }
        return investors;

    }
    public int calculateInvestorsAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = investors.getDate_of_birth();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }


}