GoogleMapsVaadin7
=================

Basic Integration of Google Maps API v2 + Vaadin 7

This is a sample project to demonstrate the integration of Google Maps API v2 and Vaadin 7.

The maven file pom.xml is provided but you need to download two google libraries:
gwt-maps and gwt-user and install them on your maven repository:

mvn install:install-file -Dfile=/path/to/gwt-maps.jar -DgroupId=com.google.gwt \
    -DartifactId=gwt-maps -Dversion=1.1.1 -Dpackaging=jar
    
    
After that, run the following to build your GWT component:

mvn vaadin:compile -Dgwt.compiler.strict=true


and then finally, run mvn jetty:run

Enjoy!
