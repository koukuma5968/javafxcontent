package emulater.event.review;

import emulater.event.EventListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public enum CloseReviewEventHandler implements EventListener {

    MOUSE_CLICK(MouseEvent.MOUSE_CLICKED);

    private CloseReviewEventHandler(EventType<? extends Event> type) {
        this.type = type;
    }

    private EventType<? extends Event> type;

    @Override
    public EventType<? extends Event> getEventType() {
        return this.type;
    }

    @Override
    public EventHandler<Event> getEvent() {

        EventHandler<Event> handler = (event-> {
            CloseReviewEventAction action = new CloseReviewEventAction();
            action.setEvent(event);
            action.start();
        });

        return handler;
    }

}
