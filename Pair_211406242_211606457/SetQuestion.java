package com.java6242.homewrok3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SetQuestion{
	static String[] SYMBOL = new String[]{"+","-","x","\\"};
	List<String> list = new ArrayList<String>();
	@SuppressWarnings("unused")
	public  SetQuestion(int n , int grade) {
		// TODO Auto-generated constructor stub
		int t,flag;
		int[] num = new int[5]; 
		String[] symbol = new String[10];
		Random ra = new Random();
		switch(grade) {
		case 1:											//一年级出题功能
			for(int i = 0;i<n;i++) {
				String str = null;
				num[0]=ra.nextInt(21);
				num[1]=ra.nextInt(21);
				symbol[0]=SYMBOL[ra.nextInt(2)];
				if(symbol[0] == "-") {
					if(num[1]>num[0]) {
						t=num[0];
						num[0]=num[1];
						num[1]=t;
					}
				}
				str ="("+Integer.toString(i+1)+") "+ Integer.toString(num[0]).concat(" "+symbol[0]+" ").concat(Integer.toString(num[1]).concat(" = "));
				list.add(str);
			}
			break;
		case 2:										//二年级出题功能
			for(int i = 0;i<n;i++) {
				String str = null;
				num[0]=ra.nextInt(21);
				num[1]=ra.nextInt(21);
				
				symbol[0]=SYMBOL[ra.nextInt(4)];
				if(symbol[0] == "-") {
					if(num[1]>num[0]) {
						t=num[0];
						num[0]=num[1];
						num[1]=t;
					}
				}
				if(symbol[0] == "\\") {
					while(num[1] == 0) {
						num[1]=ra.nextInt(101);
					}
					if (num[0]%num[1]!=0) {
						num[0]=num[0]-num[0]%num[1];
					}
				}
				str ="("+Integer.toString(i+1)+") "+ Integer.toString(num[0]).concat(" "+symbol[0]+" ").concat(Integer.toString(num[1]).concat(" = "));
				list.add(str);
			}
			break;
		case 3:									//三年级出题功能
			int positionLeft = 0;
			int positionRight =2;
			boolean isBarcket;
			for(int i = 0;i<n;i++) {
				String str = null;
				boolean isDivide = false;
				flag=ra.nextInt(3);
				if(flag == 0) {										//3个数的计算
					isBarcket = ra.nextBoolean();
					for(int j =0;j<2;j++) {
						symbol[j]=SYMBOL[ra.nextInt(4)];
						if(symbol[j] == "\\") {	
							isDivide=true;
						}
					}
					if(isDivide) {					//判断是否涉及除法
						num[0]=ra.nextInt(19)+1;
						num[1]=(ra.nextInt(19)+1)*num[0];
						num[2]=(ra.nextInt(19)+1)*num[0];
						for(int a =0;a<3;a++) {
							for(int b =a+1;b<2;b++) {
								if(num[a]>num[b]) {
									t=num[a];
									num[a]=num[b];
									num[b]=t;
									}
								}
							}
						} else {
							num[0]=ra.nextInt(101);
							num[1]=ra.nextInt(101);
							num[2]=ra.nextInt(101);
					}
					if(isBarcket) {					//判断是否添加括号
						positionLeft = 0;
						positionRight = positionLeft+2;	
						symbol[positionLeft] =symbol[positionLeft].concat(" (");
						symbol[positionRight]=")";
						str = "("+Integer.toString(i+1)+") "+Integer.toString(num[2]).concat(" "+symbol[0]+" ");
						str = str.concat(Integer.toString(num[1]));
						str = str.concat(" "+symbol[1]+" ").concat(Integer.toString(num[0]));
						str = str.concat(" "+symbol[2]+" ");
					} else {
								str = "("+Integer.toString(i+1)+") "+Integer.toString(num[2]).concat(" "+symbol[0]+" ");
								str = str.concat(Integer.toString(num[1]));
								str = str.concat(" "+symbol[1]+" ");
								str = str.concat(Integer.toString(num[0]));
							}
					list.add(str);
				}
			
				if(flag == 1) {						//4个数的计算
					isBarcket = ra.nextBoolean();
					for(int j =0;j<3;j++) {
						symbol[j]=SYMBOL[ra.nextInt(4)];
						if(symbol[j] == "\\") {
							isDivide=true;
						}
					}
					if(isDivide) {					//判断是否含有除法
						num[0]=ra.nextInt(19)+1;
						num[1]=(ra.nextInt(4)+1)*num[0];
						num[2]=(ra.nextInt(4)+1)*num[0];
						num[3]=(ra.nextInt(4)+1)*num[0];
						for(int a =0;a<4;a++) {
							for(int b =a+1;b<3;b++) {
								if(num[a]>num[b]) {
									t=num[a];
									num[a]=num[b];
									num[b]=t;
									}
								}
							}	
						}	else {
							num[0]=ra.nextInt(101);
							num[1]=ra.nextInt(101);
							num[2]=ra.nextInt(101);
							num[3]=ra.nextInt(101);
					}
					if(isBarcket) {				//判断是否添加括号
						positionLeft = ra.nextInt(2);
						if(positionLeft == 1) {
							symbol[positionLeft] =symbol[positionLeft].concat(" (");
							symbol[3]=")";
							str = "("+Integer.toString(i+1)+") "+Integer.toString(num[3]).concat(" "+symbol[0]+" ");
							str = str.concat(Integer.toString(num[2])).concat(" "+symbol[1]+" ");
							str = str.concat(Integer.toString(num[1])).concat(" "+symbol[2]+" ");
							str = str.concat(Integer.toString(num[0])).concat(" "+symbol[3]+" ");
						}	else {
							positionRight = positionLeft+2;	
							symbol[positionLeft] =symbol[positionLeft].concat(" (");
							symbol[positionRight]=") ".concat(symbol[positionRight]);
							
							str = "("+Integer.toString(i+1)+") "+Integer.toString(num[3]).concat(" "+symbol[0]+" ");
							str = str.concat(Integer.toString(num[2])).concat(" "+symbol[1]+" ");
							str = str.concat(Integer.toString(num[1])).concat(" "+symbol[2]+" ");
							str = str.concat(Integer.toString(num[0])).concat(" ");
							}
						} else {
							str= "("+Integer.toString(i+1)+") "+Integer.toString(num[3]).concat(" "+symbol[0]+" ");
							str = str.concat(Integer.toString(num[1]));
							str = str.concat(" "+symbol[1]+" ");
							str = str.concat(Integer.toString(num[2]));
							str = str.concat(" "+symbol[2]+" ");
							str = str.concat(Integer.toString(num[3])).concat(" ");
							
						}
						list.add(str);
						}
				
				if(flag ==2) {					//5个数的计算
					isBarcket = ra.nextBoolean();
					for(int j =0;j<4;j++) {
						symbol[j]=SYMBOL[ra.nextInt(4)];
						if(symbol[j] == "\\") {
							isDivide=true;
						}
					}
					if(isDivide) {				//判断是否含有除法
						num[0]=ra.nextInt(19)+1;
						num[1]=(ra.nextInt(19)+1)*num[0];
						num[2]=(ra.nextInt(19)+1)*num[0];
						num[3]=(ra.nextInt(19)+1)*num[0];
						num[4]=(ra.nextInt(19)+1)*num[0];
						for(int a =0;a<5;a++) {
							for(int b = a+1;b<4;b++) {
								if(num[a]>num[b]) {
									t=num[a];
									num[a]=num[b];
									num[b]=t;
								}
							}
						}
						}	else {
							num[0]=ra.nextInt(101);
							num[1]=ra.nextInt(101);
							num[2]=ra.nextInt(101);
							num[3]=ra.nextInt(101);
							num[4]=ra.nextInt(101);
					}
					if(isBarcket) {			//判断是否添加括号
						positionLeft = ra.nextInt(3);
						if(positionLeft == 2) {
							symbol[4]=")";
							symbol[positionLeft] =symbol[positionLeft].concat(" (");
							str = "("+Integer.toString(i+1)+") "+Integer.toString(num[4]).concat(" "+symbol[0]+" ");
							str = str.concat(Integer.toString(num[3])).concat(" "+symbol[1]+" ");
							str = str.concat(Integer.toString(num[2])).concat(" "+symbol[2]+" ");
							str = str.concat(Integer.toString(num[1])).concat(" "+symbol[3]+" ");
							str = str.concat(Integer.toString(num[0])).concat(" "+symbol[4]+" ");
						}	else {
							positionRight = positionLeft+2;	
							symbol[positionLeft] =symbol[positionLeft].concat(" (");
							symbol[positionRight]=") ".concat(symbol[positionRight]);
							str = "("+Integer.toString(i+1)+") "+Integer.toString(num[4]).concat(" "+symbol[0]+" ");
							str = str.concat(Integer.toString(num[3])).concat(" "+symbol[1]+" ");
							str = str.concat(Integer.toString(num[2])).concat(" "+symbol[2]+" ");
							str = str.concat(Integer.toString(num[1])).concat(" "+symbol[3]+" ");
							str = str.concat(Integer.toString(num[0])).concat(" ");
						}
					}else {
						str = "("+Integer.toString(i+1)+") "+Integer.toString(num[4]).concat(" "+symbol[0]+" ");
						str = str.concat(Integer.toString(num[3])).concat(" "+symbol[1]+" ");
						str =str.concat(Integer.toString(num[2])).concat(" "+symbol[2]+" ");
						str =str.concat(Integer.toString(num[1])).concat(" "+symbol[3]+" ");
						str = str.concat(Integer.toString(num[0])).concat(" ");
					}
					list.add(str);
					}
				}
			break;
			}
		}
	
	public void output() {
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static void main(String[] args)  {
		SetQuestion sq = new SetQuestion(10,3);
		sq.output();
	}
}
