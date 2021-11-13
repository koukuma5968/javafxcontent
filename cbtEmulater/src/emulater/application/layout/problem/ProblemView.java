package emulater.application.layout.problem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import emulater.application.bean.CheckAnswerBean;
import emulater.application.bean.StorageAnswerBean;
import emulater.application.bean.StorageBean;
import emulater.application.layout.grad.center.CheckAnswerPane;
import emulater.application.layout.problem.bottom.NextPreviousBox;
import emulater.application.layout.problem.bottom.StartLabelBox;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.application.layout.problem.top.CertificationName;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.layout.problem.top.TimerPane;
import emulater.application.layout.selection.chapter.center.exam.ExecutionBox;
import emulater.application.names.problem.ProblemItem;
import emulater.application.names.problem.QuestionItem;
import emulater.util.EmulaterLogger;
import emulater.util.FileUtil;
import emulater.xml.problem.Problem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ProblemView extends BorderPane {

    private final String cName = ProblemView.class.getSimpleName();
    private List<Map<String, Pane>> problemViewList = new ArrayList<Map<String, Pane>>();
    private StorageBean storage = null;
    private String timelimit = null;
    private int position = -1;
    private final String qKey = "question";
    private final String npKey = "nextprevious";

    public ProblemView() {
        super();
        EmulaterLogger.info(cName, "試験画面初期化");
        super.getStyleClass().add(ProblemItem.VIEW_TITLE.getStyleName());
    }

    public void setLayout(ExecutionBox exe) {

        EmulaterLogger.info(cName, "試験開始画面セット");
        this.timelimit = exe.getTime();
        ProblemMenu menu = new ProblemMenu();
        menu.setMenu(exe);

        super.setTop(menu);

        initProblem(exe);

        QuestionPane que = new QuestionPane(QuestionItem.VIEW_TITLE_INI);
        que.initLayout(exe.getExplanatory());

        super.setCenter(que);

        StartLabelBox startBox = new StartLabelBox();
        startBox.setRunBox();

        super.setBottom(startBox);
    }

    private void initProblem(ExecutionBox exe) {

        EmulaterLogger.info(cName, "試験問題セット");
        Path failePath = Paths.get(exe.getPath());
        File files = failePath.toFile().getAbsoluteFile();

        List<Problem> problemList = new ArrayList<Problem>();

        for (File f : files.listFiles()) {
            problemList.add((Problem) FileUtil.readProblemFile(Problem.class, f.getPath()));
        }
        Collections.shuffle(problemList);

        int count = 0;

        Iterator<Problem> it = problemList.iterator();

        while (it.hasNext()) {

            Map<String, Pane> paneMap = new HashMap<String, Pane>();

            Problem problem = it.next();

            QuestionPane que = new QuestionPane(QuestionItem.VIEW_TITLE);
            que.setQuestion(count, problem.getQuestion());

            paneMap.put(this.qKey, que);

            NextPreviousBox npBox = new NextPreviousBox();
            npBox.setNextPrevious(count, problemList.size());

            paneMap.put(this.npKey, npBox);

            count++;

            problemViewList.add(paneMap);
        }
    }

    public void setGrading() {

        EmulaterLogger.info(cName, "試験結果セット");
        CheckAnswerPane answer = new CheckAnswerPane();
        answer.setAnswer(getAnswerBeanList());

        AnchorPane anc = new AnchorPane();
        AnchorPane.setTopAnchor(answer, 0d);
        AnchorPane.setLeftAnchor(answer, 0d);
        AnchorPane.setRightAnchor(answer, 0d);
        AnchorPane.setBottomAnchor(answer, 10d);
        anc.getChildren().add(answer);

        super.setCenter(anc);

        super.setBottom(null);

        storage = new StorageBean();
        storage.setDay(LocalDateTime.now());

        ProblemMenu menu = (ProblemMenu) super.getTop();
        CertificationName certName = (CertificationName) menu.getChildren().get(0);
        TimerPane timer = (TimerPane) menu.getChildren().get(1);

        storage.setName(((Label) certName.getChildren().get(1)).getText());

        storage.setTime(ChronoUnit.MINUTES.between(timer.getTimer(), LocalTime.MIN.plusMinutes(Long.parseLong(this.timelimit))) + "分");

        ObservableList<CheckAnswerBean> beanList = getAnswerBeanList();
        int anscount = beanList.filtered(bean -> "〇".equals(bean.getCorrection())).size();

        storage.setResult((anscount * 100 / beanList.size()) + " %");

        storage.setAnsBeans(getStorageAnsBean());

    }

    public StorageBean getStorage() {
        return storage;
    }

    public ObservableList<CheckAnswerBean> getAnswerBeanList() {

        ObservableList<CheckAnswerBean> beanList = FXCollections.observableArrayList();

        problemViewList.forEach(paneMap -> {

            QuestionPane que = (QuestionPane) paneMap.get(this.qKey);
            beanList.add(que.getCheckAnswer());

        });

        return beanList;
    }

    public ArrayList<StorageAnswerBean> getStorageAnsBean() {

        ArrayList<StorageAnswerBean> ansBeans = new ArrayList<StorageAnswerBean>();

        problemViewList.forEach(paneMap -> {

            QuestionPane quePane = (QuestionPane) paneMap.get(this.qKey);
            CheckAnswerBean ansBean = quePane.getCheckAnswer();

            StorageAnswerBean storageBean = new StorageAnswerBean();
            storageBean.setCorrection(ansBean.getCorrection());
            storageBean.setNumber(ansBean.getNumber());
            storageBean.setSolution(ansBean.getSolution());
            storageBean.setUserSel(ansBean.getUserSel());
            storageBean.setQueBean(quePane.getQuestion());

            ansBeans.add(storageBean);

        });

        return ansBeans;
    }

    public QuestionPane getTargetQuestion(String targetNum) {

        Stream<Map<String, Pane>> stream = problemViewList.stream().filter(paneMap -> {
            QuestionPane que = (QuestionPane) paneMap.get(this.qKey);
            String num = ((Label) que.getTop()).getText();
            return targetNum.equals(num);
        });

        return (QuestionPane) stream.findFirst().get().get(this.qKey);
    }

    public void setNext() {
        setProblem(++this.position);
    }

    public void setPrevious() {
        setProblem(--this.position);
    }

    private void setProblem(int index) {
        super.setCenter(this.problemViewList.get(index).get(this.qKey));
        super.setBottom(this.problemViewList.get(index).get(this.npKey));
    }
}
