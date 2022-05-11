package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import screens.BaseScreen;
import screens.ScreenA;
import screens.ScreenB;

public class MainWindow implements Initializable {

	@FXML
	private Canvas canvas;

	public static int SCREEN = 0;
	public static int FRAMES = 0;
	private GraphicsContext gc;

	private ArrayList<BaseScreen> screens;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		screens = new ArrayList<>();

		screens.add(new ScreenA(canvas));
		screens.add(new ScreenB(canvas));

		gc = canvas.getGraphicsContext2D(); // it allows to draw on screen
		canvas.setFocusTraversable(true);

		new Thread(() -> {
			while (true) {
				paint();
				pause(50);
				FRAMES++;
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
		//Lambda 1
		canvas.setOnMouseClicked(e -> {
			screens.get(SCREEN).onClick(e);
		});

		//Lambda 2
		canvas.setOnKeyPressed(e -> {
			screens.get(SCREEN).onKey(e);
		});
		
		canvas.setOnKeyReleased(e->{
			//screens.get(SCREEN).onKeyReleased(e);
		});
	}

	private void paint() {
		screens.get(SCREEN).paint();
	}

}
