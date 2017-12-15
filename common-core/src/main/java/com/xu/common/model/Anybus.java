package com.xu.common.model;

public class Anybus implements BaseModel<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2436881208070091162L;
	
	private String mktId;
	private String mktNameShow;
	private int dailyMinPackages;
	private double weightMin;
	private double weightMax;
	private double basePrice;
	private double baseWeight;
	private int groupLimit;
	private int groupDuration;
	private String useRequire;
	public String getMktId() {
		return mktId;
	}
	public void setMktId(String mktId) {
		this.mktId = mktId;
	}
	public String getMktNameShow() {
		return mktNameShow;
	}
	public void setMktNameShow(String mktNameShow) {
		this.mktNameShow = mktNameShow;
	}
	public int getDailyMinPackages() {
		return dailyMinPackages;
	}
	public void setDailyMinPackages(int dailyMinPackages) {
		this.dailyMinPackages = dailyMinPackages;
	}
	public double getWeightMin() {
		return weightMin;
	}
	public void setWeightMin(double weightMin) {
		this.weightMin = weightMin;
	}
	public double getWeightMax() {
		return weightMax;
	}
	public void setWeightMax(double weightMax) {
		this.weightMax = weightMax;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getBaseWeight() {
		return baseWeight;
	}
	public void setBaseWeight(double baseWeight) {
		this.baseWeight = baseWeight;
	}
	public int getGroupLimit() {
		return groupLimit;
	}
	public void setGroupLimit(int groupLimit) {
		this.groupLimit = groupLimit;
	}
	public int getGroupDuration() {
		return groupDuration;
	}
	public void setGroupDuration(int groupDuration) {
		this.groupDuration = groupDuration;
	}
	public String getUseRequire() {
		return useRequire;
	}
	public void setUseRequire(String useRequire) {
		this.useRequire = useRequire;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

}
