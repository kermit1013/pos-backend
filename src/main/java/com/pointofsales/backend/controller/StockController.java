package com.pointofsales.backend.controller;

import com.pointofsales.backend.model.Stock;
import com.pointofsales.backend.repository.StockRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
        Workbook workbook = new XSSFWorkbook(file.getInputStream());

        List<Stock> stockList = new ArrayList<>();
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int rowNumbers = sheet.getLastRowNum() + 1;
            Row temp = sheet.getRow(0);
            if (temp == null) {
                continue;
            }
            for (int row = 1; row < rowNumbers; row++) {
                Stock stock = new Stock();
                Row r = sheet.getRow(row);
                stock.setName(r.getCell(0).toString());
                stock.setCategory(r.getCell(1).toString());
                stock.setCapacity(Float.parseFloat(r.getCell(2).toString()));
                stock.setUnit(r.getCell(3).toString());
                stock.setMaximum_quantity(Integer.valueOf(r.getCell(4).toString()));
                stockList.add(stock);
            }
        }
        stockRepository.saveAll(stockList);
    }
}
