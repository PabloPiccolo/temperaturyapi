package com.example.temperaturyapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pomiary")
public class Pomiar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperatura;

    @Column(name = "data_pomiaru")
    private LocalDateTime dataPomiaru;

    public Long getId() {
        return id;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public LocalDateTime getDataPomiaru() {
        return dataPomiaru;
    }

    public void setDataPomiaru(LocalDateTime dataPomiaru) {
        this.dataPomiaru = dataPomiaru;
    }
}