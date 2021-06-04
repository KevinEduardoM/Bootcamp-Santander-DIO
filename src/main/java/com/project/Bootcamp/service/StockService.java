package com.project.Bootcamp.service;

import com.project.Bootcamp.exceptions.BussinesExceptions;
import com.project.Bootcamp.exceptions.NotFoundException;
import com.project.Bootcamp.mapper.StockMapper;
import com.project.Bootcamp.model.Stock;
import com.project.Bootcamp.model.dto.StockDTO;
import com.project.Bootcamp.repository.StockRepository;
import com.project.Bootcamp.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {


    @Autowired
    StockRepository repository;
    @Autowired
    StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO stockDTO){
        Optional<Stock> optitonalStock = repository.findByNameAndDate(stockDTO.getName(),stockDTO.getData());
         if(optitonalStock.isPresent()){
            throw new BussinesExceptions(MessageUtils.STOCK_ALREADY_EXISTS);
         }
        Stock stockM = mapper.toEntity(stockDTO);
        repository.save(stockM);
        return mapper.toDto(stockM);
    }

    @Transactional
    public StockDTO Update(StockDTO stockDTO) {
        Optional<Stock> optitonalStock = repository.findByStockUpdate(stockDTO.getName(),stockDTO.getData(),
                stockDTO.getId());
            if(optitonalStock.isPresent()){
                throw new BussinesExceptions(MessageUtils.STOCK_ALREADY_EXISTS);
            }
        Stock stockM = mapper.toEntity(stockDTO);
        repository.save(stockM);
        return mapper.toDto(stockM);
    }

    @Transactional()
    public List<StockDTO>  findAll(){
        List<Stock> list=repository.findAll();
        return mapper.toDto(list);
    }

    @Transactional()
    public StockDTO findById(Long idStock) {
      return repository.findById(idStock).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    public StockDTO delete(Long id) {
        StockDTO dto= this.findById(id);
       repository.deleteById(id);
       return dto;
    }

    @Transactional()
    public List<StockDTO> findByToday() {
        return repository.findByDte(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }
}
