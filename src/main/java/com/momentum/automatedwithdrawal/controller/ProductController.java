package com.momentum.automatedwithdrawal.controller;


import com.momentum.automatedwithdrawal.model.*;
import com.momentum.automatedwithdrawal.repository.ProductRepository;
import com.momentum.automatedwithdrawal.repository.InvestorRepository;
import com.momentum.automatedwithdrawal.repository.WithdrawalRepository;
import com.momentum.automatedwithdrawal.service.InvestorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    private  WithdrawalRepository withdrawalRepository;

    @Autowired
    InvestorsService investorsService;


    @Autowired
    public ProductController(ProductRepository ProductRepository) {
        this.productRepository = ProductRepository;
    }

    @PostMapping("/{id}/withdrawals")
    public ResponseEntity<?> createWithdrawal(@PathVariable Long id, @RequestBody Withdrawal withdrawal) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            // Check if withdrawal amount is greater than current balance
            if (withdrawal.getAmount() > product.getBalance()) {
                return ResponseEntity.badRequest().body("Withdrawal amount exceeds the current balance.");
            }

            // Check if withdrawal amount is more than 90% of the current balance
            double maxWithdrawalAmount = 0.9 * product.getBalance();
            if (withdrawal.getAmount() > maxWithdrawalAmount) {
                return ResponseEntity.badRequest().body("Withdrawal amount cannot exceed 90% of the current balance.");
            }

            // Check if product is RETIREMENT and investor's age is greater than 65
            if (product.getType().equals("RETIREMENT")) {
                int investorAge = investorsService.calculateInvestorsAge();
                if (investorAge <= 65) {
                    return ResponseEntity.badRequest().body("Investor must be older than 65 to make a withdrawal for a retirement product.");
                }
            }

            // Perform the withdrawal and update the product balance
            product.setBalance(product.getBalance() - withdrawal.getAmount());
            withdrawalRepository.save(withdrawal);
            return ResponseEntity.ok(withdrawal);
        }
        return ResponseEntity.notFound().build();
    }
}

