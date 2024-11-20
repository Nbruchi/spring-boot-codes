package rca.ac.home.work.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class Vehicle {
    @Id
    private String model;
    private String make;
    private LocalDate purchaseDate;

    @OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL)
    private Employee owner;

    public Vehicle(){};

    public Vehicle(String model, String make, LocalDate purchaseDate){
        this.model = model;
        this.make = make;
        this.purchaseDate = purchaseDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }
}
