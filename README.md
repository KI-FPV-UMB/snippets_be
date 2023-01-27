# snippets_be


* Compile application and all modules: **mvn clean install**
* Start RabbitMQ server: **docker-compose up**
* Start one rest-publisher instance
* Start multiple instances of consumer application. Note: Multiple instances can be started only from the command line. Us command line arguments to specify consumer name.
* Send <POST> message to http://localhost:8080/publish to publish message to all consumers
* Send <POST> message to http://localhost:8080/send-to-worker to publish message to one consumer (worker) at a time
* **See**: [RabbitMQ](https://www.rabbitmq.com/getstarted.html) for more code examples and messaging patterns
* **See**: [Enterprise Integration Patterns](https://www.enterpriseintegrationpatterns.com/patterns/messaging/index.html) for advanced messaging patterns
