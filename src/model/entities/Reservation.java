package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	public long duration() {
	//getTime retorna a data em millissegundos
	//A variável diff recebera o valor de checkOut - checkIn em millissegundos
		long diff = checkOut.getTime() - checkIn.getTime();
	//Converte o valor em Millissegundos de diff para dias	
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkIn, Date checkOut){
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public String toString() {
		return "Room: "
			+ roomNumber
			+ ", Check-In: "
			+ sdf.format(checkIn)
			+ ", Check-Out: "
			+ sdf.format(checkOut)
			+ ", Duration: "
			+ duration()
			+ " nights.";
	}
	
}
