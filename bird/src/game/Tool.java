package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 获取图片缓冲流的工具类
 * @author lyt
 *
 */
public class Tool {
	static BufferedImage image=null;//图片缓冲区对象
	public static BufferedImage getImg(String path) {
		try {
			//将图片读取到内存中
			image=ImageIO.read(Tool.class.getResource("../img/"+path+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
		
	}

}
