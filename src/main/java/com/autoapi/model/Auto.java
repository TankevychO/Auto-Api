package com.autoapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "autos")
@NoArgsConstructor
@AllArgsConstructor
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    @Column(unique = true)
    private String vinCode;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Column(unique = true)
    private String number;
    @ManyToOne
    private Model model;
    private String manufacturer;
    private String ownerName;

    public enum Color {
        BLUE, WHITE, RED, BLACK, YELLOW, PURPLE;
    }
}
