package com.stockexample.stock.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockexample.stock.service.StockDataService;

@RestController
@RequestMapping("/stock/loader")
public class StockDataController {

	@Autowired
	private StockDataService stockService;

	String filePath = "C:\\Users\\Hp\\Downloads\\Anoop\\Input\\Canada1\\2024-12-12\\206ll.csv";

	@PostMapping("/uploadcanada")
	public String uploadCanadaData() {
		try {
			stockService.uploadCanadaData(filePath);
			return "Data uploaded successfully!";
		} catch (IOException e) {
			return "Error uploading data: " + e.getMessage();
		}
	}

}
