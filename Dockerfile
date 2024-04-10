FROM openjdk:17

WORKDIR /app

COPY . /app

RUN sudo apt install maven

EXPOSE 8081