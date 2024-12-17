package com.stockexample.stock.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockexample.stock.dto.FilePathRequest;
import com.stockexample.stock.service.StockDataService;

@RestController
@RequestMapping("/stock/loader")
public class StockDataController {

	@Autowired
	private StockDataService stockService;

	//String filePath1 = "C:\\Users\\Hp\\Downloads\\Anoop\\Input\\Canada1\\2024-12-12\\206ll.csv";

	@PostMapping("/uploadcanada")
	public ResponseEntity<String> uploadCanadaData(@RequestBody FilePathRequest requestPath) {

		try {
			System.out.println("!!! Inside Controller !!!");
			System.out.println("uploadCanadaData - Method");

				stockService.uploadCanadaData(requestPath);
			return new ResponseEntity<>("Data uploaded successfully!", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>("Error reading the file.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
