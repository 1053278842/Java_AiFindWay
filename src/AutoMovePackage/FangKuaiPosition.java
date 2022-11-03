package AutoMovePackage;

public class FangKuaiPosition {
	public static final int size=50;//��λ
	private int x;
	private int y;
	private int F;//F=G+H
	private int G;//�������ľ���
	private int H;//��Ŀ���ľ���
	private FangKuaiPosition previousFK;//���ڵ�
	
	public FangKuaiPosition() {};
	public FangKuaiPosition(int x,int y) {
		this.x=x;
		this.y=y;
	}
	/*
	 * fk��ǰһ�����飨�������飩
	 */
	public FangKuaiPosition(int x,int y, FangKuaiPosition fk){
		this.x = x;
		this.y = y;
		this.previousFK = fk;
	}
	public FangKuaiPosition(MyPanel myPpanel){//��ת��
		this.x = myPpanel.getX() / MyPanel.size;
		this.y = myPpanel.getY() / MyPanel.size;
	}
	//��дequals�Ƚ�	ֻ��x,y��ͬʱ�ŵ�ͬ
	public boolean equals(Object obj) {
		if(((FangKuaiPosition)obj).getX() == this.x && ((FangKuaiPosition)obj).getY() == this.y){
			return true;
		}else{
			return false;
		}
	}
	public int getF() {
		return F;
	}
	public void setF(int f) {
		F = f;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		G = g;
	}
	public int getH() {
		return H;
	}
	public void setH(int h) {
		H = h;
	}
	public FangKuaiPosition getPreviousFK() {
		return previousFK;
	}
	public void setPreviousFK(FangKuaiPosition previousFK) {
		this.previousFK = previousFK;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
}
