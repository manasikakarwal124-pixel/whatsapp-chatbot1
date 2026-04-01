package com.whatsapp.chatbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private static final Logger logger =
            LoggerFactory.getLogger(WebhookController.class);

    @PostMapping("/webhook")
    public MessageResponse receiveMessage(
            @RequestBody MessageRequest request) {

        String msg = request.getMessage();
        logger.info("Received message: {}", msg);

        String reply;
        if ("Hi".equalsIgnoreCase(msg)) {
            reply = "Hello";
        } else if ("Bye".equalsIgnoreCase(msg)) {
            reply = "Goodbye";
        } else {
            reply = "I don't understand that message.";
        }

        logger.info("Sending reply: {}", reply);
        return new MessageResponse(reply);
    }
}