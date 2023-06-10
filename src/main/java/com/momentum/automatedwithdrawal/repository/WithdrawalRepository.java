package com.momentum.automatedwithdrawal.repository;

import com.momentum.automatedwithdrawal.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
}
//A repository interface that extends JpaRepository so that I am able to make use of the methods to perform CRUD operations
