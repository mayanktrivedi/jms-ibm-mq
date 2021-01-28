# jms-ibm-mq
IBM MQ

IBM MQ Link - https://developer.ibm.com/articles/mq-downloads/

 
Setting UP Queue Manager - 
Install Docker
1. Get the MQ in Docker image - “docker pull ibmcom/mq:latest”
2. create docker volume docker volume create mq1data
3. Run the container from the image - docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume mq1data:/mnt/mqm --publish 1414:1414 --publish 9443:9443 --detach --env MQ_APP_PASSWORD=MT9090 ibmcom/mq:latest
4. You can display the MQ installation and data paths by running the dspmqver command (display MQ version) in your command line interface.
5. You can display your running queue managers using the dspmq command.
6. Inside the container, the MQ installation on RHEL has the following objects:
     Queue manager QM1
     Queue DEV.QUEUE.1
     Channel: DEV.APP.SVRCONN
     Listener: DEV.LISTENER.TCP on port 1414
7. Put and get a message using the MQ Console - https://localhost:9443/ibmmq/console/ 
8. Now, let’s use the MQ Console to put and get a message on the queue:
9. Log in to the MQ Console with user “admin” and password “passw0rd”.
10. Click Manage below the Home icon. A page will open showing your QM1 resources
11. In the QM1 resources page, click DEV.QUEUE.1.
12. In the Local queue DEV.QUEUE.1 page, click the Create button to put a message on the queue.
13. In the message interace, type Hello World in the Application data field. Then, click Create.
14. View your message as a row on the queue page.
16. Click the three vertical dots in the top right corner to open the options menu.
17. Click Clear messages to clear the queue.

Example in JAVA
 
USE TLS in MQ

Create SSL
1. openssl req -newkey rsa:2048 -nodes -keyout key.key -x509 -days 365 -out key.crt
2. openssl req -newkey rsa:2048 -nodes -keyout mqkey.key -x509 -days 365 -out mqkey.crt
3. openssl x509 -text -noout -in mqkey.crt
4. Create JMS key Store -  keytool -keystore clientkey.jks -storetype jks -importcert -file key.crt -alias server-certificate
5. Password- mqclientpass
6. Run container with the certificates - docker run --name mqtls --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume /Users/mayanktrivedi/IBMMQ/:/etc/mqm/pki/keys/mykey --publish 1414:1414 --publish 9443:9443 --detach --env MQ_APP_PASSWORD=passw0rd ibmcom/mq:latest
7. Verify that security has been enabled - runmqsc QM1, DISPLAY CHANNEL(DEV.APP.SVRCONN)
 



