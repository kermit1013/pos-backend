package com.pointofsales.backend.controller;

import com.pointofsales.backend.model.Stock;
import com.pointofsales.backend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/stocks")
    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    @PostMapping("/stocks")
    public Stock addStocks(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }
}
