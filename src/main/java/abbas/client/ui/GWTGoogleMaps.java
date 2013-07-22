package abbas.client.ui;

import com.google.gwt.ajaxloader.client.AjaxLoader;
import com.google.gwt.ajaxloader.client.AjaxLoader.AjaxLoaderOptions;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.Position.Coordinates;
import com.google.gwt.geolocation.client.PositionError;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;


public class GWTGoogleMaps extends Composite{

	//private final FlowPanel root = new FlowPanel();
	//SimplePanel root = new SimplePanel();
	private DockLayoutPanel root = new DockLayoutPanel(Unit.PX);
	private MapWidget map = null;

	public GWTGoogleMaps()
	{
		initWidget(root);
		
		final AjaxLoaderOptions opts = AjaxLoaderOptions.newInstance();
		opts.setOtherParms("sensor=false");

		AjaxLoader.loadApi("maps", "2", new Runnable() {
			@Override
			public void run() {
				buildUi();
			}
		}, opts);
	}

	protected void buildUi() {
			    // Open a map centered on Cawker City, KS USA
			    LatLng cawkerCity = LatLng.newInstance(39.509, -98.434);
		
			    map = new MapWidget(cawkerCity, 2);
			    map.setSize("100%", "100%");
			    // Add some controls for the zoom level
			    map.addControl(new LargeMapControl());
		
			    // Add a marker
			    map.addOverlay(new Marker(cawkerCity));
		
			    // Add an info window to highlight a point of interest
			    map.getInfoWindow().open(map.getCenter(),
			        new InfoWindowContent("World's Largest Ball of Sisal Twine"));
		
			    root.addNorth(map, 500);

	}
	
	public MapWidget getMapWidget()
	{
		return this.map;
	}
	
	public void setCenter(double latitude, double longitude) {
		this.map.setCenter(LatLng.newInstance(latitude, longitude));
	}

}
