package WangZhe;
/**
 * 
 * @author 黎兆
 *技能设置，包括对技能数组的赋值；
 */
public class Skill {
	 //public int[] Bjineng;
	 public int[] Zjineng;
	 void set(int a,int b,int c){
		 //Bjineng=new int[4];
		 Zjineng=new int[8];
		 Zjineng[6]=a;
		 Zjineng[5]=b;
		 Zjineng[7]=c;
	 }
    /* void setbeidong(int a,int b,int c,int d){
    	 Bjineng[0]=a;
    	 Bjineng[1]=b;
    	 Bjineng[2]=c;
    	 Bjineng[3]=d;
     }*/
     void setzhudong(int a,int b,int c,int d,int e){
    	 Zjineng[0]=a;
    	 Zjineng[1]=b;
    	 Zjineng[2]=c;
    	 Zjineng[3]=d;
    	 Zjineng[4]=e;
     }
     void ZhiXingBJiNeng(){
    	 
     }
}