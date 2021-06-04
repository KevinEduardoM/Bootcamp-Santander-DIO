package com.project.Bootcamp.controller;

import com.project.Bootcamp.model.dto.StockDTO;
import com.project.Bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO stock){
        return ResponseEntity.ok(service.save(stock));
    }

    @PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO stock){
        return ResponseEntity.ok(service.Update(stock));
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<StockDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return  ResponseEntity.ok(service.delete(id));
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findbyId(@PathVariable Long id){
        return  ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value ="/today",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findToday(){
        return ResponseEntity.ok(service.findByToday());
    }


}
