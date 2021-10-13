package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {

			System.out.print("Enter account number: ");
			int number = sc.nextInt();

			System.out.print("Enter account holder name: ");
			sc.next();
			String name = sc.nextLine();

			System.out.print("Account initial balance: ");
			double balance = sc.nextDouble();

			System.out.print("Set account's withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, name, balance, withdrawLimit);

			System.out.println();
			System.out.println();

			System.out.println("Enter withdraw value: ");
			double withdraw = sc.nextDouble();
			account.withdraw(withdraw);

			System.out.println(String.format("New Balance: R$ %.2f", account.getBalance()));
		} catch (InputMismatchException e) {
			System.out.println("Invalid data");
		} catch (DomainException e) {
			System.out.println("Error in withdraw: " + e.getMessage());
		} finally {
			sc.close();
		}

	}
}
