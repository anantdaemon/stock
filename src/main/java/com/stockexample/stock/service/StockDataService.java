/**
 * 
 */
package com.stockexample.stock.service;

import java.io.IOException;

import com.stockexample.stock.dto.FilePathRequest;

/**
 * 
 */
public interface StockDataService {

	void uploadCanadaData(FilePathRequest filePath) throws IOException;


}
