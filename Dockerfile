FROM gradle:jdk11 AS builder
WORKDIR /home/root/build/
COPY . .
RUN gradle build -x test

FROM openjdk:11-jre-slim
WORKDIR /home/root/voting-app-worker/
COPY --from=builder /home/root/build/build/libs/working-app-worker-0.0.1-SNAPSHOT.jar /home/root/voting-app-worker/
EXPOSE 8088
ENTRYPOINT ["java","-jar","working-app-worker-0.0.1-SNAPSHOT.jar"]
