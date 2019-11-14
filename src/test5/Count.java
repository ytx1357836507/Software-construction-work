package test5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public  class Count {
	static int[][] equation = new int[50][3];  //��1��0����Ӽ��Ŵ����������������
	static char[] sign = new char[50];  //��ŷ��ŵ�����
	static int[] operand = new int[50];  //�����ʽ���
	static int i;
	static Set<Object> set = new HashSet<Object>();  //�������Ϻ���
	public static void printHeader() {
		System.out.println("----------------------------------------");
		System.out.println("--�������50��100���ڵļӼ�����ʽ��ϰ��---");
		System.out.println("-ÿ�����г���ɵ���һ��50�����ϰ�⼰��-");
	}
	public static void generateEquations() {
		Random twonum = new Random();
		for( i=0; i<50; i++){		
			int random = twonum.nextInt(2);  //����0��1
			equation[i][1] = random;
			if(equation[i][1] == 0){
			    sign[i] = '+';  //0����+
			}
			if(equation[i][1] == 1){
				sign[i] = '-';  //1����-
			}	
		}
	}

	public static void	printExercise() {
		System.out.println("----------------------------------------");
		Random left = new Random();
		Random right = new Random();
		int flag = 0;
		for( i=0; i<50; i++){
			equation[i][0] = left.nextInt(100);  //����100���������
			equation[i][2] = right.nextInt(100);
			if(equation[i][0] + equation[i][2] <= 100 && equation[i][0] - equation[i][2] >=0)  //�ж����С��100���������0
			{
				set.add(equation[i][0] + sign[i] + equation[i][2]);  //���ü��Ϻ��������ظ���ʽ
				if(set.size() == i+1) {
					flag++;
					System.out.print(i+1+":"+"\t"+equation[i][0]+sign[i]+equation[i][2]+"="+"\t\t");
					if(flag == 5) {  //��ʽ����5ʱ����
						System.out.println();
						flag = 0;
					}
					if(sign[i] == '+')
						operand[i] = equation[i][0] + equation[i][2];  //��Ž��
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
			if(flag == 5) {  //�������5ʱ����
				System.out.println();
				flag = 0;
			}
		}
	}
	
	/*
	 ������������
	 ��Ŀ������50��100�ڼӼ���ʽ
	 */
	public static void main(String[] args) {
		printHeader();
		generateEquations();
		printExercise();
		printCalculations();
	}
}

	
	

	
	

	
