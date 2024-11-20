package rca.ac.home.work.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String state;
    private String city;

    public Address() {
    }

    public Address(String state, String city) {
        this.state = state;
        this.city = city;
    }
}
