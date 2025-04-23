package com.example.obesity.calc;

public class ObesityCalc {

	private String result;
	private String imgSrc;
	
	public void calcObesity(Double height, Double weight) {
		
		double stdWeight = (height - 100) * 0.85;
		double obesity = (weight/stdWeight) * 100;
		
		result = "";
		imgSrc = "/images/";
		
		if(obesity <= 90) {
			result = "저체중";
			imgSrc += "under.png";
		}
		else if (obesity <= 110) {
			result = "정상";
			imgSrc += "normal.png";
		}
		else if (obesity <= 120) {
			result = "과체중";
			imgSrc += "over.png";
		}
		else {
			result = "비만";
			imgSrc += "obese.png";
		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	
}
