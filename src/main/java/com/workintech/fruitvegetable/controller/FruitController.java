package com.workintech.fruitvegetable.controller;

import com.workintech.fruitvegetable.entitiy.Fruit;
import com.workintech.fruitvegetable.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
@Validated
public class FruitController {
    private FruitService fruitService;

    @Autowired

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> findAll(int id) {
        return fruitService.findAll();
    }

    @GetMapping("{id}")
    public Fruit find(@PathVariable int id) {
        Fruit fruit = fruitService.find(id);
        if (fruit == null) {
            //TODO throw exception
        }
        return fruit;
    }

    @GetMapping("/desc")
    public List<Fruit> findAllByPriceDesc(int id) {
        return fruitService.findAllByPriceDesc();
    }

    @GetMapping("/asc")
    public List<Fruit> findAllByPriceAsc(int id) {
        return fruitService.findAllByPriceAsc();
    }

    @PostMapping("/")
    public Fruit save(@RequestBody Fruit fruit) {
        // This method works on both update and save. If id in the given request object not exists in db, that causes to save a new object to db.
        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List<Fruit> searchByName(@PathVariable String name) {
        // This method works on both update and save. If id in the given request object not exists in db, that causes to save a new object to db.
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit save(@PathVariable int id) {
        Fruit fruit = find(id);
        fruitService.delete(fruit);
        return fruit;
    }
}
