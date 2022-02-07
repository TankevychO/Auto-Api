package com.autoapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "models")
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Manufacturer manufacturer;
}
