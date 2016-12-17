
package com.gmail.at.sichyuriyy.lab7.wsclient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WatchListImplService", targetNamespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", wsdlLocation = "http://localhost:8081/Lab7-0.0.1-SNAPSHOT/WatchListImpl?wsdl")
public class WatchListImplService
    extends Service
{

    private final static URL WATCHLISTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WATCHLISTIMPLSERVICE_EXCEPTION;
    private final static QName WATCHLISTIMPLSERVICE_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "WatchListImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/Lab7-0.0.1-SNAPSHOT/WatchListImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WATCHLISTIMPLSERVICE_WSDL_LOCATION = url;
        WATCHLISTIMPLSERVICE_EXCEPTION = e;
    }

    public WatchListImplService() {
        super(__getWsdlLocation(), WATCHLISTIMPLSERVICE_QNAME);
    }

    public WatchListImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WATCHLISTIMPLSERVICE_QNAME, features);
    }

    public WatchListImplService(URL wsdlLocation) {
        super(wsdlLocation, WATCHLISTIMPLSERVICE_QNAME);
    }

    public WatchListImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WATCHLISTIMPLSERVICE_QNAME, features);
    }

    public WatchListImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WatchListImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WatchListWS
     */
    @WebEndpoint(name = "WatchListImplPort")
    public WatchListWS getWatchListImplPort() {
        return super.getPort(new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "WatchListImplPort"), WatchListWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WatchListWS
     */
    @WebEndpoint(name = "WatchListImplPort")
    public WatchListWS getWatchListImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "WatchListImplPort"), WatchListWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WATCHLISTIMPLSERVICE_EXCEPTION!= null) {
            throw WATCHLISTIMPLSERVICE_EXCEPTION;
        }
        return WATCHLISTIMPLSERVICE_WSDL_LOCATION;
    }

}