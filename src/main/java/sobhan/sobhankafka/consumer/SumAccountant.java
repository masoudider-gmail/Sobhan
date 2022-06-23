package sobhan.sobhankafka.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SumAccountant extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://simple?period=60000&delay=60000")
                .setBody(exchange -> {
                            int sum = ListCollector.list.stream().mapToInt(integer -> integer).sum();
                            ListCollector.list.clear();
                            return sum;
                        }
                )
                .log(" Sum Result is: ${body}");
    }
}
