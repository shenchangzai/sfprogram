package com.xu.common.model;

public class ImageCode implements BaseModel<String>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4066984916469733217L;

	private String uuid;
	
	private String qrCodeImg;


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getQrCodeImg() {
		return qrCodeImg;
	}

	public void setQrCodeImg(String qrCodeImg) {
		this.qrCodeImg = qrCodeImg;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public void setId(String id) {
		
	}
}
