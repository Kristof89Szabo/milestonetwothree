## N-tier architecture

It is a software architectural pattern that divides an application into multiple tiers(layers), each responsible for
specific functionality. This approach helps to separate concerns, improve scalability, and promote reusability and
maintainability in complex systems.

In a multi-tiered architecture, the application is typically divided into three main tiers or layers:

- `Presentation Tier` (or User Interface Tier): This is the topmost layer, responsible for presenting the user interface
  and handling user interactions. It can include components like web browsers, mobile apps, or desktop clients. The
  presentation tier interacts with the underlying layers to retrieve and display data to the user.

- `Business Logic Tier` (or Application Tier): The business logic tier contains the core functionality and processing
  logic of the application. It handles tasks such as data validation, business rules, and workflow management. This
  layer is
  responsible for processing and manipulating data received from the presentation tier before passing it to the data
  storage layer.

- `Data Storage Tier` (or Data Access Tier): The data storage tier is responsible for managing data persistence and
  retrieval. It includes databases, file systems, or any other data storage mechanisms. This layer provides the
  necessary
  infrastructure to store, retrieve, and manipulate data requested by the application.

![](../../../../resources/softwaredesign/img.png)

`Tiers` refer to the physical separation of functionality into distinct layers within an application,
typically involving presentation, business logic, and data storage tiers.

`Layers` refer to the logical separation of components within a single tier, emphasizing modular organization and
separation of concerns within that tier.

## SOA - Service-Oriented Architecture

#### SOAP - Simple Object Access Protocol

Simple Object Access Protocol (SOAP) is a lightweight XML-based protocol that is used for the exchange of information in
decentralized, distributed application environments.

Sample Call

```xml
  POST /StockQuote HTTP/1.1
        Host: www.stockquoteserver.com
        Content-Type: text/xml;
        charset="utf-8"
        Content-Length: nnnn
        SOAPAction: "Some-URI"
        <?xml version="1.0"?>
<SOAP-ENV:Envelope
        xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
        SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">
    <SOAP-ENV:Body>
        <m:GetLastTradePrice xmlns:m="Some-URI">
            <symbol>DIS</symbol>
        </m:GetLastTradePrice>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

Sample Response

```xml
HTTP/1.1 200 OK
        Content-Type: text/xml;
        charset="utf-8"
        Content-Length: nnnn
        <?xml version="1.0"?>
<SOAP-ENV:Envelope
        xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
        SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
<SOAP-ENV:Body>
<m:GetLastTradePriceResponse xmlns:m="Some-URI">
    <Price>34.5</Price>
</m:GetLastTradePriceResponse>
</SOAP-ENV:Body>
        </SOAP-ENV:Envelope>
```

#### SOA

SOA, or service-oriented architecture, is a mechanism for integrating multiple larger components, typically
applications, together so they form an interoperable suite.

Each component typically performs a complete piece of business logic from start to finish, usually involving a variety
of specific tasks and functions needed to complete an entire larger action. Components are typically loosely coupled but
this is not a requirement of the SOA architecture patterns.

![](../../../../resources/softwaredesign/img_1.png)

[READ MORE](https://medium.com/@SoftwareDevelopmentCommunity/what-is-service-oriented-architecture-fa894d11a7ec)


