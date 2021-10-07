package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

// Solução ruim do problema, contendo todas as operações lógicas dentro do programa principal

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
			
			//Cria data com horário atual
			Date now = new Date();
			//Se check-in ou check-out for anterior à data atual: 
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
		// Repete verificação feita anteriormente 
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
			reservation.updateDates(checkIn, checkOut);
			
			System.out.println("Reservation: " + reservation);
			}
		}
	}

}
