import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import javax.imageio.IIOException;

public class Procuder {
    public static void main(String[] args) throws Exception {
        ConnectionFactory conn=new ConnectionFactory();
        conn.setHost("localhost");
        conn.setPort(5670);
        conn.setUsername("peter");
        conn.setPassword("820517");
        conn.setVirtualHost("/");
        Connection connection=conn.newConnection();
        Channel channel=connection.createChannel();
        for (int i=0;i<5;i++){
            String msg="Hello,World";
            channel.basicPublish("","test1001",null,msg.getBytes());
        }
        channel.close();
        connection.close();
    }
}
