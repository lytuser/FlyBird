package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * 
 * 游戏窗体面板，放置游戏背景和游戏元素
 * @author lyt
 *
 */
public class GamePlane extends JPanel{
	
	BufferedImage bg;
	Ground ground;
	Column column1;
	Column column2;
	Bird bird;
	boolean start;
	boolean end;
	int score;
	BufferedImage startImage;
	BufferedImage endImage;
		
	public GamePlane() {
		
		//初始化游戏元素对象		
		bg=Tool.getImg("bg");
		ground=new Ground();
		column1=new Column(1);
		column2=new Column(2);
		bird=new Bird();
		start=false;
		end=false;
		score=0;
		
		//为鼠标添加监听事件
		MouseAdapter adapter=new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				//鼠标点击时有三种情况,一种是游戏还没开始，一种是游戏结束，还有一种是正在游戏
				if (!start) {
					start=true;
					start();
				}else if (end) {
					ground=new Ground();
					column1=new Column(1);
					column2=new Column(2);
					bird=new Bird();
					start=false;
					end=false;
					score=0;
					repaint();//重新画上
				}else {
					bird.moveUp();
				}
			}
		};
		this.addMouseListener(adapter);
	}

	//游戏开始这是另外一个线程，与鼠标监听事件同步进行
	public void start() {
		//MyThread myThread=new MyThread();
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					//游戏元素移动
					ground.move();
					column1.move();
					column2.move();
					bird.fly();
					bird.move();
					//判断是鸟是否撞击
					boolean boo1=bird.hit();
					boolean boo2=bird.hit(column1);
					boolean boo3=bird.hit(column2);				
					if (boo3||boo1||boo2) {
						end=true;
						return;
					}
				    //判断得分
					if (bird.x==column1.x+column1.w||bird.x==column2.x+column2.w) {
						score++;				
					}
					try {
						//不能太快，否则没效果
						Thread.sleep(30);
						repaint();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						}
			}
		});
		thread.start();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//给面板画上游戏元素
		g.drawImage(bg,0,0,null);
        g.drawImage(column1.image, column1.x, column1.y, column1.w, column1.h, null);
        g.drawImage(column2.image, column2.x, column2.y, column2.w, column2.h, null);
        g.drawImage(ground.image,ground.x,ground.y,null);
        g.drawImage(bird.image,bird.x,bird.y,null);
        
       //画上分数
        Font font=new Font("黑体",200,30);
        setFont(font);
        g.drawString("分数："+score, 30, 50);
        
        //根据游戏状态，画开始和结束的图片
        if (!start) {
			startImage=Tool.getImg("start");
			g.drawImage(startImage,50,0,null);
		}
		if (end) {
			endImage=Tool.getImg("gameover");
			g.drawImage(endImage,50,0,null);
		}

	}

}
