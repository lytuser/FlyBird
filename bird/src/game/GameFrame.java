package game;

import javax.swing.JFrame;
/**
 * 创建游戏窗体，程序入口
 * @author lyt
 *
 */
public class GameFrame extends JFrame {
	public GameFrame() {
		// TODO Auto-generated constructor stub
		setSize(600, 740);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("飞扬的小鸟");
		setIconImage(Tool.getImg("0"));
	}

	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		GamePlane plane = new GamePlane();
		frame.add(plane);
		frame.setVisible(true);
		// plane.start();
	}

}
