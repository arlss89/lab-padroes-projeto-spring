# Explorando Padrões de Projetos na Prática com Java

The project that originated this one has been simplified.

The creation of an API with class relationships had already been done by the instructor professor. In my project, I simplified the origin in an attempt to improve event communication. For example, I added a messaging service with KAFKA, where when a new client is added, the system will notify the KAFKA server that runs in a docker container associated with the project, along with instructions to run it.

Therefore, whenever a new client is added, the system will notify the Kafka server, and interested parties will be able to become aware of the event.

To run the application, follow steps:

1 - Go to src/main/resources/docker/ and follow steps to install and run the docker file

2 - Run the main application. 

3 - You can do requests using browser or, to see message,  you can do a post with any software that allows make requests to APIs, you will see the kafka response.
