package Entities;

public class Company extends Tax_payer {
    private Integer numberOfEmployees;

    public Company(String name, Double anual, Integer numberOfEmployees) {
        super(name, anual);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        if (numberOfEmployees != null && numberOfEmployees > 10) {
            return getAnual() * 0.14;
        } else {
            return getAnual() * 0.16;
        }
    }
}
