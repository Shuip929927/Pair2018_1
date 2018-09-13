

import java.util.Scanner;

public class MathExam6242 {
	static int n,grade;
	static String N ="-n";
	static String GRADE = "-grade";
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str;
		if(!checkInput(args)) {
			str = scan.nextLine();
			String[] input=str.split(" ");
			while(!checkInput(input)) {
				str = scan.nextLine();
				input=str.split(" ");
			}	
		}
		System.out.println(n +"        "+grade);
	}


	private static boolean checkInput(String[] args) {
		int positionN = 0;									//如果值为1 代表先输入为 -n  
																		//为3 代表-n 后输入 ，为0代表 -n没有输入
		int positionGrade = 0;							//同上
		
		if(args[0].equals(N)) {									//如果第一个输入为-n
			positionN = 1;												//则 postionN = 1，即 n = args[1] 
			if(args[2].equals(GRADE)) {					//如果第三个输入为-grade 则 positionGrade=3
				positionGrade=3;									
//				System.out.println("N is ok");
			} //else{
//				System.out.println("Grade error");
//			}
		}
		if(args[0].equals(GRADE)) {
			positionGrade = 1;
			if(args[2].equals(N)) {
				positionN=3;
//				System.out.println("Grade is ok");
			} //else{
//				System.out.println("N error");
//			}
		}
		if(positionGrade * positionN == 3) {
			try {
				n = Integer.parseInt(args[positionN]);
				grade = Integer.parseInt(args[positionGrade]);
			} catch(Exception e){
				System.err.println("数字输入有误！请重新输入（题数n取值1~100，年级grade取值1~4）格式：-n 100 -grade 4：");
				return false;
			}
			if(n <=0 || n>100 ) {
				System.out.println("题目输入不合理！请重新输入（题数n取值1~100，年级grade取值1~4）格式：-n 100 -grade 4：");
				return false;
			}
			if(grade <= 0 || grade >4) {
				System.out.println("年级输入不合理！请重新输入（题数n取值1~100，年级grade取值1~4）格式：-n 100 -grade 4：");
				return false;
			}
			return true;
		}
		System.out.println("符号输入有误！");
		return false;
	}
}
