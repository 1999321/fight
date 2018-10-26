package WangZhe;
import java.util.Scanner;
/**
 * 
 * @author 黎兆
 *战场的设置，以人物类数组作为战场的元素
 */
public class ZhangChang {
	public int n;//战场高
	public int m;//战场宽
	public RenWu[][] p;//人物数组
	public int[] a1;//人物行编号
	public int[] a2;//人物列编号
	public int[] teshu;//特殊区域
	public int n1;//蓝方人数
	public int m1;//红方人数
	public float maxhp;//最大血量
	public int maxkp;//最大蓝条
	int teshulenght;
	ZhangChang(int n1,int m1){
		n=n1;
		m=m1;
		p=new RenWu[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				RenWu i1=new RenWu();
				p[i][j]=i1;
			}
	}
	void Renwu(int n2,int m2) {
		n1=n2;
		m1=m2;
		a1=new int[n1+m1];
		a2=new int[n1+m1];
	}
	void display(){
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++){
				if(p[i][j].name=="0")
				System.out.print(" ");
				else if(p[i][j].name=="1")
					System.out.print("~");
				else 
					System.out.print(p[i][j].name);
			}
		System.out.println(" ");
		}
	}
	void jiesuan(){
		for(int i=0;i<n1+m1;i++) {
			if(p[a1[i]][a2[i]].name=="1"||a1[i]==-1)
				continue;
			silema(a1[i],a2[i],i);
			Scanner in=new Scanner(System.in);
			System.out.println("请输入"+p[a1[i]][a2[i]].name+"被动技能对象的坐标，你可以先输入-1查看角色坐标和基础值：");
			int i1=in.nextInt();
			if(i1==-1) 
				check();
	        int i2=in.nextInt();
	        int i3=in.nextInt();
			zhixingjineng2(a1[i],a2[i],i2,i3,0);
			p[a1[i]][a2[i]].kp++;//teshu(i,j);
			p[a1[i]][a2[i]].jinyang+=5;
			p[a1[i]][a2[i]].hurt=0.8f*p[a1[i]][a2[i]].jinyang;
			if(p[a1[i]][a2[i]].kp>maxkp)
				p[a1[i]][a2[i]].kp=maxkp;
		}
	}
	void silema(int i,int j,int k){
		if(p[i][j].hp<=0)
		{
			RenWu i1=new RenWu();
			i1.name="1";
			p[i][j]=i1;
			a1[k]=-1;
		}
	}
	int buxing(int a,int i,int j) {
		int c=i;
		int d=j;
		if(a==1) 
			i--;
		else if(a==2) 
			j++;
		else if(a==3) 
			i++;
		else if(a==4) 
			j--;
		if(i<0||j<0||i>=n||j>=m||p[i][j].name!="0") 
			return -1;
		else {
			p[i][j]=p[c][d];
			RenWu i1=new RenWu();
			p[c][d]=i1;
			for(int i11=0;i11<n1+m1;i11++)
				if(a1[i11]==c&&a2[i11]==d) {
					a1[i11]=i;
					a1[i11]=i;
					break;
				}
		}
		return 0;
		}
	/*String getname(int a,int b) {
		return p[a][b].name;
	}
	char getfang(int a,int b) {
		return p[a][b].shuxing;
	}
	void zhixingjineng(int a,int i,int j,int b) {
		if(p[i][j].kp>=p[i][j].p[a].Zjineng[6]&&p[i][j].p[a].Zjineng[7]==b)
		{p[i][j].kp-=p[i][j].p[a].Zjineng[6];
		p[i][j].p[a].Zjineng[5]=0;
		p[i][j].p[a].Zjineng[7]=0;
		}
	}
	void zhixingjineng1(int a,int b,int c,int d,int e) {
		for(int i=a-1;i<a+1;i++) {
			if(b-1>=0) 
				this.zhixing(b-1, a, b,d,c);
			else if(b+1<m) {
				this.zhixing(b+1,a,b,d,c);
			}
			this.zhixing(b,a,b,d,c);
		}
		p[a][b].p[e].Zjineng[5]++;
	}
	/*void zhixing(int b,int a,int c,int d,int e) {
		if(a-1>=0)
			if(p[a-1][b].name!="0"&&p[a-1][b].name!="1")
				if(p[a-1][b].shuxing!=p[a][c].shuxing&&d==1)
				p[a-1][b].hp-=p[a][c].hurt*e;
				else if(p[a-1][b].shuxing==p[a][c].shuxing&&d==2)
				p[a-1][b].hp+=p[a][c].hurt*e;
		if(p[a][b].name!="0"&&p[a][b].name!="1")
			if(p[a][b].shuxing!=p[a][c].shuxing&&d==1)
			p[a][b].hp-=p[a][c].hurt*e;
			else if(p[a][b].shuxing==p[a][c].shuxing&&d==2)
			p[a][b].hp+=p[a][c].hurt*e;
		if(a+1<n)
			if(p[a+1][b].name!="0"&&p[a+1][b].name!="1")
				if(p[a+1][b].shuxing!=p[a][c].shuxing&&d==1)
				p[a+1][b].hp-=p[a][c].hurt*e;
				else if(p[a+1][b].shuxing==p[a][c].shuxing&&d==2)
				p[a+1][b].hp+=p[a][c].hurt*e;
	}*/
	void zhixingjineng2(int a,int b,int c,int d,int e) {
		if(a<c)
			for(int i=a+1;i<c;i++)
			{
				String k=p[i][b].name;
				p[i][b].name="!";
				display();
				p[i][b].name=k;
			}
		else 
			for(int i=a-1;i>c;i--)
			{
				String k=p[i][b].name;
				p[i][b].name="!";
				display();
				p[i][b].name=k;
			}
		if(b<d)
			for(int i=b+1;i<d;i++)
			{
				String k=p[c][i].name;
				p[c][i].name="!";
				display();
				p[c][i].name=k;
			}
		else
			for(int i=b-1;i>d;i--)
			{
				String k=p[c][i].name;
				p[c][i].name="!";
				display();
				p[c][i].name=k;
			}
		display();
		if(p[a][b].p[e].Zjineng[2]==1) {
			p[c][d].hp-=p[a][b].hurt*p[a][b].p[e].Zjineng[3];
			System.out.println(p[c][d].name+"受到"+p[a][b].hurt+"伤寒"+",还剩下"+p[c][d].hp+"血量");
		}
			
		else {
			p[c][d].hp+=p[a][b].hurt*p[a][b].p[e].Zjineng[3];
			if(p[c][d].hp>maxhp)
				p[c][d].hp=maxhp;
			System.out.println(p[c][d].name+"受到"+p[a][b].hurt+"回血"+",还剩下"+p[c][d].hp+"血量");
		}
			
	}
	void check() {
		for(int i=0;i<n1+m1;i++) {
			if(p[a1[i]][a2[i]].name=="1"||a1[i]==-1) {
				System.out.println("die");
				continue;
			}
	        System.out.println(p[a1[i]][a2[i]].name+" "+p[a1[i]][a2[i]].hp+" 坐标 "+a1[i]+" "+a2[i]);
		}
	}
}