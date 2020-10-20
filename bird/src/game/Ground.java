package game;

import java.awt.image.BufferedImage;
/**
 * 地板元素类
 * @author lyt
 *
 */
public class Ground extends Image{
		
	public Ground() {
		image=Tool.getImg("ground");
		w=image.getWidth();
		h=image.getHeight();
		x=0;
		y=740-166;
	}
	@Override
	void move() {
		if (x<-200) {
			x=0;
		}
		x--;
	}
	


}
