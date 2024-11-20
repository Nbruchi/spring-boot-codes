package rca.ac.home.work.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contact {
private String email;
private String phone;

    public Contact() {
    }

    public Contact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}
