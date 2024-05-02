FROM openjdk:21-ea-24-oracle

WORKDIR /app
COPY target/peliculas.0.0.1.jar app.jar
COPY Wallet_YGZBLJ1A2C1D4QKV /app/oracle_wallet
EXPOSE 8080

CMD [ "java", "jar", "app.jar" ]