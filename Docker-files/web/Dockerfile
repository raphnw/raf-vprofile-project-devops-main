# Nginx reverse proxy in front of the app (Tomcat on vproapp:8080)
FROM nginx:1.30-alpine
LABEL project="raf-vprofile" author="Raf"

RUN rm /etc/nginx/conf.d/default.conf
COPY nginvproapp.conf /etc/nginx/conf.d/vproapp.conf
