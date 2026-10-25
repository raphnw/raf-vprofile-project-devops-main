FROM openjdk:11 AS BUILD_IMAGE
RUN apt update && apt install maven -y
RUN git clone https://github.com/raphnw/raf-vprofile-project.git
#RUN git clone --branch docker https://github.com/raphnw/raf-vprofile-project.git
#RUN cd raf-vprofile-project && mvn install 
RUN cd raf-vprofile-project && git checkout docker && mvn install 

FROM tomcat:9-jre11
LABEL "Project"="raf-vprofile"
LABEL "Author"="Raf"
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=BUILD_IMAGE raf-vprofile-project/target/vprofile-v2.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
#WORKDIR /usr/local/tomcat/
#VOLUME /usr/local/tomcat/webapps
