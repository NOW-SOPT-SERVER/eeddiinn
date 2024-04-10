package org.sopt.seminar1;

import org.sopt.seminar1.controller.AccountController;
import org.sopt.seminar1.domain.Account;
import org.sopt.seminar1.service.AccountServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AccountServiceImpl accountService = new AccountServiceImpl();
        Account account = new Account(Account.generateAccountNumber(), 0);
        accountService.addAccount(account);

        AccountController controller = new AccountController(accountService, account);

        System.out.println("새 계좌번호를 만드는 중입니다 !");
        try {
            Thread.sleep(4000); // 2초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 랜덤으로 만들어진 계좌번호 출력
        System.out.println("내 계좌번호: " + account.getAccountNumber());

        Scanner scanner = new Scanner(System.in);

        System.out.print("비밀번호를 생성하세요: ");
        int password = scanner.nextInt();

        while (true) {
            System.out.print("비밀번호를 입력하세요: ");
            int inputPassword = scanner.nextInt();
            if (inputPassword == password) {
                System.out.println("비밀번호가 일치합니다. 예금 서비스를 시작합니다 !");
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
            }
        }

        while (true) {
            System.out.println("-------예금 서비스-------");
            System.out.println("1. 입금");
            System.out.println("2. 출금");
            System.out.println("3. 계좌 이체");
            System.out.println("4. 종료");
            System.out.println("-------------------------");
            System.out.println("사용할 서비스를 선택하세요: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    controller.deposit();
                    break;
                case 2:
                    controller.withdraw();
                    break;
                case 3:
                    controller.transfer();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 숫자를 입력하세요.");
            }
        }
    }
}



