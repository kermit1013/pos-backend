package com.pointofsales.backend.controller;

import com.pointofsales.backend.model.Stock;
import com.pointofsales.backend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @DeleteMapping("/stocks/{stockId}")
    public void deleteStocks(@PathVariable long stockId) {
        stockRepository.deleteById(stockId);
    }

    @PostMapping("/stocks/import")
    public void importStocks(@RequestParam MultipartFile file) throws IOException {
        System.out.println(file.getInputStream());
    }
}
