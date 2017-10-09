package lab1;

import java.util.Scanner;

public class Lab_1_1
{
	public static void main(String[] args)
	{
		// НАЙТИ СТОРОНУ КУБА
		double a = 0, plosh = 0;

		System.out.println("Введите площадь поверхности куба: ");

		Scanner scaner = new Scanner(System.in); // для считывания данных из
													// консоли

		plosh = scaner.nextDouble(); // считываем площадь поверхности куба

		a = Math.sqrt(plosh / 6); // S = 6*a^2

		scaner.close(); // закрываем сканер, ибо он ругается

		System.out.printf("Сторона куба: %.2f",a);// ограничить кол-во символов после запятой
	}
}
