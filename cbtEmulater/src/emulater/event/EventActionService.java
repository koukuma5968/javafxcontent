package emulater.event;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public abstract class EventActionService extends Service<Boolean> {

    private Event event;

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                if (event instanceof KeyEvent) {

                    switch(((KeyEvent) event).getCode()) {
                        case ENTER :
                            doEvent();
                            break;
                        default:
                            break;
                    }
                } else if (event instanceof MouseEvent) {
                    MouseEvent mouse = (MouseEvent)event;
                    if (mouse.getButton() == MouseButton.PRIMARY && mouse.getClickCount() <= 2) {
                        doEvent();
                    }
                }

                return Boolean.TRUE;

            }

        };
    }

    protected abstract void doEvent();

}
