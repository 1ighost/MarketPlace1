package com.andi.marketplace.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private double wallet;

    @Setter(AccessLevel.NONE)
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> bucket;

    @Override
    public String toString() {
        return "Name: " + this.firstName +
                "; \nLast name: " + this.lastName +
                "\n " + this.bucket.toString();
    }
}
