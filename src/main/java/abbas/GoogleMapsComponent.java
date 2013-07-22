package abbas;

import abbas.client.ui.GoogleMapsComponentState;

import com.google.gwt.maps.client.geom.LatLng;
import com.vaadin.server.Page;
import com.vaadin.ui.AbstractComponent;




public class GoogleMapsComponent extends AbstractComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unqieStyleName = "abcdefg";

	public GoogleMapsComponent() {
		// the generated html code contains a parent div with a single v-widget class and style="position: relative"
		// the relative position hides everything inside it, that's why we use this hack:
		// give the component a unique style name, use jquery to find that element abd manually set the position to static
		// of course, we have to make sure we do this after the page is loaded, hence $(function(){...});
		this.addStyleName(unqieStyleName);
		Page.getCurrent().getJavaScript().execute(String.format("$(function(){$('.%s').css('position','static');});", unqieStyleName));
	}
	
	@Override
    protected GoogleMapsComponentState getState() {
        return (GoogleMapsComponentState) super.getState();
    }
	
	public void setCenter(double latitude, double longitude) {
		getState().setCenter(latitude, longitude);
	}
	public void setZoomLevel(int zoomLevel)
	{
		getState().setZoomLevel(zoomLevel);
	}
}
