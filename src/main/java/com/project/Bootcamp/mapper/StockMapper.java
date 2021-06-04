package com.project.Bootcamp.mapper;

import com.project.Bootcamp.model.Stock;
import com.project.Bootcamp.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public Stock toEntity(StockDTO stockDTO) {
        Stock stock =new Stock();

        stock.setId(stockDTO.getId());
        stock.setName(stockDTO.getName());
        stock.setPrice(stockDTO.getPrice());
        stock.setVariation(stockDTO.getVariation());
        stock.setDate(stockDTO.getData());

        return stock;
    }

    public StockDTO toDto(Stock stock) {
        StockDTO dto=new StockDTO();

        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        dto.setData(stock.getDate());

        return dto;
    }

    public List<StockDTO> toDto(List<Stock> listStock){
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
    }



}
