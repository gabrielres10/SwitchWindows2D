package screens;

import control.MainWindow;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Avatar;

public class ScreenA extends BaseScreen{
	//Objects on the scene
	private Avatar avatar;

	public ScreenA(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
		avatar = new Avatar(canvas,250,250);
	}

	@Override
	public void paint() {
		// TODO Auto-generated method stub
		gc.setFill(Color.BLACK);
		gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
		avatar.paint();
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		MainWindow.SCREEN = (MainWindow.SCREEN + 1)%2;
	}

	@Override
	public void onKey(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getCode().equals(KeyCode.A)){
			avatar.moveXBy(-2);
		}else if(e.getCode().equals(KeyCode.W)) {
			avatar.moveYBy(-2);
		}else if(e.getCode().equals(KeyCode.S)) {
			avatar.moveYBy(2);
		}else if(e.getCode().equals(KeyCode.D)) {
			avatar.moveXBy(2);
		}
	}


}
