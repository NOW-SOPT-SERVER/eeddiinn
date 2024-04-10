package org.sopt.seminar1.controller;

import org.sopt.seminar1.domain.Account;
import org.sopt.seminar1.service.AccountService;

import java.util.List;
import java.util.Scanner;

// 예금 계좌를 제어하는 컨트롤러 클래스
public class AccountController {
    private final Account account;
    private final AccountService accountService;

    public AccountController(AccountService accountService, Account account) {
        this.accountService = accountService;
        this.account = account;
    }

    // 입금 메서드
    public void deposit() {
        System.out.println("현재 잔액: " + account.getBalance());
        Scanner scanner = new Scanner(System.in);
        System.out.print("입금할 금액: ");
        double amount = scanner.nextDouble();
        accountService.deposit(account, amount);
    }

    // 출금 메서드
    public void withdraw() {
        System.out.println("현재 잔액: " + account.getBalance());
        Scanner scanner = new Scanner(System.in);
        System.out.print("출금할 금액: ");
        double amount = scanner.nextDouble();
        accountService.withdraw(account, amount);
    }

    // 이체 메서드
    public void transfer() {
        // 이체 가능한 계좌 목록 가져옴
        List<String> transferableAccounts = accountService.getTransferableAccounts(); 
        System.out.println("이체 가능한 계좌 목록:");
        for (int i = 0; i < transferableAccounts.size(); i++) {
            System.out.println("-" + transferableAccounts.get(i));
        }

        // 이체할 대상 계좌와 금액 입력 받음
        Scanner scanner = new Scanner(System.in);
        System.out.print("상대방 계좌번호를 입력하세요: ");
        String toAccount = scanner.nextLine();
        System.out.print("이체할 금액: ");
        double amount = scanner.nextDouble();

        // 이체 가능한 계좌인지 확인하는 로직으로 이체 가능한 계좌가 맞다면 이체 가능, 이체 가능한 계좌가 아니면 이체 불가
        if (transferableAccounts.contains(toAccount)) {
            accountService.transfer(account, toAccount, amount);
        } else {
            System.out.println("상대방 계좌를 찾을 수 없습니다.");
        }
    }
}
