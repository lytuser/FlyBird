package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
/**
 * 鸟元素类
 * @author lyt
 *
 */
public class Bird extends Image {

	double v;
	double s;
	double t;
	double g;
	List<BufferedImage> list;

	public Bird() {
		image = Tool.getImg("0");
		w = image.getWidth();
		h = image.getHeight();
		x = 300;
		y = 370;
		v = 3;
		t = 0.2;
		s = 0;
		g = 5;
		list = new ArrayList<BufferedImage>();
		for (int i = 0; i < 8; i++) {
			list.add(Tool.getImg(Integer.toString(i)));
		}
	}

	//鸟飞动，通过不停切换图片
	int index = 0;
	public void fly() {
		image = list.get(index % 7);
		index++;
	}
	//鸟下落运动
	public void move() {
		s = v * t;
		y = y - (int) s;
		double v2 = v - g * t;
		v = v2;
	}
	//鸟上升运动
	public void moveUp() {
		v = 20;
	}
	//判断鸟是否和顶部或者地面撞击
	public boolean hit() {
		if (y < 0 || y > 534) {
			return true;
		}
		return false;
	}
	//判断鸟是否和柱子撞击
	public boolean hit(Column column) {
		//先判断x方向是否过界，再判断y方向
		if (x > column.x - 56 && x < column.x + column.w) {
			int len = column.y + column.h / 2;
			if (y > len - column.gap && y < len + column.gap - 48) {
				return false;
			}
			return true;
		}
		return false;
	}
}
