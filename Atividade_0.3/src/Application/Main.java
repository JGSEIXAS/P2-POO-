package Application;

import Entities.Reservation;
import Exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            System.out.print("Digite o numero da quarto: ");
            int roomNumber = input.nextInt();
            System.out.println("Check-in do quarto ");
            LocalDate checkIn = LocalDate.parse(input.next(), dtf);
            System.out.println("Check-out do quarto ");
            LocalDate checkOut = LocalDate.parse(input.next(),dtf);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Check-in do Reservation" + reservation);
        }
        catch (InputMismatchException message) {
            System.out.println("Numero de quarto precisa ser um inteiro");
        }
        catch (DateTimeParseException message){
            System.out.println("Data Invalida");
        }
        catch (DomainException message){
            System.out.println(message.getMessage());
        }
        catch (Exception message){
            System.out.println("Algo aconteceu" + message.getMessage());
        }
    }
    
}