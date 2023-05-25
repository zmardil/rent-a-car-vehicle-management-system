package me.zmardil.notificationservice;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
class NotificationController {

    @MessageMapping("/application")
    @SendTo("/all/notifications")
    public Notification send(Notification notification) throws Exception {
        return Notification.builder().message("from notification server").build();
    }

    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload Notification notification) {
        simpMessage
    }

}
