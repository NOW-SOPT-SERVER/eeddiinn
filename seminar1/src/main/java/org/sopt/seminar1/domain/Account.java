package org.sopt.seminar1.domain;

import lombok.AllArgsConstructor;

import java.util.Random;

// 예금 계좌 정보를 저장하는 클래스
@AllArgsConstructor
public class Account {

    private String accountNumber;
    private double balance;

    // 랜덤으로 계좌 번호를 생성함
    public static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


