package org.acme.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "beers")
public class Beer extends PanacheEntity {
    public String name;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    public Type type;

}
