package java3d.smple1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Java3DSmpleStage extends Application {

    //カメラ方向操作用
    //カメラと視点間の距離
    double cl =-50.;
    //カメラのXY角度
    double cx =45.;
    double cdx =0.;
    double cy =45.;
    double cdy =0.;
    static Rotate camerarotateX = null;
    static Rotate camerarotateY = null;
    Translate cameratranslate = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Java3DGrupPanel group = new Java3DGrupPanel();

        Scene s3d = new Scene(group, 600, 600);
        s3d.setFill(Color.ALICEBLUE);
        s3d.setCamera( camera );

        primaryStage.setScene(scene);
        setEvent();
        //タイトルの表示
        primaryStage.show();
    }

    private void setEvent(){
        //マウスがドラッグされたときのイベント
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //ボタン楽天 が左なら視線変更
                if( event.getButton() == MouseButton.PRIMARY ){
                    //カメラの視線方向をマウスドラッグに合わせて変更する
                    double vddx = event.getSceneY() - Java3DSmpleStage.this.cdx ;
                    Java3DSmpleStage.this.cx = Java3DSmpleStage.this.cx - vddx/2. ;
                    double vddy = event.getSceneX() - Java3DSmpleStage.this.cdy ;
                    Java3DSmpleStage.this.cy = Java3DSmpleStage.this.cy + vddy/2. ;
                    Java3DSmpleStage.camerarotateX.setAngle( cx );
                    Java3DSmpleStage.camerarotateY.setAngle( cy );
                    Java3DSmpleStage.this.cdx = event.getSceneY();
                    Java3DSmpleStage.this.cdy = event.getSceneX();
                }
            }
        });
        //マウスが押されたときのイベント
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Java3DSmpleStage.this.cdx = event.getSceneY();
                Java3DSmpleStage.this.cdy = event.getSceneX();
            }
        });
        //マウスホイールが回った時のイベント
        scene.setOnScroll( new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                Java3DSmpleStage.this.cl = Java3DSmpleStage.this.cl + event.getDeltaY()/2. ;
                Java3DSmpleStage.this.cameratranslate.setZ( Java3DSmpleStage.this.cl );
            }
        });
        return;
    }

}
