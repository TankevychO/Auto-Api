package com.autoapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "manufacturers")
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Id
    private Long id;
    private String name;
}
