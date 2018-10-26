package WangZhe;
import java.util.Scanner;
//import java.awt.*;
//import java.applet.Applet;
//import java.awt.Graphics;
//import java.util.*;
public class ZhiXing1 {
       public static void main(String[]args) {
    	   Scanner in=new Scanner(System.in);
    	   int chang,kuang;
    	   /**
    	   *战场设置
         */
    	   System.out.println("请输入战场的大小n*m");
    	   chang=in.nextInt();
    	   kuang=in.nextInt();
    	   ZhangChang zc=new ZhangChang(chang,kuang);
    	   for(int i=1;i<kuang/2-1;i++) {
    		   zc.p[chang/2-1][i].name="1";
    	   }
    	   for(int i=1;i<kuang/2-1;i++) {
    		   zc.p[chang/2+1][i].name="1";
    	   }
    	   for(int i=kuang-2;i>=kuang/2+1;i--) {
    		   zc.p[chang/2-1][i].name="1";
    	   }
    	   for(int i=kuang-2;i>=kuang/2+1;i--) {
    		   zc.p[chang/2+1][i].name="1";
    	   }

    	   for(int i=1;i<chang/2-1;i++) {
    		   zc.p[i][kuang/2-1].name="1";
    	   }
    	   
    	   for(int i=1;i<chang/2-1;i++) {
    		   zc.p[i][kuang/2+1].name="1";
    	   }
    	   for(int i=chang-2;i>=chang/2+1;i--) {
    		   zc.p[i][kuang/2+1].name="1";
    	   }
    	   for(int i=chang-2;i>=chang/2+1;i--) {
    		   zc.p[i][kuang/2-1].name="1";
    	   }
    	   zc.display();
    	   System.out.println("红方人数");
    	   int n;
    	   /**
    	    * 红蓝方设置
    	    */
    	   
    	   int weizhi1;
    	   int weizhi2;
    	   n=in.nextInt();
    	   int m;
    	   System.out.println("蓝方人数");
    	   m=in.nextInt();
    	   zc.Renwu(n, m);
    	   int g=0;
    	   System.out.println("请输入红方属性");
    	   RenWu[] hong=new RenWu[n];
    	   for(int i=0;i<n;i++) {
    		   hong[i]=new RenWu();
    		   hong[i].set00();
    	   }
    	   zc.maxhp=hong[0].hp;
    	   zc.maxkp=hong[0].kp;
    	   for(int i=0;i<n;i++) {
    		   System.out.println("位置i，j");
    		   weizhi1=in.nextInt();
    		   weizhi2=in.nextInt();
    		   hong[i].set3(weizhi1, weizhi2);
    		   System.out.println("名字");
    		   String name=new String();
    		   name=in.next();
    		   hong[i].setname(name);
    		   for(int j=0;j<2;j++) {
    		   int[] jineng=new int[8];
    		   jineng[0]=1;
    		   jineng[1]=1;
    		   System.out.println("技能类型（1表示攻击类型，2表示回血类型");
    		   jineng[2]=in.nextInt();
    		   System.out.println("技能系数");
    		   jineng[3]=in.nextInt();
    		   jineng[4]=1;
    		   jineng[5]=1;
    		   jineng[6]=4;
    		   jineng[7]=2;
    		   if(j==0) {
    			     hong[i].set1(jineng);
    		   }
    		   else
    		   hong[i].set2(jineng);
    		   } 
    		    zc.p[weizhi1][weizhi2]=hong[i];
    		    zc.a1[g]=weizhi1;
    		    zc.a2[g]=weizhi2;
    		    g++;
    	   }
    	  System.out.println("请输入蓝方属性：");
    	   RenWu[] lan=new RenWu[m];
    	   for(int i=0;i<m;i++) {
    		   lan[i]=new RenWu();
    		   lan[i].set01();
    	   }
    	   for(int i=0;i<m;i++) {
    		   System.out.println("位置i，j");
    		   weizhi1=in.nextInt();
    		   weizhi2=in.nextInt();
    		   lan[i].set3(weizhi1, weizhi2);
    		   System.out.println("名字");
    		   String name=new String();
    		   name=in.next();
    		   lan[i].setname(name);
    		   for(int j=0;j<2;j++) {
    		   int[] jineng=new int[8];
    		   jineng[0]=1;
    		   jineng[1]=1;
    		   System.out.println("技能类型（1表示攻击类型，2表示回血类型");
    		   jineng[2]=in.nextInt();
    		   System.out.println("技能系数");
    		   jineng[3]=in.nextInt();
    		   jineng[4]=1;
    		   jineng[5]=1;
    		   jineng[6]=4;
    		   jineng[7]=2;
    		   if(j==0) {
    			    lan[i].set1(jineng);
    		   }
    		   else
    		   lan[i].set2(jineng);
    		   }
    		   zc.p[weizhi1][weizhi2]=lan[i];
    		   zc.a1[g]=weizhi1;
   		       zc.a2[g]=weizhi2;
   		       g++;
    	   }
    	   zc.display();
    	   /**
    	    *输入命令；
    	    */
    	  System.out.println("请输入520开始回合战斗");
    	  int flag=in.nextInt();
    	  for(;flag==520;) {
          for(int i2=0;i2<m+n;i2++){
        	  int weizhio,weizhit;
        	  if(i2<n) {
        		  System.out.println("输入英雄"+hong[i2].name+"操作类型：");
        		  weizhio=hong[i2].weizhi1;
        		  weizhit=hong[i2].weizhi2;
        	  }
            	   
        	  else {
        		   System.out.println("输入英雄"+lan[i2-n].name+"操作类型：");
        		   weizhio=lan[i2-n].weizhi1;
         		  weizhit=lan[i2-n].weizhi2;
        	  }
            	   int cz=in.nextInt();
            	   if(cz==1) {
            		   int dir=in.nextInt();
            		   int bushu=in.nextInt();
            		   for(int i=0;i<bushu;i++) {
            			 int flag1=  zc.buxing(dir, weizhio, weizhit);
            			 if(flag1==-1)
            				 break;
            		   }
            	   }
            	   else if(cz==2) {
            		  System.out.println("请输入技能对象：");
            		  String name1=new String();
            		  System.out.println("如果你想查看对象坐标，请按-1，否则按0：");
            		  int k2=in.nextInt();
            		  if(k2==-1)
            			  zc.check();
            		  System.out.println("请输入对象的坐标：");
            		  int weizhio1=in.nextInt();
            		  int weizhit1=in.nextInt();
            		  zc.zhixingjineng2(weizhio, weizhit, weizhio1, weizhit1,1);
            	   }
           } 
          zc.jiesuan();
          System.out.println("请输入520开始回合战斗");
          flag=in.nextInt();
    }
    	   in.close();
       }
}
