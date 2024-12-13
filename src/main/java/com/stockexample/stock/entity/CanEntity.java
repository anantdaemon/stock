/**
 * 
 */
package com.stockexample.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "CanadaAT")
public class CanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Primary key, if applicable

	private String date;

	private Integer dayOfWeek;

	private Integer weekOfMonth;

	private Integer weekOfYear;

	private String watchList;

	private String symbol;

	private String description;

	private Long volume;

	private Double pChange;

	private String mCap;

	private String shares;

	private Double beta;

	private Double mark;

	private Double last;

	private Long openInterest;

	private Double spread;

	private Double netChange;

	private Long bidSize;

	private Long size;

	private Long askSize;

	private Long lastSize;

	private String instrument;

	private Double openPrice;

	private Double fiftyTwotWeekLow;

	private Double fiftyTwotWeekHigh;

	private Double low;

	private Double bid;

	private Double high;

	private Double ask;

	private Double prevClose;

	private Double cusip;

	private Double maintenaceMargin;

	private Integer daysToExpire;

	private Double delta;

	private String expirationDate;

	private String firstNoticeDate;

	private Double impVolume;

	private Double gamma;

	private String tradingHalt;

	private String lastTradeDate;

	private Double limitDown;

	private Double limitUp;

	private Double rho;

	private Double theoPrice;

	private Double strike;

	private Double theta;

	private Double tickValue;
	
	private Double vega;

	public CanEntity() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the dayOfWeek
	 */
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the weekOfMonth
	 */
	public Integer getWeekOfMonth() {
		return weekOfMonth;
	}

	/**
	 * @param weekOfMonth the weekOfMonth to set
	 */
	public void setWeekOfMonth(Integer weekOfMonth) {
		this.weekOfMonth = weekOfMonth;
	}

	/**
	 * @return the weekOfYear
	 */
	public Integer getWeekOfYear() {
		return weekOfYear;
	}

	/**
	 * @param weekOfYear the weekOfYear to set
	 */
	public void setWeekOfYear(Integer weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	/**
	 * @return the watchList
	 */
	public String getWatchList() {
		return watchList;
	}

	/**
	 * @param watchList the watchList to set
	 */
	public void setWatchList(String watchList) {
		this.watchList = watchList;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the volume
	 */
	public Long getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Long volume) {
		this.volume = volume;
	}

	/**
	 * @return the pChange
	 */
	public Double getpChange() {
		return pChange;
	}

	/**
	 * @param pChange the pChange to set
	 */
	public void setpChange(Double pChange) {
		this.pChange = pChange;
	}

	/**
	 * @return the mCap
	 */
	public String getmCap() {
		return mCap;
	}

	/**
	 * @param mCap the mCap to set
	 */
	public void setmCap(String mCap) {
		this.mCap = mCap;
	}

	/**
	 * @return the shares
	 */
	public String getShares() {
		return shares;
	}

	/**
	 * @param shares the shares to set
	 */
	public void setShares(String shares) {
		this.shares = shares;
	}

	/**
	 * @return the beta
	 */
	public Double getBeta() {
		return beta;
	}

	/**
	 * @param beta the beta to set
	 */
	public void setBeta(Double beta) {
		this.beta = beta;
	}

	/**
	 * @return the mark
	 */
	public Double getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(Double mark) {
		this.mark = mark;
	}

	/**
	 * @return the last
	 */
	public Double getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(Double last) {
		this.last = last;
	}

	/**
	 * @return the openInt
	 */
	public Long getOpenInt() {
		return openInterest;
	}

	/**
	 * @param openInt the openInt to set
	 */
	public void setOpenInt(Long openInterest) {
		this.openInterest = openInterest;
	}

	/**
	 * @return the spread
	 */
	public Double getSpread() {
		return spread;
	}

	/**
	 * @param spread the spread to set
	 */
	public void setSpread(Double spread) {
		this.spread = spread;
	}

	/**
	 * @return the netChange
	 */
	public Double getNetChange() {
		return netChange;
	}

	/**
	 * @param netChange the netChange to set
	 */
	public void setNetChange(Double netChange) {
		this.netChange = netChange;
	}

	/**
	 * @return the bidSize
	 */
	public Long getBidSize() {
		return bidSize;
	}

	/**
	 * @param bidSize the bidSize to set
	 */
	public void setBidSize(Long bidSize) {
		this.bidSize = bidSize;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * @return the askSize
	 */
	public Long getAskSize() {
		return askSize;
	}

	/**
	 * @param askSize the askSize to set
	 */
	public void setAskSize(Long askSize) {
		this.askSize = askSize;
	}

	/**
	 * @return the lastSize
	 */
	public Long getLastSize() {
		return lastSize;
	}

	/**
	 * @param lastSize the lastSize to set
	 */
	public void setLastSize(Long lastSize) {
		this.lastSize = lastSize;
	}

	/**
	 * @return the instrument
	 */
	public String getInstrument() {
		return instrument;
	}

	/**
	 * @param instrument the instrument to set
	 */
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	/**
	 * @return the open
	 */
	public Double getOpenPrice() {
		return openPrice;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	/**
	 * @return the fiftyTwotWeekLow
	 */
	public Double getFiftyTwotWeekLow() {
		return fiftyTwotWeekLow;
	}

	/**
	 * @param fiftyTwotWeekLow the fiftyTwotWeekLow to set
	 */
	public void setFiftyTwotWeekLow(Double fiftyTwotWeekLow) {
		this.fiftyTwotWeekLow = fiftyTwotWeekLow;
	}

	/**
	 * @return the fiftyTwotWeekHigh
	 */
	public Double getFiftyTwotWeekHigh() {
		return fiftyTwotWeekHigh;
	}

	/**
	 * @param fiftyTwotWeekHigh the fiftyTwotWeekHigh to set
	 */
	public void setFiftyTwotWeekHigh(Double fiftyTwotWeekHigh) {
		this.fiftyTwotWeekHigh = fiftyTwotWeekHigh;
	}

	/**
	 * @return the low
	 */
	public Double getLow() {
		return low;
	}

	/**
	 * @param low the low to set
	 */
	public void setLow(Double low) {
		this.low = low;
	}

	/**
	 * @return the bid
	 */
	public Double getBid() {
		return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(Double bid) {
		this.bid = bid;
	}

	/**
	 * @return the high
	 */
	public Double getHigh() {
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(Double high) {
		this.high = high;
	}

	/**
	 * @return the ask
	 */
	public Double getAsk() {
		return ask;
	}

	/**
	 * @param ask the ask to set
	 */
	public void setAsk(Double ask) {
		this.ask = ask;
	}

	/**
	 * @return the prevClose
	 */
	public Double getPrevClose() {
		return prevClose;
	}

	/**
	 * @param prevClose the prevClose to set
	 */
	public void setPrevClose(Double prevClose) {
		this.prevClose = prevClose;
	}

	/**
	 * @return the cusip
	 */
	public Double getCusip() {
		return cusip;
	}

	/**
	 * @param cusip the cusip to set
	 */
	public void setCusip(Double cusip) {
		this.cusip = cusip;
	}

	/**
	 * @return the maintenaceMargin
	 */
	public Double getMaintenaceMargin() {
		return maintenaceMargin;
	}

	/**
	 * @param maintenaceMargin the maintenaceMargin to set
	 */
	public void setMaintenaceMargin(Double maintenaceMargin) {
		this.maintenaceMargin = maintenaceMargin;
	}

	/**
	 * @return the daysToExpire
	 */
	public Integer getDaysToExpire() {
		return daysToExpire;
	}

	/**
	 * @param daysToExpire the daysToExpire to set
	 */
	public void setDaysToExpire(Integer daysToExpire) {
		this.daysToExpire = daysToExpire;
	}

	/**
	 * @return the delta
	 */
	public Double getDelta() {
		return delta;
	}

	/**
	 * @param delta the delta to set
	 */
	public void setDelta(Double delta) {
		this.delta = delta;
	}

	/**
	 * @return the expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the firstNoticeDate
	 */
	public String getFirstNoticeDate() {
		return firstNoticeDate;
	}

	/**
	 * @param firstNoticeDate the firstNoticeDate to set
	 */
	public void setFirstNoticeDate(String firstNoticeDate) {
		this.firstNoticeDate = firstNoticeDate;
	}

	/**
	 * @return the impVolume
	 */
	public Double getImpVolume() {
		return impVolume;
	}

	/**
	 * @param impVolume the impVolume to set
	 */
	public void setImpVolume(Double impVolume) {
		this.impVolume = impVolume;
	}

	/**
	 * @return the gamma
	 */
	public Double getGamma() {
		return gamma;
	}

	/**
	 * @param gamma the gamma to set
	 */
	public void setGamma(Double gamma) {
		this.gamma = gamma;
	}

	/**
	 * @return the tradingHalt
	 */
	public String getTradingHalt() {
		return tradingHalt;
	}

	/**
	 * @param tradingHalt the tradingHalt to set
	 */
	public void setTradingHalt(String tradingHalt) {
		this.tradingHalt = tradingHalt;
	}

	/**
	 * @return the lastTradeDate
	 */
	public String getLastTradeDate() {
		return lastTradeDate;
	}

	/**
	 * @param lastTradeDate the lastTradeDate to set
	 */
	public void setLastTradeDate(String lastTradeDate) {
		this.lastTradeDate = lastTradeDate;
	}

	/**
	 * @return the limitDown
	 */
	public Double getLimitDown() {
		return limitDown;
	}

	/**
	 * @param limitDown the limitDown to set
	 */
	public void setLimitDown(Double limitDown) {
		this.limitDown = limitDown;
	}

	/**
	 * @return the limitUp
	 */
	public Double getLimitUp() {
		return limitUp;
	}

	/**
	 * @param limitUp the limitUp to set
	 */
	public void setLimitUp(Double limitUp) {
		this.limitUp = limitUp;
	}

	/**
	 * @return the rho
	 */
	public Double getRho() {
		return rho;
	}

	/**
	 * @param rho the rho to set
	 */
	public void setRho(Double rho) {
		this.rho = rho;
	}

	/**
	 * @return the theoPrice
	 */
	public Double getTheoPrice() {
		return theoPrice;
	}

	/**
	 * @param theoPrice the theoPrice to set
	 */
	public void setTheoPrice(Double theoPrice) {
		this.theoPrice = theoPrice;
	}

	/**
	 * @return the strike
	 */
	public Double getStrike() {
		return strike;
	}

	/**
	 * @param strike the strike to set
	 */
	public void setStrike(Double strike) {
		this.strike = strike;
	}

	/**
	 * @return the theta
	 */
	public Double getTheta() {
		return theta;
	}

	/**
	 * @param theta the theta to set
	 */
	public void setTheta(Double theta) {
		this.theta = theta;
	}

	/**
	 * @return the tickValue
	 */
	public Double getTickValue() {
		return tickValue;
	}

	/**
	 * @param tickValue the tickValue to set
	 */
	public void setTickValue(Double tickValue) {
		this.tickValue = tickValue;
	}

	/**
	 * @return the vega
	 */
	public Double getVega() {
		return vega;
	}

	/**
	 * @param vega the vega to set
	 */
	public void setVega(Double vega) {
		this.vega = vega;
	}

}
