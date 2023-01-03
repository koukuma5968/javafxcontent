package problemEditer.stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class EditerStage extends Application {

    Label number = new Label("番号");
    TextField numbertext = new TextField();
    Label statement = new Label("問題");
    TextArea statementtext = new TextArea();
    Label code = new Label("本文");
    TextArea codetext = new TextArea();
    Label selections = new Label("選択肢");
    TextField selectionstext = new TextField();
    Label ans = new Label("回答");
    List<TextArea> ansList = new ArrayList<TextArea>();
    Label solution = new Label("解答");
    TextField solutiontext = new TextField();
    List<String> answerList = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(setScene(stage));
        stage.setWidth(600);
        stage.show();

    }

    private Scene setScene(Stage stage) {

        VBox pane = new VBox();

        Button comit = new Button("保存");
        comit.setOnAction((event) -> {
            export(stage);
        });
        pane.getChildren().add(comit);

        pane.getChildren().add(number);
        pane.getChildren().add(numbertext);

        statementtext.setPrefHeight(100);
        pane.getChildren().add(statement);
        pane.getChildren().add(statementtext);

        codetext.setPrefHeight(300);
        pane.getChildren().add(code);
        pane.getChildren().add(codetext);

        pane.getChildren().add(selections);
        pane.getChildren().add(selectionstext);

        pane.getChildren().add(solution);
        pane.getChildren().add(solutiontext);

        pane.getChildren().add(ans);

        Button add = new Button("回答追加");
        add.setOnAction((event) -> {
            TextArea anstext = new TextArea();
            pane.getChildren().add(anstext);
            ansList.add(anstext);
        });
        pane.getChildren().add(add);

        return new Scene(pane);

    }

    private void nodeCrear() {

        numbertext.setText("");
        statementtext.setText("");
        codetext.setText("");
        selectionstext.setText("");
        ansList = new ArrayList<TextArea>();
        solutiontext.setText("");

    }

    private void export(Stage stage) {

        String filename = "Problem" + numbertext.getText() + ".gz";
        FileChooser choise = new FileChooser();
        choise.setTitle("保存先選択");
        choise.setInitialDirectory(new File("Y:\\CBTエミュレータ\\リリース\\problem"));
        choise.getExtensionFilters().add(new ExtensionFilter("gz",".gz"));
        choise.setInitialFileName(filename);

        File file = choise.showSaveDialog(stage);

        if (file != null) {

            Problem problem = new Problem();
            Question question = new Question();

            int count = 0;
            for (TextArea text : ansList) {
                Answer answer = new Answer();
                answer.setId(RequestCipher.encode(String.valueOf(answerList.get(count++))));
                answer.setValue(RequestCipher.encode(text.getText()));
                question.addAnswer(answer);
            }

            question.setId(RequestCipher.encode(numbertext.getText()));
            question.setSelections(RequestCipher.encode(selectionstext.getText()));
            question.setStatement(RequestCipher.encode(statementtext.getText()));
            question.setCode(RequestCipher.encode(codetext.getText()));
            question.setSolution(RequestCipher.encode(solutiontext.getText()));

            problem.setQuestion(question);

            try {

                JAXBContext con = JAXBContext.newInstance(Problem.class);
                XMLOutputFactory factory = XMLOutputFactory.newInstance();
                Marshaller marshal = con.createMarshaller();
                marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                try (GZIPOutputStream osw = new GZIPOutputStream(new FileOutputStream(file));){
                    XMLStreamWriter writer = factory.createXMLStreamWriter(osw, "UTF-8");
                    marshal.marshal(problem, writer);

                } catch (IOException | XMLStreamException e) {
                    e.printStackTrace();
                }

//                String enc = null;
//                try (BufferedReader br = new BufferedReader(new FileReader(file));) {
//
//                    String line = null;
//                    StringBuffer beff = new StringBuffer();
//                    while ((line = br.readLine()) != null) {
//                        beff.append(line);
//                    }
//
//                    enc = RequestCipher.encode(beff.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                try (GZIPOutputStream osw = new GZIPOutputStream(new FileOutputStream(file));){
//                    osw.write(enc.getBytes());
//                    osw.flush();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            nodeCrear();
            stage.setScene(setScene(stage));
        }
    }

}

