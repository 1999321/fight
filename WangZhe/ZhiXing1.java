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
    	   *ս������
         */
    	   System.out.println("������ս���Ĵ�Сn*m");
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
    	   System.out.println("�췽����");
    	   int n;
    	   /**
    	    * ����������
    	    */
    	   
    	   int weizhi1;
    	   int weizhi2;
    	   n=in.nextInt();
    	   int m;
    	   System.out.println("��������");
    	   m=in.nextInt();
    	   zc.Renwu(n, m);
    	   int g=0;
    	   System.out.println("������췽����");
    	   RenWu[] hong=new RenWu[n];
    	   for(int i=0;i<n;i++) {
    		   hong[i]=new RenWu();
    		   hong[i].set00();
    	   }
    	   zc.maxhp=hong[0].hp;
    	   zc.maxkp=hong[0].kp;
    	   for(int i=0;i<n;i++) {
    		   System.out.println("λ��i��j");
    		   weizhi1=in.nextInt();
    		   weizhi2=in.nextInt();
    		   hong[i].set3(weizhi1, weizhi2);
    		   System.out.println("����");
    		   String name=new String();
    		   name=in.next();
    		   hong[i].setname(name);
    		   for(int j=0;j<2;j++) {
    		   int[] jineng=new int[8];
    		   jineng[0]=1;
    		   jineng[1]=1;
    		   System.out.println("�������ͣ�1��ʾ�������ͣ�2��ʾ��Ѫ����");
    		   jineng[2]=in.nextInt();
    		   System.out.println("����ϵ��");
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
    	  System.out.println("�������������ԣ�");
    	   RenWu[] lan=new RenWu[m];
    	   for(int i=0;i<m;i++) {
    		   lan[i]=new RenWu();
    		   lan[i].set01();
    	   }
    	   for(int i=0;i<m;i++) {
    		   System.out.println("λ��i��j");
    		   weizhi1=in.nextInt();
    		   weizhi2=in.nextInt();
    		   lan[i].set3(weizhi1, weizhi2);
    		   System.out.println("����");
    		   String name=new String();
    		   name=in.next();
    		   lan[i].setname(name);
    		   for(int j=0;j<2;j++) {
    		   int[] jineng=new int[8];
    		   jineng[0]=1;
    		   jineng[1]=1;
    		   System.out.println("�������ͣ�1��ʾ�������ͣ�2��ʾ��Ѫ����");
    		   jineng[2]=in.nextInt();
    		   System.out.println("����ϵ��");
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
    	    *�������
    	    */
    	  System.out.println("������520��ʼ�غ�ս��");
    	  int flag=in.nextInt();
    	  for(;flag==520;) {
          for(int i2=0;i2<m+n;i2++){
        	  int weizhio,weizhit;
        	  if(i2<n) {
        		  System.out.println("����Ӣ��"+hong[i2].name+"�������ͣ�");
        		  weizhio=hong[i2].weizhi1;
        		  weizhit=hong[i2].weizhi2;
        	  }
            	   
        	  else {
        		   System.out.println("����Ӣ��"+lan[i2-n].name+"�������ͣ�");
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
            		  System.out.println("�����뼼�ܶ���");
            		  String name1=new String();
            		  System.out.println("�������鿴�������꣬�밴-1������0��");
            		  int k2=in.nextInt();
            		  if(k2==-1)
            			  zc.check();
            		  System.out.println("�������������꣺");
            		  int weizhio1=in.nextInt();
            		  int weizhit1=in.nextInt();
            		  zc.zhixingjineng2(weizhio, weizhit, weizhio1, weizhit1,1);
            	   }
           } 
          zc.jiesuan();
          System.out.println("������520��ʼ�غ�ս��");
          flag=in.nextInt();
    }
    	   in.close();
       }
}
