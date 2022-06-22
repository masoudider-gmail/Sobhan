package sobhan.sobhankafka.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;


@Component
public class ConsumerRoute extends RouteBuilder {

    {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int result = ListCollector.list.stream().mapToInt(integer -> integer).sum();
                ListCollector.list.clear();

                System.out.println("The sum of received numbers: " + result);
            }
        };

        new Timer().scheduleAtFixedRate(task, 60000, 60000);
    }

    @Override
    public void configure() throws Exception {

        from("kafka:test?brokers=localhost:9092")
                .convertBodyTo(ListCollector.class);
    }
}


