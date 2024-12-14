package com.stockexample.stock.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
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
import org.apache.commons.csv.CSVPrinter;
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

	String exportPath = "C:\\Users\\Hp\\Downloads\\Anoop\\Input\\Canada2\\2024-12-12\\206ll.csv";

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
		// Extract the file name from the full path
		String fileName = Paths.get(csvFilePath).getFileName().toString();

		for (CSVRecord record : records) {

			System.out.println(record.toString());
			CanEntity canStk = new CanEntity();
			canStk.setDate(extractedDate.getLoadDate());
			canStk.setDayOfWeek(extractedDate.getDayOfWeek());
			canStk.setWeekOfMonth(extractedDate.getWeekOfMonth());
			canStk.setWeekOfYear(extractedDate.getWeekOfYear());
			canStk.setWatchList(fileName);
			canStk.setSymbol(record.get("Symbol"));
			canStk.setDescription(record.get("Description"));
			canStk.setVolume(
					isNullOrEmpty(record.get("Volume")) ? null : Long.parseLong(record.get("Volume").replace(",", "")));
			canStk.setpChange(isNullOrEmpty(record.get("% Change")) ? null
					: Double.parseDouble(record.get("% Change").replace(",", "")));
			canStk.setmCap(record.get("Market Cap."));
			canStk.setShares(record.get("Shares"));
			canStk.setBeta(
					isNullOrEmpty(record.get("Beta")) ? null : Double.parseDouble(record.get("Beta").replace(",", "")));
			canStk.setMark(
					isNullOrEmpty(record.get("Mark")) ? null : Double.parseDouble(record.get("Mark").replace(",", "")));
			canStk.setLast(
					isNullOrEmpty(record.get("Last")) ? null : Double.parseDouble(record.get("Last").replace(",", "")));
			canStk.setOpenInt(isNullOrEmpty(record.get("Open Int")) ? null
					: Long.parseLong(record.get("Open Int").replace(",", "")));
			canStk.setSpread(isNullOrEmpty(record.get("Spread")) ? null
					: Double.parseDouble(record.get("Spread").replace(",", "")));
			canStk.setNetChange(isNullOrEmpty(record.get("Net Change")) ? null
					: Double.parseDouble(record.get("Net Change").replace(",", "")));
			canStk.setBidSize(isNullOrEmpty(record.get("Bid Size")) ? null
					: Long.parseLong(record.get("Bid Size").replace(",", "")));
			canStk.setSize(isNullOrEmpty(record.get("Size")) ? null : Long.parseLong(record.get("Size")));
			canStk.setAskSize(isNullOrEmpty(record.get("Ask Size")) ? null
					: Long.parseLong(record.get("Ask Size").replace(",", "")));
			canStk.setLastSize(isNullOrEmpty(record.get("Last Size")) ? null
					: Long.parseLong(record.get("Last Size").replace(",", "")));
			canStk.setInstrument(record.get("Instrument"));
			canStk.setOpenPrice(
					isNullOrEmpty(record.get("Open")) ? null : Double.parseDouble(record.get("Open").replace(",", "")));
			canStk.setFiftyTwotWeekLow(isNullOrEmpty(record.get("52 week Low")) ? null
					: Double.parseDouble(record.get("52 week Low").replace(",", "")));
			canStk.setLow(
					isNullOrEmpty(record.get("Low")) ? null : Double.parseDouble(record.get("Low").replace(",", "")));
			canStk.setBid(
					isNullOrEmpty(record.get("Bid")) ? null : Double.parseDouble(record.get("Bid").replace(",", "")));
			canStk.setAsk(
					isNullOrEmpty(record.get("Ask")) ? null : Double.parseDouble(record.get("Ask").replace(",", "")));
			canStk.setHigh(
					isNullOrEmpty(record.get("High")) ? null : Double.parseDouble(record.get("High").replace(",", "")));
			canStk.setPrevClose(isNullOrEmpty(record.get("Prev Close")) ? null
					: Double.parseDouble(record.get("Prev Close").replace(",", "")));
			canStk.setFiftyTwotWeekHigh(isNullOrEmpty(record.get("52 week High")) ? null
					: Double.parseDouble(record.get("52 week High").replace(",", "")));
			canStk.setCusip(record.get("CUSIP"));
			canStk.setMaintenaceMargin(isNullOrEmpty(record.get("Maintenance Margin")) ? null
					: Double.parseDouble(record.get("Maintenance Margin").replace(",", "")));
			canStk.setDaysToExpire(isNullOrEmpty(record.get("Days To Expiration")) ? null
					: Integer.parseInt(record.get("Days To Expiration").replace(",", "")));
			canStk.setDelta(isNullOrEmpty(record.get("Delta")) ? null
					: Double.parseDouble(record.get("Delta").replace(",", "")));
			canStk.setExpirationDate(record.get("Expiration Date"));
			canStk.setFirstNoticeDate(record.get("First Notice Date"));
			canStk.setImpVolume(isNullOrEmpty(record.get("Impl Vol")) ? null
					: Double.parseDouble(record.get("Impl Vol").replace(",", "")));
			canStk.setGamma(isNullOrEmpty(record.get("Gamma")) ? null
					: Double.parseDouble(record.get("Gamma").replace(",", "")));
			canStk.setTradingHalt(record.get("Trading Halt"));
			canStk.setLastTradeDate(record.get("Last Trade Date"));
			canStk.setLimitDown(isNullOrEmpty(record.get("Limit Down")) ? null
					: Double.parseDouble(record.get("Limit Down").replace(",", "")));
			canStk.setLimitUp(isNullOrEmpty(record.get("Limit Up")) ? null
					: Double.parseDouble(record.get("Limit Up").replace(",", "")));
			canStk.setRho(
					isNullOrEmpty(record.get("Rho")) ? null : Double.parseDouble(record.get("Rho").replace(",", "")));
			canStk.setTheoPrice(isNullOrEmpty(record.get("Theo Price")) ? null
					: Double.parseDouble(record.get("Theo Price").replace(",", "")));
			canStk.setStrike(isNullOrEmpty(record.get("Strike")) ? null
					: Double.parseDouble(record.get("Strike").replace(",", "")));
			canStk.setTheta(isNullOrEmpty(record.get("Theta")) ? null
					: Double.parseDouble(record.get("Theta").replace(",", "")));
			canStk.setTickValue(isNullOrEmpty(record.get("Tick Value")) ? null
					: Double.parseDouble(record.get("Tick Value").replace(",", "")));
			canStk.setVega(
					isNullOrEmpty(record.get("Vega")) ? null : Double.parseDouble(record.get("Vega").replace(",", "")));

			lsData.add(canStk);
		}

		stockRepository.saveAll(lsData); // Batch save to DB
		exportToCsv(exportPath);
	}

	/**
	 * Method to extract load date from file path.
	 * 
	 * @param filePath
	 * @return
	 */
	private static String extractDateFromFilePath(String filePath) {
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
	private DateData dateTimeExtractor(DateData extractedDate) {

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

	/**
	 * Method to check whether string is empty or null.
	 * 
	 * @param field
	 * @return
	 */
	private static boolean isNullOrEmpty(String field) {
		return field == null || field.trim().isEmpty();
	}

	/**
	 * Method to export data to csv from sql server table.
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public void exportToCsv(String filePath) throws IOException {
		// Fetch all data from the database
		List<CanEntity> dataList = stockRepository.findAll();

		// Prepare CSV file writer
		FileWriter fileWriter = new FileWriter(filePath);
		CSVPrinter csvPrinter = new CSVPrinter(fileWriter,
				CSVFormat.DEFAULT.withHeader("ID", "Date", "DayOfWeek", "WeekOfMonth", "WeekOfYear", "WatchList",
						"Symbol", "Description", "Volume", "% Change", "Market Cap.", "Shares", "Beta", "Mark", "Last",
						"Open Int", "Spread", "Net Change", "Bid Size", "Size", "Ask Size", "Last Size", "Instrument",
						"Open", "52 week Low", "Low", "Bid", "Ask", "High", "Prev Close", "52 week High", "CUSIP",
						"Maintenance Margin", "Days To Expiration", "Delta", "Expiration Date", "First Notice Date",
						"Impl Vol", "Gamma", "Trading Halt", "Last Trade Date", "Limit Down", "Limit Up", "Rho",
						"Theo Price", "Strike", "Theta", "Tick Value", "Vega"));

		// Write data to CSV
		for (CanEntity entity : dataList) {

			csvPrinter.printRecord(entity.getId(), entity.getDate(), entity.getDayOfWeek(), entity.getWeekOfMonth(),
					entity.getWeekOfYear(), entity.getWatchList(), entity.getSymbol(), entity.getDescription(),
					entity.getVolume(), entity.getpChange(), entity.getmCap(), entity.getShares(), entity.getBeta(),
					entity.getMark(), entity.getLast(), entity.getOpenInt(), entity.getSpread(), entity.getNetChange(),
					entity.getBidSize(), entity.getSize(), entity.getAskSize(), entity.getLastSize(),
					entity.getInstrument(), entity.getOpenPrice(), entity.getFiftyTwotWeekLow(), entity.getLow(),
					entity.getBid(), entity.getAsk(), entity.getHigh(), entity.getPrevClose(),
					entity.getFiftyTwotWeekHigh(), entity.getCusip(), entity.getMaintenaceMargin(),
					entity.getDaysToExpire(), entity.getDelta(), entity.getExpirationDate(),
					entity.getFirstNoticeDate(), entity.getImpVolume(), entity.getGamma(), entity.getTradingHalt(), entity.getLastTradeDate(),
					entity.getLimitDown(), entity.getLimitUp(), entity.getRho(), entity.getTheoPrice(), entity.getStrike(), entity.getTheta(), entity.getTickValue(), entity.getVega());
		}

		// Close resources
		csvPrinter.flush();
		csvPrinter.close();
	}

}
