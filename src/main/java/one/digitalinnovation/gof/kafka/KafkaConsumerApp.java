package one.digitalinnovation.gof.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerApp {
    @KafkaListener(topics = "clientes", groupId = "cliente-consumidor")
    public void consume(String mensagem) {
        // Lidar com a mensagem recebida do Kafka aqui
        System.out.println("Mensagem consumida Kafka: " + mensagem);
    }
}
