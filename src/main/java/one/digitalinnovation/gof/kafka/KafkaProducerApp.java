package one.digitalinnovation.gof.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerApp {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String mensagem) {
        // Enviar a mensagem para o Kafka
        kafkaTemplate.send("clientes-produced", mensagem);
    }
}