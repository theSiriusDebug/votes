package com.example.votes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "button")
    private String button;

    public Vote() {}

    public Vote(String button) {
        this.button = button;
    }

    // геттеры и сеттеры

}
