package emulater.event.expansion;

import emulater.event.EventListener;
import emulater.event.stage.FullScreenEventAction;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public enum ExpansionButtonEventHandler implements EventListener {

    MOUSE_CLICK(MouseEvent.MOUSE_CLICKED) {

        @Override
        public EventHandler<Event> getEvent() {

            EventHandler<Event> handler = (event-> {
                FullScreenEventAction action = new FullScreenEventAction();
                action.setEvent(event);
                action.start();
            });
            return handler;
        }

    };

    ExpansionButtonEventHandler(EventType<? extends Event> type) {
        this.type = type;
    }

    private EventType<? extends Event> type;

    @Override
    public EventType<? extends Event> getEventType() {
        return this.type;
    }

}
