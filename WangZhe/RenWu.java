package WangZhe;
/**
 * 
 * @author ����
 * �������ã��������ܣ��������Ի�����ս���е�λ�á�
 *
 */
public class RenWu {
	public String name;
	public int jinbi;
	public float hp;
	public jinbi k;
	public int kp;
	public float hurt;
	public float jinyang;
	public char shuxing;
	Skill[] p=new Skill[2];
	public int weizhi1;
	public int weizhi2;
	void change(){
		//�ı��������ԣ�
	}
	RenWu(){
		name="0";
		jinbi=0;
		hp=30;
		kp=30;
	    jinyang=1.0f;
	    hurt=0.8f*jinyang;
	    p[0]=new Skill();
	    p[1]=new Skill();
	}
	void set00() {
		shuxing='h';
	}
	void set01() {
		shuxing='l';
	}
	void set1(int[] a) {
		p[0].set(a[6], a[5],a[7]);
		p[0].setzhudong(a[0], a[1],a[2],a[3],a[4]);
	}
	void set2(int[] a) {
		p[1].set(a[6], a[5],a[7]);
		p[1].setzhudong(a[0], a[1],a[2],a[3],a[4]);
	}
	void setname(String a) {
		name=a;
	}
	void set3(int a,int b) {
		weizhi1=a;
		weizhi2=b;
	}
}