GoogleMapsVaadin7
=================

Basic Integration of Google Maps API v2 + Vaadin 7

![alt tag](http://s17.postimg.org/gh6ty5t8v/Screen_Shot_2013_07_23_at_12_14_11_PM.png)

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

###Technical Details
I wrote this plugin based on documetation on <a href="https://vaadin.com/book/-/page/gwt.html">Chapter 16</a> Book of Vaadin. Essentially, any code that deals with the client side goes in the ```client.ui``` package. This includes the shared object between client and server (```ComponentState```) and the connector that gets the changes in the state object and update the GWT component accordingly. In a nutshell, the server side component changes the state object, the connector gets the changes and reflect it on the GWT component.
