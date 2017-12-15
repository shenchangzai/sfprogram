package com.xu.common.model;

/**
 * 专业市场基本信息表
 * @author 194129
 *
 */
public class ProMarketBase implements BaseModel<String>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 专业市场ID
	 */
	private String mktId;
	/**
	 * 市场外部名称
	 */
	private String mktNameShow;
	/**
	 * 单客日均最小件量
	 */
	private Integer dailyMinPackages;
	/**
	 * 重量区间（最小）
	 */
	private Float weightMin;
	/**
	 * 重量区间（最大）
	 */
	private Float weightMax;
	/**
	 * 首重价格
	 */
	private Float basePrice;
	/**
	 * 首重重量
	 */
	private Float baseWeight;
	/**
	 * 成团人数
	 */
	private Integer groupLimit;
	/**
	 * 拼团周期
	 */
	private Integer groupDuration;
	/**
	 * 使用要求
	 */
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
	public Integer getDailyMinPackages() {
		return dailyMinPackages;
	}
	public void setDailyMinPackages(Integer dailyMinPackages) {
		this.dailyMinPackages = dailyMinPackages;
	}
	public Float getWeightMin() {
		return weightMin;
	}
	public void setWeightMin(Float weightMin) {
		this.weightMin = weightMin;
	}
	public Float getWeightMax() {
		return weightMax;
	}
	public void setWeightMax(Float weightMax) {
		this.weightMax = weightMax;
	}
	public Float getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}
	public Float getBaseWeight() {
		return baseWeight;
	}
	public void setBaseWeight(Float baseWeight) {
		this.baseWeight = baseWeight;
	}
	public Integer getGroupLimit() {
		return groupLimit;
	}
	public void setGroupLimit(Integer groupLimit) {
		this.groupLimit = groupLimit;
	}
	public Integer getGroupDuration() {
		return groupDuration;
	}
	public void setGroupDuration(Integer groupDuration) {
		this.groupDuration = groupDuration;
	}
	public String getUseRequire() {
		return useRequire;
	}
	public void setUseRequire(String useRequire) {
		this.useRequire = useRequire;
	}
	
	@Override
	public String toString() {
		return "ProMarketBase [mktId=" + mktId + ", mktNameShow=" + mktNameShow + ", dailyMinPackages="
				+ dailyMinPackages + ", weightMin=" + weightMin + ", weightMax=" + weightMax + ", basePrice="
				+ basePrice + ", baseWeight=" + baseWeight + ", groupLimit=" + groupLimit + ", groupDuration="
				+ groupDuration + ", useRequire=" + useRequire + "]";
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
