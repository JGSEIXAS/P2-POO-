package Application;

import Entities.Company;
import Entities.Individual;
import Entities.Tax_payer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Tax_payer> list = new ArrayList<>();

        System.out.print("Enter the number of taxpayers: ");
        int numberOfTaxpayers = input.nextInt();

        for (int i = 1; i <= numberOfTaxpayers; i++) {
            System.out.println("\nTaxpayer #" + i + " data:");
            System.out.print("Individual or Company (i/c)? ");
            char ch = input.next().trim().toLowerCase().charAt(0);

            // consome a quebra de linha pendente antes de ler linhas completas
            input.nextLine();

            if (ch == 'i') {
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Annual income: ");
                Double anualIncome = input.nextDouble();

                System.out.print("Health expenditures: ");
                Double healthExpenditures = input.nextDouble();

                list.add(new Individual(name, anualIncome, healthExpenditures));
            } else if (ch == 'c') {
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Annual income: ");
                Double anualIncome = input.nextDouble();

                System.out.print("Number of employees: ");
                Integer numberOfEmployees = input.nextInt();

                list.add(new Company(name, anualIncome, numberOfEmployees));
            } else {
                System.out.println("Option not recognized, skipping this taxpayer.");
            }
        }

        System.out.println("\nTAXES PAID:");
        double totalTaxes = 0.0;
        for (Tax_payer obj : list) {
            double t = obj.tax();
            System.out.printf("%s: $ %.2f%n", obj.getName(), t);
            totalTaxes += t;
        }

        System.out.printf("%nTOTAL TAXES: $ %.2f%n", totalTaxes);
        input.close();
    }
}
