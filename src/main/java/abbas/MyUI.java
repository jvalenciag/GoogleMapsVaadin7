package abbas;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;


@JavaScript( {"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"} )
public class MyUI extends UI{

	VerticalLayout layout = new VerticalLayout();
	
	@SuppressWarnings("serial")
	@Override
	protected void init(VaadinRequest request) {
		
		layout.setSpacing(true);
		
		layout.setWidth(800, Unit.PIXELS);
		layout.setHeight(700, Unit.PIXELS);
		
		final GoogleMapsComponent map = new GoogleMapsComponent();
		
		layout.addComponent(map);
		layout.setComponentAlignment(map, Alignment.TOP_CENTER);
		map.setSizeFull();
		
		
		final TextField txtLat = new TextField("Latitude");
		final TextField txtLong = new TextField("Longtitude");
		Button btnSet = new Button("Set Center");
		btnSet.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				map.setCenter(Double.parseDouble(txtLat.getValue()), Double.parseDouble(txtLong.getValue()));
			}
		});
		
		HorizontalLayout layoutSetting = new HorizontalLayout();
		layoutSetting.setSpacing(true);
		layoutSetting.addComponent(txtLat);
		layoutSetting.addComponent(txtLong);
		layoutSetting.addComponent(btnSet);
		layoutSetting.setComponentAlignment(btnSet, Alignment.MIDDLE_CENTER);
		Slider slider = new Slider("Zoom Level", 0, 20);
		slider.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				double newLevel = (Double)(event.getProperty().getValue());
				map.setZoomLevel((int)newLevel);
			}
		});
		slider.setWidth(200, Unit.PIXELS);
		layoutSetting.addComponent(slider);
		layoutSetting.setComponentAlignment(slider, Alignment.MIDDLE_RIGHT);
		layout.addComponent(layoutSetting);


		
		layout.setExpandRatio(map, 0.71f);
		layout.setExpandRatio(layoutSetting, 0.29f);
		
		setContent(layout);
		
		
	}

}
