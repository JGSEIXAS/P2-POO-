package Entities;

import Exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation{
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        if (!checkIn.isBefore(checkOut)) {
            throw new DomainException("Data de Check-In precisa ser antes do Check-Out");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Integer duration(){
        return (int) ChronoUnit.DAYS.between(this.checkIn,this.checkOut);
    }

    public void UpdateDate(LocalDate checkIn, LocalDate checkOut){
    LocalDate today = LocalDate.now();

    if (!checkOut.isAfter(checkIn)) {
        throw new DomainException("Check-out deve ser depois do Check-in");
    }
    if (checkIn == null || checkOut == null) {
        throw new DomainException("Check-in e check-out precisam ser dados");
    }
    
    if (!checkIn.isAfter(today) || !checkOut.isAfter(today)) {
        throw new DomainException("A data precisa ser depois de hoje");
    }


    this.checkIn = checkIn;
    this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return " Room " + roomNumber + ", check-in: " + dtf.format(checkIn) + ", check-out: " + dtf.format(checkOut) + ", " + duration() + " nights"; }
}