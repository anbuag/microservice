# microservice 
First we see the what is microservice? micoservice is software architecture, In big application splits a individual services and each services are focused on a single bussinss capable.
If we create a multiole different services that can run different port servers, using microservice we can connect the two service or multiple services.
In this project... 
I create first one service name question service and therefore create Model, Controller, Service, Repository packages. Write all configuration in application.properties file thiss file
contain port number, database url, driver name, username, password and few configuration..then create second service name quiz service and also same packages create in this project.
Then connect this two services with help of eureka server and this server present in the service registry package. All the request shouldn't be directly going to microservices.
They should be going from one api gateway and they should from treaces according to the microservices URL pattern or whatever the other information we can give for that so we will create 
api gate-way and this gateway will ve responsible to travel through th appropriate microservices that we have created.
