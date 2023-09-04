package com.project.dto;

public class PriceModify 
{
	// private int priceId;
		private double businessClassPrice;
		private double economyClassPrice;
		private double firstClassPrice;
//		public int getPriceId() {
//			return priceId;
//		}
//		public void setPriceId(int priceId) {
//			this.priceId = priceId;
//		}
		public double getBusinessClassPrice() {
			return businessClassPrice;
		}
		public void setBusinessClassPrice(double businessClassPrice) {
			this.businessClassPrice = businessClassPrice;
		}
		public double getEconomyClassPrice() {
			return economyClassPrice;
		}
		public void setEconomyClassPrice(double economyClassPrice) {
			this.economyClassPrice = economyClassPrice;
		}
		public double getFirstClassPrice() {
			return firstClassPrice;
		}
		public void setFirstClassPrice(double firstClassPrice) {
			this.firstClassPrice = firstClassPrice;
		}
		public PriceModify( double businessClassPrice, double economyClassPrice, double firstClassPrice) {
			super();
			
			this.businessClassPrice = businessClassPrice;
			this.economyClassPrice = economyClassPrice;
			this.firstClassPrice = firstClassPrice;
		}

}
