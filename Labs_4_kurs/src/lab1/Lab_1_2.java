package lab1;

import java.util.Random;
import java.util.Scanner;

public class Lab_1_2
{
	public static void main(String[] args)
	{
		// найти количество положительных элементов массива
		Random rnd = new Random();
		Scanner scanner = new Scanner(System.in);

		int n = rnd.nextInt(12) + 3; // от 3 до 15
		double[] X = new double[n]; // сам массив
		int kolvo = 0;

		System.out.println("Введите массив (n=" + n + "):");

		for (int i = 0; i < n; i++)
		{
			System.out.print("X[" + i + "] = ");
			X[i] = scanner.nextDouble();
		}
		kolvo = kola(X); // подсчет элементов массива
		System.out.println("\nКол-во положительных элементов: " + kolvo);

		scanner.close();
	}

	public static int kola(double[] y)
	{
		int a = 0;
		for (int i = 0; i < y.length; i++)
		{
			if (y[i] > 0)
			{
				a++;
			}
		}
		return a;
	}
}
