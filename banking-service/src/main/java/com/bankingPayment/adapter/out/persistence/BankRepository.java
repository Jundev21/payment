package com.bankingPayment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankEntity,Long> {
}
