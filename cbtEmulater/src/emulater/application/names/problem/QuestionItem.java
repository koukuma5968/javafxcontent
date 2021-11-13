package emulater.application.names.problem;

public enum QuestionItem {

    VIEW_TITLE_INI("question-view-init"),
    VIEW_TITLE("question-view"),
    QUEST_NUM("question-number"),
    QUEST_BOX("question-box"),
    QUEST_BORDER("question-border"),
    STATEMENT("question-statement"),
    CODE("question-code"),
    CODE_FIELD("question-code-field"),
    ANS("answer"),
    ANS_BOX("answer-box"),
    SOLUTION("solution"),
    SOLUTION_CHECK("solution-check"),
    EXPLAN_BOX("explanatory-box"),
    EXPLAN_TEXT("explanatory-text"),
    START_BOX("start-box"),
    START_TEXT("start-text"),
    RUN_BOX("run_box"),
    IMAGE("question-image"),
    RUN_BUTTON("run-button");

    private QuestionItem(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
