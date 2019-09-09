package com.view.pane;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.shape.Box;

public class MinePanel extends Group {

	public MinePanel() {
		super();
		init();
	}

	private void init() {

		Box box = new Box(30, 30, 30);
		box.setRotationAxis(new Point3D(0.0, 1.0, 0.0));
		box.setRotate(30.0);

		super.getChildren().add(box);

	}
}