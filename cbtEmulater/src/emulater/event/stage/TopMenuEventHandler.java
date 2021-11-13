package emulater.event.stage;

import emulater.event.EventListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public enum TopMenuEventHandler implements EventListener {

    MOUSE_CLICK(MouseEvent.MOUSE_CLICKED) {

        @Override
        public EventHandler<Event> getEvent() {

            EventHandler<Event> handler = (event-> {
                fullScreenAction(event);
            });

            return handler;
        }

    },
    MOUSE_DRAG(MouseEvent.MOUSE_DRAGGED) {

        @Override
        public EventHandler<Event> getEvent() {

            EventHandler<Event> handler = (event-> {
                moveAction(event);
            });

            return handler;
        }

    },
    MOUSE_PRES(MouseEvent.MOUSE_PRESSED) {

        @Override
        public EventHandler<Event> getEvent() {

            EventHandler<Event> handler = (event-> {
                moveAction(event);
            });

            return handler;
        }

    };

    TopMenuEventHandler(EventType<? extends Event> type) {
        this.type = type;
    }

    private EventType<? extends Event> type;

    @Override
    public EventType<? extends Event> getEventType() {
        return this.type;
    }

    protected void moveAction(Event event) {

        StageMoveEventAction action = new StageMoveEventAction();
        action.setEvent(event);
        action.start();
    }

    protected void fullScreenAction(Event event) {

        FullScreenEventAction action = new FullScreenEventAction();
        action.setEvent(event);
        action.start();
    }
}
