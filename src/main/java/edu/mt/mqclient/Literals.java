package edu.mt.mqclient;

public final class Literals {
    public static final String HOST = "localhost"; // Host name or IP address
    public static final int PORT = 1414; // Listener port for your queue manager
    public static final String CHANNEL = "DEV.APP.SVRCONN"; // Channel name
    public static final String QMGR = "QM1"; // Queue manager name
    public static final String APP_USER = "app"; // User name that application uses to connect to MQ
    public static final String APP_PASSWORD = "passw0rd"; // Password that the application uses to connect to MQ
    public static final String QUEUE_NAME = "DEV.QUEUE.1"; // Queue that the application uses to put and get messages to and from
}
