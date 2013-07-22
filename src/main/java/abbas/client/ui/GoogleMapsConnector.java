package abbas.client.ui;

import abbas.GoogleMapsComponent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;



@Connect(GoogleMapsComponent.class)
public class GoogleMapsConnector extends AbstractComponentConnector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8326367764379524404L;
	

	@Override
	protected Widget createWidget() { 
		return GWT.create(GWTGoogleMaps.class);
	}
	
	@Override
	public GoogleMapsComponentState getState() {
	    return (GoogleMapsComponentState) super.getState();
	}
	
	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
	    super.onStateChanged(stateChangeEvent);
			
	    // Do something useful with the data
	    //final String text = getState().get
	    //getMapWidget().setCenter();
	    getGMapWidget().setCenter(getState().getCenterLat(), getState().getCenterLong());
	    getGMapWidget().getMapWidget().setZoomLevel(getState().getZoomLevel());
	}
	
	private GWTGoogleMaps getGMapWidget()
	{
		return ((GWTGoogleMaps)getWidget());
	}
}
