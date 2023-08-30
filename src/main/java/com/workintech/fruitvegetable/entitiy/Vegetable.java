package com.workintech.fruitvegetable.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="vegetable", schema = "workintech")
public class Vegetable extends Plant{
    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;
}
