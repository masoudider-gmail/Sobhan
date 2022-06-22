package sobhan.sobhankafka.producer;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class MyProducer implements CommandLineRunner {
    @Autowired
    private ProducerTemplate template;

    private Random random = new Random();

    @Override
    public void run(String... args) throws Exception {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                template.sendBody("direct:a", random.nextInt(100));

            }
        };

        new Timer().scheduleAtFixedRate(task, 1000, 10000);

    }
}
