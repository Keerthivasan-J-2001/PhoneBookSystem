FROM openjdk

MAINTAINER keerthivasan

WORKDIR /app 

COPY target/phonebook.jar /app/phonebook.jar

ENTRYPOINT ["java", "-jar", "phonebook.jar"]