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

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out precisa ser depois de Check-In");
        }
        if (checkIn.isBefore(this.checkIn) || checkOut.isBefore(this.checkOut)) {
            throw new DomainException("Erro: Dia da reserva precisa ser a partir de amanhã");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return " Room " + roomNumber + ", check-in: " + dtf.format(checkIn) + ", check-out: " + dtf.format(checkOut) + ", " + duration() + " nights"; }
}