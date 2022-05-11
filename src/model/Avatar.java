package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import control.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Avatar {
	
	private Canvas canvas;
	private GraphicsContext gc;
	private int x;
	private int y;
	private Image img;
	
	public Avatar(Canvas canvas, int x, int y) {
		this.canvas = canvas;
		gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
		
		File file = new File("src/img/mario.png");
		System.out.println(file.getAbsolutePath());
		try {
			img = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paint() {
		gc.drawImage(img, x,y);
		
		if(MainWindow.FRAMES % 100 == 0) {
			x=0;
			y=0;
		}
		
	}

	public void moveXBy(int i) {
		// TODO Auto-generated method stub
		this.x += i;
	}

	public void moveYBy(int i) {
		// TODO Auto-generated method stub
		this.y += i;
	}
}
