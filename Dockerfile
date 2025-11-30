FROM openjdk:22-jdk
ADD target/product-lister-0.0.1-SNAPSHOT.jar product-lister-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/product-lister-0.0.1.jar"]