package _06_DefiningClasses.Lab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split("\\s+");

        String command = inputData[0];

        Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!command.equals("End")) {

            String result = "";

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accounts.put(bankAccount.getId(), bankAccount);
                    result = String.format("Account ID%d created",bankAccount.getId());
                    break;
                case"Deposit":
                    int accountID = Integer.parseInt(inputData[1]);
                    double money = Double.parseDouble(inputData[2]);
                    if(accounts.containsKey(accountID)){
                        BankAccount bankAccountFromMap = accounts.get(accountID);
                        bankAccountFromMap.deposit(money);
                        result = String.format("Deposited %.0f to ID%d", money, accountID);
                    }else{
                        result = "Account does not exist";
                    }
                    break;
                case"SetInterest":
                    double setInterestRate = Double.parseDouble(inputData[1]);
                    BankAccount.setInterestRate(setInterestRate);
                    break;
                case "GetInterest":
                    int idAccount = Integer.parseInt(inputData[1]);
                    int year = Integer.parseInt(inputData[2]);
                    if(accounts.containsKey(idAccount)){
                        BankAccount bankAccountFromMap = accounts.get(idAccount);
                       double getInterest = bankAccountFromMap.getInterestRate(year);
                        result = String.format("%.2f", getInterest);
                    }else{
                        result = "Account does not exist";
                    }
                    break;
            }
            if(!result.isEmpty()) {
                System.out.println(result);
            }
            inputData = scanner.nextLine().split("\\s+");
            command = inputData[0];
        }
    }
}
