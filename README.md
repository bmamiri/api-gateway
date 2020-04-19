# api-gateway

Zuul is an edge service that proxies requests to multiple backing services. It provides a unified “front door” to your ecosystem, which allows any browser, mobile app or other user interfaces to consume services from multiple hosts.<br>

Zuul has mainly four types of filters that enable us to intercept the traffic in the different timelines of the request processing for any particular transaction. We can add any number of filters for a particular URL pattern.<br>
* **pre filters** – are invoked before the request is routed.<br>
* **post filters** – are invoked after the request has been routed.<br>
* **route filters** – are used to route the request.<br>
* **error filters** – are invoked when an error occurs while handling the request.<br>

We will create below artifacts to demonstrate the whole thing:<br>
* **Student Microservice** – a spring boot based microservice which will just expose a single URL to enable some search functionality. For simplicity we will just return hardcoded values, but in real-world we can connect to anywhere from this service to get the data.<br>
http://localhost:8090/student/getStudentDetails/john<br>
http://localhost:8090/student/echoStudentName/john<br>

* **Zuul gateway service proxy** – It would be again a spring boot based, which will basically intercept all the traffic of student service and apply series of request filters and then route to the underlying service and again at the time of response serving, it will apply some response filtering. Since it is a gateway, we can literally take many interesting and useful action using the filters effectively.<br>
http://localhost:8080/student/getStudentDetails/john<br>
http://localhost:8080/student/echoStudentName/john<br>

Some of the common responsibility of gateway service are:<br>
* Apply **microservice authentication and security** in the gateway layer to protect the actual services<br>
* We can do **microservices insights and monitoring** of all the traffic that are going into the ecosystem by enabling some logging to get meaningful data and statistics at the edge in order to give us an accurate view of production.<br>
* **Dynamic Routing** can route requests to different backend clusters as needed.<br>
* We can do **runtime stress testing** by gradually increasing the traffic to a new cluster in order to gauge performance in many scenarios e.g. cluster has new H/W and network setup or that has a new version of production code deployed.<br>
* We can do **dynamic load shedding** i.e. allocating capacity for each type of request and dropping requests that go over the limit.<br>
* We can apply **static response handling** i.e. building some responses directly at the edge instead of forwarding them to an internal cluster for processing.<br>
