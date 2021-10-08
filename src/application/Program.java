				package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

// Solução ruim do problema, retornando uma String ao usuário

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in Date (dd/MM/yyyy):");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out Date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
// 	A data de Check-out não pode ser posterior à data de Check-in
		// ( se (não checkout antes de checkin)
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in Date (dd/MM/yyyy):");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//Lógica que atualiza as datas movida para a classe Reservation na operação updateDates		
			String error = reservation.updateDates(checkIn, checkOut);
						
			//Caso algum erro ocorra na entrada de dados, retornara a string apropriada da 
			//operação updateDates
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}else {
				System.out.println("Reservation: " + reservation);
			}
			
		}
	}
}
