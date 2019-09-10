package java3d.smple1;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class Java3DGrupPanel extends Group {

    public Java3DGrupPanel() {
        super();
        init();
    }

    private void init(){

        // 正方形を指定数作成(個数, x辺, y辺 ,z辺)
        Box[] makeBox = makeSquare(10, 5, 5, 5);

        Translate boxtranslate = setTranslate(makeBox, 10, 5, 5, 5, 3, 3);

        super.getChildren().addAll(makeBox);

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
        super.getChildren().add( camera );
        //点光源を置く
        LightBase light = new PointLight();
        light.setTranslateX(  30.0 );
        light.setTranslateY( -30.0 );
        light.setTranslateZ( -30.0 );
        super.getChildren().add( light );

    }

    private Box[] makeSquare(int count, int x, int y, int z) {

        Box[] retBox = new Box[count];
        for (Box b : retBox) {
            b = new Box(x, y, z);
        }

        return retBox;
    }

    private Translate setTranslate(Box[] makeBox, int count, int x, int y, int z, int col, int row) {

        Translate boxtranslate = new Translate(col*x, row*y ,10);

        int countX = 0;
        int countY = 0;
        int countZ = 0;
        for (Box b : makeBox) {
            b.getTransforms().add( boxtranslate );
            if (col > countX) {
                b.setTranslateX(x * countX);
                countX++;
            } else {
                countX = 0;

                if (row > countY) {
                    b.setTranslateX(+5);
                }
            }
        }
        mekaBox[1].getTransforms().add( boxtranslate );
        mekaBox[1].setTranslateX(+5);
        mekaBox[2].getTransforms().add( boxtranslate );
        mekaBox[2].setTranslateY(+5);
        mekaBox[3].getTransforms().add( boxtranslate );
        mekaBox[3].setTranslateY(+5);
        mekaBox[3].setTranslateX(+5);

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

    }

}