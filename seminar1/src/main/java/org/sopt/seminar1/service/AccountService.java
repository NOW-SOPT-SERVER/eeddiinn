package org.sopt.seminar1.service;

import org.sopt.seminar1.domain.Account;

import java.util.List;

// 예금 계좌 서비스를 정의한 인터페이스
public interface AccountService {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    void transfer(Account fromAccount, String toAccountNumber, double amount);
    List<String> getTransferableAccounts();
}
