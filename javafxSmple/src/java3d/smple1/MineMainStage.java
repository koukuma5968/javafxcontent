package com.view.stage;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class MineMainStage extends Application {

	Scene scene = null;
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

//		MinePanel pane = new MinePanel();
//
//		Scene scene = new Scene(pane, 300, 300);
//		scene.setFill(Color.BLACK);
//
//		// 透視投影カメラを設定する
//		PerspectiveCamera camera = new PerspectiveCamera(true);
//		scene.setCamera(camera);
//
//		// カメラの位置を (0, 0, -100) にする
//		camera.setTranslateZ(-100.0);
//
//		primaryStage.setScene(scene);
//		primaryStage.show();

		scene = make3dScene();
		primaryStage.setScene(scene);
		setEvent();
		//タイトルの表示
		primaryStage.show();
	}

	private Scene make3dScene(){
		Group group = new Group();
		//箱を置く
		Box box = new Box( 5 , 5 , 5 );
		Box box2 = new Box( 5 , 5 , 5 );
		Box box3 = new Box( 5 , 5 , 5 );
		Box box4 = new Box( 5 , 5 , 5 );

		Box box5 = new Box( 5 , 5 , 5 );
		Box box6 = new Box( 5 , 5 , 5 );
		Box box7 = new Box( 5 , 5 , 5 );
		Box box8 = new Box( 5 , 5 , 5 );

		Translate boxtranslate = new Translate(10,10,10);
		box.getTransforms().add( boxtranslate );
		box.setTranslateX(0);
		box2.getTransforms().add( boxtranslate );
		box2.setTranslateX(+5);
		box3.getTransforms().add( boxtranslate );
		box3.setTranslateY(+5);
		box4.getTransforms().add( boxtranslate );
		box4.setTranslateY(+5);
		box4.setTranslateX(+5);

		box5.getTransforms().add( boxtranslate );
		box5.setTranslateX(0);
		box5.setTranslateZ(+5);
		box6.getTransforms().add( boxtranslate );
		box6.setTranslateX(+5);
		box6.setTranslateZ(+5);
		box7.getTransforms().add( boxtranslate );
		box7.setTranslateY(+5);
		box7.setTranslateZ(+5);
		box8.getTransforms().add( boxtranslate );
		box8.setTranslateY(+5);
		box8.setTranslateX(+5);
		box8.setTranslateZ(+5);

		group.getChildren().addAll( box, box2, box3, box4, box5, box6, box7, box8  );

		// カメラを置く
		PerspectiveCamera camera = new PerspectiveCamera( true );
		//方向と位置
		cameratranslate = new Translate(0,0,-50);
		camerarotateX = new Rotate( cx , new Point3D( 1 , 0 , 0 ) );
		camerarotateY = new Rotate( cy , new Point3D( 0 , 1 , 0 ) );
		camera.getTransforms().add( boxtranslate );
		camera.getTransforms().add( camerarotateX );
		camera.getTransforms().add( camerarotateY );
		camera.getTransforms().add( cameratranslate );
		//視界の角度
		camera.setFieldOfView( 30. );
		//可視距離の設定
		//camera.setFarClip( 50. );
		//camera.setNearClip( 45. );
		group.getChildren().add( camera );
		//点光源を置く
		LightBase light = new PointLight();
		light.setTranslateX(  30.0 );
		light.setTranslateY( -30.0 );
		light.setTranslateZ( -30.0 );
		group.getChildren().add( light );
		//Sceneの設定
		Scene s3d = new Scene(group, 600, 600);
		s3d.setFill(Color.ALICEBLUE);
		s3d.setCamera( camera );

		return s3d;
	}


	private void setEvent(){
		//マウスがドラッグされたときのイベント
		scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//ボタン楽天 が左なら視線変更
				if( event.getButton() == MouseButton.PRIMARY ){
					//カメラの視線方向をマウスドラッグに合わせて変更する
					double vddx = event.getSceneY() - MineMainStage.this.cdx ;
					MineMainStage.this.cx = MineMainStage.this.cx - vddx/2. ;
					double vddy = event.getSceneX() - MineMainStage.this.cdy ;
					MineMainStage.this.cy = MineMainStage.this.cy + vddy/2. ;
					MineMainStage.camerarotateX.setAngle( cx );
					MineMainStage.camerarotateY.setAngle( cy );
					MineMainStage.this.cdx = event.getSceneY();
					MineMainStage.this.cdy = event.getSceneX();
				}
			}
		});
		//マウスが押されたときのイベント
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				MineMainStage.this.cdx = event.getSceneY();
				MineMainStage.this.cdy = event.getSceneX();
			}
		});
		//マウスホイールが回った時のイベント
		scene.setOnScroll( new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				MineMainStage.this.cl = MineMainStage.this.cl + event.getDeltaY()/2. ;
				MineMainStage.this.cameratranslate.setZ( MineMainStage.this.cl );
			}
		});
		return;
	}

}
