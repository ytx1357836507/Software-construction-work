package test5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public  class Count {
	static int[][] equation = new int[50][3];  //用1，0代替加减号存放两个加数及符号
	static char[] sign = new char[50];  //存放符号的数组
	static int[] operand = new int[50];  //存放算式结果
	static int i;
	static Set<Object> set = new HashSet<Object>();  //声明集合函数
	public static void printHeader() {
		System.out.println("----------------------------------------");
		System.out.println("--程序输出50道100以内的加减法算式的习题---");
		System.out.println("-每次运行程序可到到一套50道题的习题及答案-");
	}
	public static void generateEquations() {
		Random twonum = new Random();
		for( i=0; i<50; i++){		
			int random = twonum.nextInt(2);  //生成0，1
			equation[i][1] = random;
			if(equation[i][1] == 0){
			    sign[i] = '+';  //0代表+
			}
			if(equation[i][1] == 1){
				sign[i] = '-';  //1代表-
			}	
		}
	}

	public static void	printExercise() {
		System.out.println("----------------------------------------");
		Random left = new Random();
		Random right = new Random();
		int flag = 0;
		for( i=0; i<50; i++){
			equation[i][0] = left.nextInt(100);  //产生100以内随机数
			equation[i][2] = right.nextInt(100);
			if(equation[i][0] + equation[i][2] <= 100 && equation[i][0] - equation[i][2] >=0)  //判断相加小于100，相减大于0
			{
				set.add(equation[i][0] + sign[i] + equation[i][2]);  //利用集合函数消除重复算式
				if(set.size() == i+1) {
					flag++;
					System.out.print(i+1+":"+"\t"+equation[i][0]+sign[i]+equation[i][2]+"="+"\t\t");
					if(flag == 5) {  //算式大于5时换行
						System.out.println();
						flag = 0;
					}
					if(sign[i] == '+')
						operand[i] = equation[i][0] + equation[i][2];  //存放结果
					if(sign[i] == '-')
						operand[i] = equation[i][0] - equation[i][2];
				}
				else i--;
			}
			else
				i--;
		}
	}
	public static void printCalculations() {
		System.out.println("----------------------------------------");
		int flag = 0;
		for( i = 0; i<50; i++){
			flag++;
			System.out.print(i+1+":"+"\t"+operand[i]+"\t\t");
			if(flag == 5) {  //结果大于5时换行
				System.out.println();
				flag = 0;
			}
		}
	}
	
	/*
	 姓名：杨天星
	 项目：生产50道100内加减算式
	 */
	public static void main(String[] args) {
		printHeader();
		generateEquations();
		printExercise();
		printCalculations();
	}
}

	
	

	
	

	
