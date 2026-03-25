package io.cosmos.core;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Gateway {

    private final ApplicationEventPublisher eventPublisher;

    public void send(Command command){
        System.out.println("send Command : [ " + command + " ]");
        this.eventPublisher.publishEvent(command);
    }

    public void publish(Event event){
        System.out.println("publish Event : [ " + event + "]") ;
        this.eventPublisher.publishEvent(event);
    }
}
