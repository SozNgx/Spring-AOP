package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private static final Long serialVesionUID = 5517244812959569947L;
    private String id;
    private String name;
}
