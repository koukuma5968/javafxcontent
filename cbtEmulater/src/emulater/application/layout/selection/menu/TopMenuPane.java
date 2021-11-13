package emulater.application.layout.selection.menu;

import emulater.application.layout.selection.menu.center.EmulaterTitle;
import emulater.application.layout.selection.menu.right.RigthPane;
import emulater.application.names.chapter.TopMenuItemNames;
import emulater.event.EventListener;
import emulater.event.stage.TopMenuEventHandler;
import emulater.util.EmulaterLogger;
import javafx.scene.layout.BorderPane;

public class TopMenuPane extends BorderPane {

    private final String cName = TopMenuPane.class.getSimpleName();

    public TopMenuPane() {
        super();
        EmulaterLogger.info(cName, "TOPメニュー初期化");
        super.getStyleClass().add(TopMenuItemNames.MENU.getStyleName());
        init();
    }

    private void init() {

        super.setRight(new RigthPane());
        super.setLeft(new EmulaterTitle());

        for (EventListener event : TopMenuEventHandler.values()) {
            super.addEventHandler(event.getEventType(), event.getEvent());
        }
    }

}
