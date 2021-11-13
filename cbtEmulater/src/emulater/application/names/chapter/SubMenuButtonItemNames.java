package emulater.application.names.chapter;

import emulater.event.EventListener;
import emulater.event.exam.ExaminationEventHandler;
import emulater.event.storage.ReadStorageEventHandler;

public enum SubMenuButtonItemNames {

    STORAGE("storage-sub-button", "試験成績", ReadStorageEventHandler.values()),
    EXAM("exam-sub-button", "試験一覧", ExaminationEventHandler.values());
//    NARRIVALS("arrivals-sub-button", "新着問題", ArrivalsEventHandler.values());

    private SubMenuButtonItemNames(String styleName, String text, EventListener[] handler) {
        this.styleName = styleName;
        this.text = text;
        this.handler = handler;
    }

    private String styleName;

    private String text;

    private EventListener[] handler;

    public String getStyleName() {
        return styleName;
    }

    public String getText() {
        return text;
    }

    public EventListener[] getHandler() {
        return  handler;
    }

}