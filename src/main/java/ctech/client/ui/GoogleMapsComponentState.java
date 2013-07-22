package ctech.client.ui;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geom.LatLng;
import com.vaadin.shared.AbstractComponentState;


public class GoogleMapsComponentState extends AbstractComponentState {
	private MapWidget map;
	
	private double centerLat;
	private double centerLong;
	private int zoomLevel = 1;


	public void setCenter(double latitude, double longitude) {
		this.setCenterLat(latitude);
		this.setCenterLong(longitude);
	}


	/**
	 * @return the centerLat
	 */
	public double getCenterLat() {
		return centerLat;
	}


	/**
	 * @param centerLat the centerLat to set
	 */
	public void setCenterLat(double centerLat) {
		this.centerLat = centerLat;
	}


	/**
	 * @return the centerLong
	 */
	public double getCenterLong() {
		return centerLong;
	}


	/**
	 * @param centerLong the centerLong to set
	 */
	public void setCenterLong(double centerLong) {
		this.centerLong = centerLong;
	}


	/**
	 * @return the zoomLevel
	 */
	public int getZoomLevel() {
		return zoomLevel;
	}


	/**
	 * @param zoomLevel the zoomLevel to set
	 */
	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

}
