package sobhan.sobhankafka.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("kafka:test?brokers=localhost:9092")
                .convertBodyTo(ListCollector.class)
                .log("Received Numbers Are: ${body}");
    }
}


