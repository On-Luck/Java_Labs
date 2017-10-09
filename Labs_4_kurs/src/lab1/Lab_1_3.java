package lab1;

import java.util.Random;
import java.util.Scanner;

public class Lab_1_3
{
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args)
	{
		// Дан одномерный массив, сформировать новый массив из его нечетных
		// элементов
		Random rnd = new Random();

		int n = rnd.nextInt(12) + 3;
		n = 3;
		int k = 0;
		int[] Z = new int[n];
		int[] Y;

		System.out.println("Введите массив Z (n=" + n + "):");
		for (int i = 0; i < n; i++)
		{
			System.out.print("Z[" + i + "]=");
			Z[i] = scanf();
			if (Z[i] % 2 == 1)
			{
				k++;
			}
		}

		if (k > 0) // Если вообще существуют нечетные элементы в массиве Z
		{
			Y = new int[k];
			Y = nechet_or_not(k, n, Z);
			System.out.println("\nНовый массив Y:");
			for (int i = 0; i < Y.length; i++)
			{
				System.out.println("Y[" + i + "] = " + Y[i]);
			}

		}
		else
			System.out.println("\nВ данном массиве нет нечетных элементов!");

		scn.close();
	}

	public static int scanf()
	{
		int a;
		a = scn.nextInt();
		return a;
	}

	public static int[] nechet_or_not(int bb, int aa, int[] ZZ)
	{
		int j = 0;
		int[] YY = new int[bb];
		for (int i = 0; i < aa; i++)
		{
			if ((ZZ[i]) % 2 != 0)
			{
				YY[j] = ZZ[i];
				j++;
			}
		}
		return YY;
	}
}
