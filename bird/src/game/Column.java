package game;

import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * 柱子元素类
 * @author lyt
 *
 */
public class Column extends Image{
;
	int distance;
	int gap=73;
	Random random=new Random();
	
	public Column(int i) {
		// TODO Auto-generated constructor stub
		image=Tool.getImg("column");
		w=image.getWidth()/2;
		h=image.getHeight();
		distance=300;
		x=500+distance*(i-1);
		y=-50-random.nextInt(h/3);
	}
	@Override
	void move() {
		if (x<-w) {
			x=600;
			y=-50-random.nextInt(h/3);
		}
		x--;
	}
}
