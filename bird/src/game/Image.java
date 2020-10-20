package game;

import java.awt.image.BufferedImage;
/**
 * 游戏元素的抽象类
 * @author lyt
 *
 */
public abstract class Image {
	
	BufferedImage image;
	int x;
	int y;
	int w;
	int h;
	abstract void move();
}
