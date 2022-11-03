package AutoMovePackage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class BasePanel extends JFrame{
	private static int frameWidth=815;
	private static int frameHeigh=635;
	private static int width=800;
	private static int height=600;
	public static int widthLength = 16;//方块单位的y方向最大值
	public static int heightLength = 12;//方块单位的x方向最大值
	private static int sleepTime=5;
	//
	public static MyPanel cat=new MyPanel(0,0);
	public static MyPanel fish=new MyPanel((int)(Math.random()*widthLength),(int)(Math.random()*heightLength));
	//
	public static BackGroundPanel bgp=new BackGroundPanel();//容器panel,所有方块加入bgp
	//集合
	public static List<FangKuaiPosition> zhangaiList =new ArrayList<FangKuaiPosition>();//不可逾越的障碍物
	public static List<FangKuaiPosition> closeList =new ArrayList<FangKuaiPosition>();//已经走过的路线集合
	public static List<FangKuaiPosition> openList =new ArrayList<FangKuaiPosition>();//需扩散集合
	public BasePanel() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(frameWidth,frameHeigh);
		//起始点
		cat.setBackground(Color.blue);
		fish.setBackground(Color.red);
		//Panel容器
		bgp.setBounds(0, 0, width, height);
		bgp.add(cat);
		bgp.add(fish);
		add(bgp);
		//
		for(FangKuaiPosition fk:zhangaiList) {
			MyPanel panel = new MyPanel(fk);
			panel.setBackground(Color.gray);
			bgp.add(panel);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		getZhangaiList();
		BasePanel bp=new BasePanel();
		bp.setVisible(true);
		AutoFindWay afw = new AutoFindWay();
		List<FangKuaiPosition> wayList = afw.getWayLine(cat, fish);
		bp.movePanel(wayList);
	}
	//移动
	public void movePanel(List<FangKuaiPosition> wayList) throws InterruptedException{
		if(wayList == null || wayList.size() == 0){
			System.out.println("无法 到达终点 ！");
			return;
		}
		for(int i = wayList.size() - 2; i >= 0; i--){
			FangKuaiPosition fk = wayList.get(i);
			//向上
			while(cat.getY() > fk.getY() * MyPanel.size){
				cat.setBounds(cat.getX(), cat.getY() - 2, MyPanel.size, MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
			//向下
			while(cat.getY() < fk.getY() * MyPanel.size){
				cat.setBounds(cat.getX(), cat.getY() + 2, MyPanel.size, MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
			//向左
			while(cat.getX() > fk.getX() * MyPanel.size){
				cat.setBounds(cat.getX() - 2, cat.getY(), MyPanel.size, MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
			//向右
			while(cat.getX() < fk.getX() * MyPanel.size){
				cat.setBounds(cat.getX() + 2, cat.getY(), MyPanel.size, MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
		}
		System.out.println("寻路结束！");
	}
	//生成障碍物
	public static void getZhangaiList() {
		while(zhangaiList.size()<40) {
			int x=(int)(Math.random()*widthLength);
			int y=(int)(Math.random()*heightLength);
			FangKuaiPosition fk = new FangKuaiPosition(x,y);
			if(zhangaiList.contains(fk) || (cat.getX() == fk.getX()*MyPanel.size && cat.getY() == fk.getY() * MyPanel.size) 
					|| (fish.getX() == fk.getX() * MyPanel.size && fish.getY() == fk.getY() * MyPanel.size)){
				continue;
			}
			zhangaiList.add(fk);
		}
	}
}
