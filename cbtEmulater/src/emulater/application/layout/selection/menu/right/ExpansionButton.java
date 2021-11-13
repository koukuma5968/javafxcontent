package emulater.application.layout.selection.menu.right;

import emulater.application.names.chapter.TopMenuItemNames;
import emulater.event.EventListener;
import emulater.event.expansion.ExpansionButtonEventHandler;
import javafx.scene.control.Button;

public class ExpansionButton extends Button {

    public ExpansionButton() {
        super();
        super.getStyleClass().add(TopMenuItemNames.EXPANS.getStyleName());
        init();
    }

    private void init() {

        super.setText("□");

        for (EventListener event : ExpansionButtonEventHandler.values()) {
            super.addEventHandler(event.getEventType(), event.getEvent());
        }
    }
}
