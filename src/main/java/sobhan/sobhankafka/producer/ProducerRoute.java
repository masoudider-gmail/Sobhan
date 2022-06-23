package sobhan.sobhankafka.producer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        Random random = new Random();

        from("timer://simple?period=1000&delay=1000")
                .setBody(exchange -> random.nextInt(100))
                .to("kafka:test?brokers=localhost:9092");
    }
}
