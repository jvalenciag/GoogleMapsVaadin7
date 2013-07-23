GoogleMapsVaadin7
=================

Basic Integration of Google Maps API v2 + Vaadin 7

This is a sample project to demonstrate the integration of Google Maps API v2 and Vaadin 7.

The maven file <strong>pom.xml</strong> is provided, but you need to <a href="https://code.google.com/p/gwt-google-apis/downloads/list">download</a> the google maps library and manually install it on your maven repository. Make sure you download the right version of gwt-maps (<a href="https://code.google.com/p/gwt-google-apis/downloads/detail?name=gwt-maps-1.1.1.zip&can=2&q=">v 1.1.1</a>).

Run the following command to install the jar file in your local maven repository:
```
mvn install:install-file -Dfile=/path/to/gwt-maps.jar -DgroupId=com.google.gwt \
    -DartifactId=gwt-maps -Dversion=1.1.1 -Dpackaging=jar
```
    
    
After that, run the following to build your GWT component:
```
mvn vaadin:compile -Dgwt.compiler.strict=true
```

and then finally, run ```mvn jetty:run```

<i>Enjoy!</i>
