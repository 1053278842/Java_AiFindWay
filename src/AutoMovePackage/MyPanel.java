package AutoMovePackage;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	public final static int size=50;//��λ
	public MyPanel() {
		// TODO Auto-generated constructor stub
	}
	//���ݸ�����λ������λ��
	public MyPanel(int x,int y) {
		setBounds(x*size, y*size, size, size);
	}
	public MyPanel(FangKuaiPosition fk){
		this.setBounds(fk.getX() * size, fk.getY() * size, size, size);
	}
}
