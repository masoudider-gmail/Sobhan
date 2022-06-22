package sobhan.sobhankafka.producer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:a")
                .to("kafka:test?brokers=localhost:9092");
    }
}
