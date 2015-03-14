To run the application with Gradle on Windows(on Mac or Linux reverse the slashes):
```
.\gradlew build
```

This will build a jar file of the application.

In the same directory run:
```
java -jar build\libs\MyQueue-master-1.0.jar
```

This will launch a Tomcat server.  Open your browser and go to:

[http://localhost:8080/queueTest](http://localhost:8080/queueTest)

Here you can add and remove items form the Queue
