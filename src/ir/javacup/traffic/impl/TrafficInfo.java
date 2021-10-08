package ir.javacup.traffic.impl;

public class TrafficInfo {

	private String locationCode;
	private int trafficLevel;

	@Override
	public String toString() {
		return "TrafficInfo[locationCode=" + locationCode + ", trafficLevel=" + trafficLevel + "]";
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public int getTrafficLevel() {
		return trafficLevel;
	}

	public void setTrafficLevel(int trafficLevel) {
		this.trafficLevel = trafficLevel;
	}

}
