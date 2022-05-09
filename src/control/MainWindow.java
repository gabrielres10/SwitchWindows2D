package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import screens.ScreenA;
import screens.ScreenB;

public class MainWindow implements Initializable{
	
	@FXML
	private Canvas canvas;
	
	public static int SCREEN = 0;
	private GraphicsContext gc;
	private ScreenA screenA;
	private ScreenB screenB;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		gc = canvas.getGraphicsContext2D();
		canvas.setFocusTraversable(true);
		screenA = new ScreenA(canvas);
		screenB = new ScreenB(canvas);                                      
		
		
		new Thread(() ->{
			while(true) {
				paint();
				pause(50);
			}
		}).start();
		
		initEvents();
	}
	
	private void pause(int i) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initEvents() {
		canvas.setOnMouseClicked(e ->{
			switch(SCREEN) {
			case 0:
				screenA.onClick(e);
				break;
			case 1:
				screenB.onClick(e);
				break;
			}
		});
		
		canvas.setOnKeyPressed(e ->{
			switch(SCREEN) {
			case 0:
				screenA.onKey(e);
				break;
			case 1:
				screenB.onKey(e);
				break;
			}
		});
	}
	
	
	
	
	private void paint() {
		switch(SCREEN) {
		case 0:
			screenA.paint();
		break;
		
		case 1:
			screenB.paint();
			break;
		}
	}

}
