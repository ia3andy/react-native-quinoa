package org.acme.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "beer_types")
public class Type extends PanacheEntity {
    public String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "type")
    @JsonManagedReference
    public List<Beer> beers;
}
