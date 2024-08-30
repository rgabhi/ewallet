package Learning;

import Learning.models.User;
import Learning.services.AccountService;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please choose option:");
            System.out.println("1. Create Account");
            System.out.println("2. make Transaction");
            System.out.println("3. get Account Statement");
            System.out.println("4. get Overview");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter name email phone amount:");
                    String name = scanner.next();
                    String email = scanner.next();
                    String phone = scanner.next();
                    double balance = scanner.nextDouble();
                    accountService.createAccount(new User(name, email, phone), balance);
                    break;
                case 2:
                    System.out.println("Enter SenderAccountNumber ReceiverAccountNumber Amount to make transaction:");
                    Long senderAccountNumber = scanner.nextLong();
                    Long receiverAccountNumber = scanner.nextLong();
                    double amount = scanner.nextDouble();;
                    accountService.makeTransaction(senderAccountNumber, receiverAccountNumber, amount);
                    break;
                case 3:
                    System.out.println("Enter Account number:");
                    Long accountNumber = scanner.nextLong();
                    accountService.getAccountStatement(accountNumber);
                    break;
                case 4:
                   accountService.getOverview();
                   break;
               case 5:
                   return;
            }
        }


    }


}
