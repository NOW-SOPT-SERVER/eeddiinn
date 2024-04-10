package org.sopt.seminar1.service;
import org.sopt.seminar1.domain.Account;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

// 예금 계좌 서비스의 구현체 클래스
public class AccountServiceImpl implements AccountService {

    private final List<Account> accounts = new ArrayList<>();

    // 생성자에서 계좌 목록 생성
    public AccountServiceImpl() {
        addAccount(new Account(Account.generateAccountNumber(), 0));
        addAccount(new Account(Account.generateAccountNumber(), 0));
        addAccount(new Account(Account.generateAccountNumber(), 0));
    }

    // 입금 메서드
    @Override
    public void deposit(Account account, double amount) {
        // 입금액을 계좌 잔액에 추가하고 현재 잔액 출력
        account.setBalance(account.getBalance() + amount);
        System.out.println("현재 잔액: " + account.getBalance());
    }

    // 출금 메서드
    @Override
    public void withdraw(Account account, double amount) {
        // 출금 가능 여부 확인 후 출금 또는 부족한 경우 메시지 출력
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("현재 잔액: " + account.getBalance());
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    // 계좌 이체 메서드
    @Override
    public void transfer(Account fromAccount, String toAccountNumber, double amount) {
        Account toAccount = accounts.stream()
                                .filter(acc -> acc.getAccountNumber().equals(toAccountNumber))
                                .findFirst()
                                .orElse(null);

        if (toAccount != null) {
            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                System.out.println("이체 완료: " + amount + "원을 " + toAccountNumber + " 계좌로 이체했습니다.");
                System.out.println("현재 잔액: " + fromAccount.getBalance());
            } else {
                System.out.println("잔액이 부족합니다.");
            }
        } else {
            System.out.println("상대방 계좌를 찾을 수 없습니다.");
        }
    }

    // 이체 가능한 계좌 목록을 반환하는 메서드
    @Override
    public List<String> getTransferableAccounts() {
        List<String> transferableAccounts = new ArrayList<>();
        Random random = new Random();
        Set<String> chosenAccountNumbers = new HashSet<>();

        // 랜덤으로 3개의 계좌번호를 가져옴
        while (chosenAccountNumbers.size() < 3) {
            int randomIndex = random.nextInt(accounts.size());
            chosenAccountNumbers.add(accounts.get(randomIndex).getAccountNumber());
        }

        transferableAccounts.addAll(chosenAccountNumbers);
        return transferableAccounts;
    }

    // 계좌 추가 메서드
    public void addAccount(Account account) {
        accounts.add(account);
    }
}




