package com.stockexample.stock.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockexample.stock.dto.DateData;
import com.stockexample.stock.entity.CanEntity;
import com.stockexample.stock.repository.CanandaRepository;
import com.stockexample.stock.service.StockDataService;

@Service
public class StockDataServiceImpl implements StockDataService {

	Logger LOGER = LoggerFactory.getLogger(StockDataServiceImpl.class);

	@Autowired
	private CanandaRepository stockRepository;

	@Override
	public void uploadCanadaData(String csvFilePath) throws IOException {
		System.out.println("Inside service method");
		BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

		List<CanEntity> lsData = new ArrayList<>();
		DateData extractedDate = new DateData();
		extractedDate.setLoadDate(extractDateFromFilePath(csvFilePath));
		System.out.println("extractedDate : " + extractedDate);
		extractedDate = dateTimeExtractor(extractedDate);

		for (CSVRecord record : records) {
			System.out.println(record.toString());
			CanEntity canStk = new CanEntity();
			canStk.setDate(extractedDate.getLoadDate());
			canStk.setDayOfWeek(extractedDate.getDayOfWeek());
			canStk.setWeekOfMonth(extractedDate.getWeekOfMonth());
			canStk.setWeekOfYear(extractedDate.getWeekOfYear());
			canStk.setWatchList(null);
			canStk.setSymbol(record.get("Symbol"));
			canStk.setDescription(record.get("Description"));
			canStk.setVolume(Long.parseLong(record.get("Volume")));
			canStk.setpChange(Double.parseDouble(record.get("% Change")));
			canStk.setmCap(record.get("Market Cap."));
			//canStk.setShares(record.get("Shares"));
			canStk.setBeta(Double.parseDouble(record.get("Beta")));
			canStk.setMark(Double.parseDouble(record.get("Mark")));
			canStk.setLast(Double.parseDouble(record.get("Last")));
			canStk.setOpenInt(Long.parseLong(record.get("Open Int")));
			canStk.setSpread(Double.parseDouble(record.get("Spread")));
			canStk.setNetChange(Double.parseDouble(record.get("Net Change")));
			canStk.setBidSize(Long.parseLong(record.get("Bid Size")));
			canStk.setSize(Long.parseLong(record.get("Size")));
			canStk.setAskSize(Long.parseLong(record.get("Ask Size")));
			canStk.setLastSize(Long.parseLong(record.get("Last Size")));
			canStk.setInstrument(record.get("Instrument"));
			canStk.setOpenPrice(Double.parseDouble(record.get("Open")));
			canStk.setFiftyTwotWeekLow(Double.parseDouble(record.get("52 week Low")));
			canStk.setLow(Double.parseDouble(record.get("Low")));
			canStk.setBid(Double.parseDouble(record.get("Bid")));
			canStk.setAsk(Double.parseDouble(record.get("Ask")));
			canStk.setHigh(Double.parseDouble(record.get("High")));
			canStk.setPrevClose(Double.parseDouble(record.get("Prev Close")));
			canStk.setFiftyTwotWeekHigh(Double.parseDouble(record.get("52 week High")));
			canStk.setCusip(Double.parseDouble(record.get("CUSIP")));
			canStk.setMaintenaceMargin(Double.parseDouble(record.get("Maintenance Margin")));
			canStk.setDaysToExpire(Integer.parseInt(record.get("Days To Expiration")));
			canStk.setDelta(Double.parseDouble(record.get("Delta")));
			canStk.setExpirationDate(record.get("Expiration Date"));
			canStk.setFirstNoticeDate(record.get("First Notice Date"));
			canStk.setImpVolume(Double.parseDouble(record.get("Impl Vol")));
			canStk.setGamma(Double.parseDouble(record.get("Gamma")));
			canStk.setTradingHalt(record.get("Trading Halt"));
			canStk.setLastTradeDate(record.get("Last Trade Date"));
			canStk.setLimitDown(Double.parseDouble(record.get("Limit Down")));
			canStk.setLimitUp(Double.parseDouble(record.get("Limit Up")));
			canStk.setRho(Double.parseDouble(record.get("Rho")));
			canStk.setTheoPrice(Double.parseDouble(record.get("Theo Price")));
			canStk.setStrike(Double.parseDouble(record.get("Strike")));
			canStk.setTheta(Double.parseDouble(record.get("Theta")));
			canStk.setTickValue(Double.parseDouble(record.get("Tick Value")));
			canStk.setVega(Double.parseDouble(record.get("Vega")));
			
			lsData.add(canStk);
		}

		stockRepository.saveAll(lsData); // Batch save to DB
	}

	/**
	 * Method to extract load date from file path.
	 * 
	 * @param filePath
	 * @return
	 */
	public static String extractDateFromFilePath(String filePath) {
		// Regular expression for date format (yyyy-MM-dd)
		Pattern datePattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2})");
		Matcher matcher = datePattern.matcher(filePath);

		// If a match is found, return the date
		if (matcher.find()) {
			return matcher.group(1); // The first captured group (the date)
		}
		return null; // Return null if no date is found
	}

	/**
	 * Method to calculate day of the week, week of the month, week of the year.
	 * 
	 * @param extractedDate
	 * @return
	 */
	public DateData dateTimeExtractor(DateData extractedDate) {

		// Parse the string into a LocalDate object
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(extractedDate.getLoadDate(), formatter);

		// Extract day of the week
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		extractedDate.setDayOfWeek(dayOfWeek.getValue());

		// Extract week of the month
		int weekOfMonth = date.get(WeekFields.of(Locale.getDefault()).weekOfMonth());
		extractedDate.setWeekOfMonth(weekOfMonth);

		// Extract week of the year
		int weekOfYear = date.get(WeekFields.of(Locale.getDefault()).weekOfYear());
		extractedDate.setWeekOfYear(weekOfYear);

		return extractedDate;
	}

}
