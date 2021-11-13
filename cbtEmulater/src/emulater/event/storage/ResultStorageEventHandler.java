package emulater.event.storage;

import emulater.event.EventListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public enum ResultStorageEventHandler implements EventListener {

    KEY_PRES(KeyEvent.KEY_PRESSED),
    MOUSE_CLICK(MouseEvent.MOUSE_CLICKED);

    private ResultStorageEventHandler(EventType<? extends Event> type) {
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
            ResultStorageEventAction action = new ResultStorageEventAction();
            action.setEvent(event);
            action.start();
        });

        return handler;
    }
}
