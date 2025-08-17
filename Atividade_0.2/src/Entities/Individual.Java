package Entities;

public class Individual extends Tax_payer {
    private Double healthExpenditures;

    public Individual(String name, Double anual, Double healthExpenditures) {
        super(name, anual);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double base = (getAnual() < 20000.0) ? getAnual() * 0.15 : getAnual() * 0.25;
        double deduction = (healthExpenditures != null ? healthExpenditures : 0.0) * 0.5;
        double t = base - deduction;
        return t < 0 ? 0.0 : t;
    }
}
