# springboot-micro-services
This is used to create the example for micro services using Springboot 

Added Feign Client - Feign provides an abstraction over REST-based calls via annotation, by which microservices can use to communicate with each other without writing detailed REST client code

Added Ribbon Client - Client Side Load Balancer: Ribbon. Ribbon is a client-side load balancer that gives you a lot of control over the behavior of HTTP and TCP clients.

1.	Challenges in micro services?
•	Define boundary for micro services
•	Configuration management
•	Dynamic scale up and scale down – dynamic distribute load balancing
•	Visibility – if somethings fails need to find out which micro services
•	Pack of Cards – micro service fault tolerance

2.	Advantages of Microservices-
•	New Process and 
•	Dynamic Scaling 
•	Faster release cycles

3.	What is Feign Client and why we used this?
Feign provides an abstraction over REST-based calls via annotation, by which microservices can use to communicate with each other without writing detailed REST client code.
To send HTTP Request to a destination albums-ws Microservice we will need to create a Feign Client interface. Please note the use of @FeignClient annotation which accepts the name albums-ws under which the destination Microservice is registered with Eureka Discovery Service.
Feign is a declarative web service client. It makes writing web service clients easier. To use Feign create an interface and annotate it. Spring Cloud integrates Ribbon and Eureka to provide a load balanced http client when using Feign.

4.	What is Ribbon Client and why we used this?
Ribbon is a client-side load balancer that gives you a lot of control over the behaviour of HTTP and TCP clients. On demand, Spring Cloud creates a new ensemble as an ApplicationContext for each named client by using RibbonClientConfiguration.
Netflix Ribbon is a Part of Netflix Open Source Software (Netflix OSS). It is a cloud library that provides the client-side load balancing. It automatically interacts with Netflix Service Discovery (Eureka) because it is a member of the Netflix family.
Features:
•	Load balancing
•	Fault tolerance
•	Multiple protocol support in Asynchronous model
•	Caching and batching
https://www.javatpoint.com/client-side-load-balancing-with-ribbon

5.	Eureka Naming Server-
Eureka naming server is an application that holds information about all client service applications. Each microservice registers itself with the Eureka naming server. The naming server registers the client services with their port numbers and IP addresses. It is also known as Discovery Server.  Eureka naming server comes with the bundle of Spring Cloud.
Whenever a new instance of a microservice comes up, it would register itself with the Eureka naming server. The registration of microservice with the naming server is called Service Registration.
The process of providing instances to other services is called Service Discovery.
If the Ribbon wants to distribute the load to the new server, we need to add it to the configuration. Based on the load, we can increase or decrease the number of instances of the services.

6.	ZUUL API Gateway (Microservices) Features-
•	Authentication, Authorization and security
•	Rate Limit – Limit the specific REST API calls per hour
•	Fault Tolerance – If service is down then providing default response
•	Service Aggregation
We can implement API gateway using Zuul.




7.	Microservice Distributed Tracing- Zipkin
While working with microservice if something gone wrong with any micro service then to debug and found issue is really complex that we need centralized log/distribute tracing so we can easily find issues. There number of options are available one of them is Zipkin. Zipkin is called distributed tracing system.
Zipkin is very efficient tool for distributed tracing in microservices ecosystem. Internally it has 4 modules –
Collector – Once any component sends the trace data arrives to Zipkin collector daemon, it is validated, stored, and indexed for lookups by the Zipkin collector.
Storage – This module store and index the lookup data in backend. Cassandra, ElasticSearch and MySQL are supported.
Search – This module provides a simple JSON API for finding and retrieving traces stored in backend. The primary consumer of this API is the Web UI.
Web UI – A very nice UI interface for viewing traces.

Other approaches are ELK Stack, Logstash and Kibana
https://www.elastic.co/what-is/elk-stack

We should used RabbitMQ so Each micro services put logs on queue and Zipkin server read logs from queues.

8.	Spring Cloud Sleuth –
Spring Cloud Sleuth adds two types of IDs to your logging, one called a trace ID and the other called a span ID. The span ID represents a basic unit of work, for example sending an HTTP request. Within that file add the property spring.application.name and set it to whatever you would like to call your application.
It is used to generate the trace id, span id and add this information to the service calls in the headers and MDC, so that It can be used by tools like Zipkin and ELK etc. to store, index and process log files. As it is from spring cloud family, once added to the CLASSPATH, it automatically integrated to the common communication channels like –
•	requests made with the RestTemplate etc.
•	requests that pass through a Netflix Zuul microproxy
•	HTTP headers received at Spring MVC controllers
•	requests over messaging technologies like Apache Kafka or RabbitMQ etc.

9.	Fault Tolerance with Hystrix-
Hystrix, an open-source library developed by Netflix, lets you deal with issues with latency and fault-tolerance in complex, distributed systems.
The Hystrix framework library helps to control the interaction between services by providing fault tolerance and latency tolerance. It improves overall resilience of the system by isolating the failing services and stopping the cascading effect of failures.
You can enable Hystrix framework by annotation @EnableHystix.
Add the fallback method by using command - @HystrixCommand(fallbackMethod=”NameOfMethodUsedInCaseOfFallBack”)
