### Steps involved to complete the task

1. Development of the application - the selected language is Java and the framework is springboot, this
   selection was made due the features spring boot provides as well as it support variety of enterprise standards.
   Other selection used:
   Build tools - the selected build tool is gradle because gradle use groovy DDL which can help to automate different tasks
   Database selection - the selected database is mysql database which is an opensource powered by MariaDB engine.the mysql 
   DB is containerized and exposes port 3306 to the host

2. Deployment - Containerization technology used is docker which is an open source technology.
   The application is packed as an image which is built from java runtime environment version 11.
   The image can deployed as a single instance or replicated depending on the performance requirements.

3. To start the mysql database use command :
   `docker compose up -d mysql` ,make sure you run this command in the same directory as docker compose file and the DB properties can be 
    altered inside the docker compose file.
4. How to build and deploy the application as a docker container
   1. From the application parent directory, there is a dockerfile which will be used to build the docker image for 
      the application.
   2. Build the docker image by using command `docker compose build` make sure 
      you execute the command in the same directory as docker compose file.
   3. The image name specified in the docker compose file is `bank_x_webservice_uat_v1` and the 
      tag/version is `0.0.1`
   4. To run the image as a container use 
      `docker run -p "909:8585" -e "DB_HOST=host.docker.internal" -e "DB_PORT=3306" bank_x_webservice_uat_v1:0.0.1` <br>
       Where <br> 
       > -p "909:8585" - exposes port 909 in the host network <br>
         -e - used to define different environment variables to be passed/accessed inside container <br>
          DB_HOST - specifies database hostname/IP <br>
          DB_PORT - specifies database port <br>
          Other environment varibales that can be passed are includes in the application.properties located 
          at */src/main/resources/application.properties* 
      
    5. To run the container in the background add the flag `-d` which will run in detached mode
   
      
     