package emulater.event;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

public interface EventListener {

    public EventType<? extends Event> getEventType();

    public EventHandler<Event> getEvent();
}
