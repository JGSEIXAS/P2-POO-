package Entities;

public abstract class Tax_payer {
    private String name;
    private Double anual;

    public Tax_payer(String name, Double anual){
        this.name = name;
        this.anual = anual;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getAnual(){
        return anual;
    }

    public void setAnual(Double anual){
        this.anual = anual;
    }

    public abstract Double tax();
}
