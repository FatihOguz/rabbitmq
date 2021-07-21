import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


public class Send {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {


        /**
         * The connection abstracts the socket connection, and takes care of protocol version negotiation and authentication and so on for us.
         * Here we connect to a RabbitMQ node on the local machine - hence the localhost.
         * If we wanted to connect to a node on a different machine we'd simply specify its hostname or IP address here.
         */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

        }






    }
}