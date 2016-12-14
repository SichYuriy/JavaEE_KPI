
package com.gmail.at.sichyuriyy.lab7.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gmail.at.sichyuriyy.lab7.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWatchListById_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "getWatchListById");
    private final static QName _Create_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "create");
    private final static QName _CreateResponse_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "createResponse");
    private final static QName _GetAllWatchListsResponse_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "getAllWatchListsResponse");
    private final static QName _UpdateWatchList_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "updateWatchList");
    private final static QName _DeleteWatchListResponse_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "deleteWatchListResponse");
    private final static QName _GetAllWatchLists_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "getAllWatchLists");
    private final static QName _UpdateWatchListResponse_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "updateWatchListResponse");
    private final static QName _DeleteWatchList_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "deleteWatchList");
    private final static QName _GetWatchListByIdResponse_QNAME = new QName("http://wsserver.lab7.sichyuriyy.at.gmail.com/", "getWatchListByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gmail.at.sichyuriyy.lab7.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteWatchList }
     * 
     */
    public DeleteWatchList createDeleteWatchList() {
        return new DeleteWatchList();
    }

    /**
     * Create an instance of {@link GetWatchListByIdResponse }
     * 
     */
    public GetWatchListByIdResponse createGetWatchListByIdResponse() {
        return new GetWatchListByIdResponse();
    }

    /**
     * Create an instance of {@link UpdateWatchList }
     * 
     */
    public UpdateWatchList createUpdateWatchList() {
        return new UpdateWatchList();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link GetAllWatchListsResponse }
     * 
     */
    public GetAllWatchListsResponse createGetAllWatchListsResponse() {
        return new GetAllWatchListsResponse();
    }

    /**
     * Create an instance of {@link GetWatchListById }
     * 
     */
    public GetWatchListById createGetWatchListById() {
        return new GetWatchListById();
    }

    /**
     * Create an instance of {@link UpdateWatchListResponse }
     * 
     */
    public UpdateWatchListResponse createUpdateWatchListResponse() {
        return new UpdateWatchListResponse();
    }

    /**
     * Create an instance of {@link DeleteWatchListResponse }
     * 
     */
    public DeleteWatchListResponse createDeleteWatchListResponse() {
        return new DeleteWatchListResponse();
    }

    /**
     * Create an instance of {@link GetAllWatchLists }
     * 
     */
    public GetAllWatchLists createGetAllWatchLists() {
        return new GetAllWatchLists();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Rating }
     * 
     */
    public Rating createRating() {
        return new Rating();
    }

    /**
     * Create an instance of {@link WatchList }
     * 
     */
    public WatchList createWatchList() {
        return new WatchList();
    }

    /**
     * Create an instance of {@link Producer }
     * 
     */
    public Producer createProducer() {
        return new Producer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWatchListById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "getWatchListById")
    public JAXBElement<GetWatchListById> createGetWatchListById(GetWatchListById value) {
        return new JAXBElement<GetWatchListById>(_GetWatchListById_QNAME, GetWatchListById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllWatchListsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "getAllWatchListsResponse")
    public JAXBElement<GetAllWatchListsResponse> createGetAllWatchListsResponse(GetAllWatchListsResponse value) {
        return new JAXBElement<GetAllWatchListsResponse>(_GetAllWatchListsResponse_QNAME, GetAllWatchListsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWatchList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "updateWatchList")
    public JAXBElement<UpdateWatchList> createUpdateWatchList(UpdateWatchList value) {
        return new JAXBElement<UpdateWatchList>(_UpdateWatchList_QNAME, UpdateWatchList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteWatchListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "deleteWatchListResponse")
    public JAXBElement<DeleteWatchListResponse> createDeleteWatchListResponse(DeleteWatchListResponse value) {
        return new JAXBElement<DeleteWatchListResponse>(_DeleteWatchListResponse_QNAME, DeleteWatchListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllWatchLists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "getAllWatchLists")
    public JAXBElement<GetAllWatchLists> createGetAllWatchLists(GetAllWatchLists value) {
        return new JAXBElement<GetAllWatchLists>(_GetAllWatchLists_QNAME, GetAllWatchLists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWatchListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "updateWatchListResponse")
    public JAXBElement<UpdateWatchListResponse> createUpdateWatchListResponse(UpdateWatchListResponse value) {
        return new JAXBElement<UpdateWatchListResponse>(_UpdateWatchListResponse_QNAME, UpdateWatchListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteWatchList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "deleteWatchList")
    public JAXBElement<DeleteWatchList> createDeleteWatchList(DeleteWatchList value) {
        return new JAXBElement<DeleteWatchList>(_DeleteWatchList_QNAME, DeleteWatchList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWatchListByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsserver.lab7.sichyuriyy.at.gmail.com/", name = "getWatchListByIdResponse")
    public JAXBElement<GetWatchListByIdResponse> createGetWatchListByIdResponse(GetWatchListByIdResponse value) {
        return new JAXBElement<GetWatchListByIdResponse>(_GetWatchListByIdResponse_QNAME, GetWatchListByIdResponse.class, null, value);
    }

}
