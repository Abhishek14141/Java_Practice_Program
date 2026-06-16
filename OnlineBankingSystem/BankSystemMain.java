package OnlineBankingSystem;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();
        int choice;

        do {
            System.out.println("\n===============================");
            System.out.println("      ONLINE BANK SYSTEM       ");
            System.out.println("===============================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Transfer Money");
            System.out.println("5. View Account Details");
            System.out.println("6. Generate Monthly Statement");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {


                    case 1:
                        System.out.println("\n--- Select Account Type ---");
                        System.out.println("1. Saving Account");
                        System.out.println("2. Current Account");
                        System.out.println("3. Salary Account");
                        System.out.print("Enter type: ");
                        int type = sc.nextInt();

                        System.out.print("Enter Account Number: ");
                        long accNo = sc.nextLong();
                        sc.nextLine(); // clear buffer

                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double balance = sc.nextDouble();

                        if (type == 1)
                            service.createAccount(new SavingAccount(accNo, name, balance));
                        else if (type == 2)
                            service.createAccount(new CurrentAccount(accNo, name, balance));
                        else if (type == 3)
                            service.createAccount(new SalaryAccount((int) accNo, name, balance));
                        else
                            System.out.println("Invalid Account Type!");

                        System.out.println("Account Created Successfully");
                        break;


                    case 2:
                        System.out.println("\n--- Deposit Amount ---");
                        System.out.print("Enter Account Number: ");
                        long dAcc = sc.nextLong();

                        System.out.print("Enter Amount to Deposit: ");
                        double dAmt = sc.nextDouble();

                        service.deposite(dAcc, dAmt);
                        System.out.println("Amount Deposited Successfully");
                        break;


                    case 3:
                        System.out.println("\n--- Withdraw Amount ---");
                        System.out.print("Enter Account Number: ");
                        long wAcc = sc.nextLong();

                        System.out.print("Enter Amount to Withdraw: ");
                        double wAmt = sc.nextDouble();

                        boolean success = service.withdraw(wAcc, wAmt);
                        if (success)
                            System.out.println("Withdrawal Successful");


                    case 4:
                        System.out.println("\n--- Transfer Money ---");
                        System.out.print("Enter From Account Number: ");
                        long fromAcc = sc.nextLong();

                        System.out.print("Enter To Account Number: ");
                        long toAcc = sc.nextLong();

                        System.out.print("Enter Amount: ");
                        double tAmt = sc.nextDouble();

                        service.transfer(fromAcc, toAcc, tAmt);


                    case 5:
                        System.out.println("\n--- View Account Details ---");
                        System.out.print("Enter Account Number: ");
                        long vAcc = sc.nextLong();

                        service.viewAccount(vAcc);
                        break;


                    case 6:
                        System.out.println("\n--- Monthly Statement ---");
                        service.monthlyStatement();
                        break;


                    case 7:
                        System.out.println("\nThank you for using Online Bank System!");
                        break;

                    default:
                        System.out.println("Invalid Choice! Please try again.");
                }

            } catch (DormantAccountException e) {
                System.out.println("" + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 7);

        sc.close();
    }
}