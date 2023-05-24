package me.zmardil.vehicleservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleProducer {
    private final NewTopic topic;

    private final ObjectMapper mapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(VehicleEvent vehicleEvent, String eventType) {
        log.info("Vehicle event: {}", vehicleEvent);

        String payload;
        try {
            payload = mapper.writeValueAsString(vehicleEvent);
        } catch (JsonProcessingException e) {
            log.error("Error serializing vehicle event to JSON: ", e);
            return;
        }

        Message<String> message = MessageBuilder
                .withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .setHeader("event-type", eventType)
                .build();

        kafkaTemplate.send(message);
    }
}
