# Build from the repo root:
#   docker build -f Docker-files/app/Dockerfile -t raf-vprofile-app .

# Stage 1: build the WAR with Maven + JDK 11
FROM maven:3.9-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# The cache mount keeps downloaded Maven dependencies between builds
RUN --mount=type=cache,target=/root/.m2 mvn package -B

# Stage 2: run the WAR on Tomcat 9
FROM tomcat:9-jre11
LABEL project="raf-vprofile" author="Raf"
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/target/vprofile-v2.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
