package com.workintech.fruitvegetable.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fruit", schema = "workintech")
public class Fruit extends Plant {
    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    private FruitType type;
}
