package com.xu.common.model;

public class TeamRule  implements BaseModel<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 314955814157761127L;
	
	
	private String mktId;
	private String rule;
	private int incr = 1;

	
	public String getMktId() {
		return mktId;
	}
	public void setMktId(String mktId) {
		this.mktId = mktId;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public int getIncr() {
		return incr;
	}
	public void setIncr(int incr) {
		this.incr = incr;
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
