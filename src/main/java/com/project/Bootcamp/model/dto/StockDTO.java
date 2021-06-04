package com.project.Bootcamp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StockDTO {

    private long id;

    @NotNull
    private String name;

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 6,fraction = 2)
    private Double price;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull
    @Digits(integer = 3,fraction = 2)
    private Double variation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
