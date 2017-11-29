package lab2;

import java.util.Random;
import java.util.Scanner;

// Овощное растение. Подклассы Картофель, Огурцы. 
// Выполнить посадку растений. 
// Определить суммарную площадь посадок. 
// Вывести информацию о растениях с заданным периодом созревания.

interface IOvosh
{
	void SetKol_vo(int kol_vo);

	int GetKol_vo();

	void SetPlosh(double Plosh);

	void SetPerSozr(int PerSozr);

	double GetPlosh(); // площадь каждого растения

	int GetPeriodSozr(); // период созревания в дняхэ

	void SetName(String name);

	String GetName();
}

abstract class Ovosh implements IOvosh
{
	private String name;
	private int kol_vo = 0;
	private double Plosh;
	private int PerSozr;

	@Override
	public double GetPlosh()
	{
		return Plosh;
	}

	@Override
	public int GetPeriodSozr()
	{
		return PerSozr;
	}

	@Override
	public void SetPlosh(double Plosh)
	{
		this.Plosh = Plosh;
	}

	@Override
	public void SetPerSozr(int PerSozr)
	{
		this.PerSozr = PerSozr;
	}

	@Override
	public void SetName(String name)
	{
		this.name = name;
	}

	@Override
	public String GetName()
	{
		return name;
	}

	@Override
	public void SetKol_vo(int kol_vo)
	{
		this.kol_vo = kol_vo;
	}

	@Override
	public int GetKol_vo()
	{
		return kol_vo;
	}
}

class Kartofel extends Ovosh
{
	private String name;
	private int kol_vo = 0;
	private double Plosh;
	private int PerSozr;
	private String Sort;

	Kartofel() // конструктор
	{
		Plosh = 50 * 30;
		PerSozr = 80;
	}

	public String GetSort()
	{
		return Sort;
	}

	public void SetSort(String Sort)
	{
		this.Sort = Sort;
	}

	public double GetPlosh()
	{
		return Plosh;
	}

	@Override
	public int GetPeriodSozr()
	{
		return PerSozr;
	}

	@Override
	public void SetPlosh(double Plosh)
	{
		this.Plosh = Plosh;
	}

	@Override
	public void SetPerSozr(int PerSozr)
	{
		this.PerSozr = PerSozr;
	}

	public void SetName(String name)
	{
		this.name = name;
	}

	@Override
	public String GetName()
	{
		return name;
	}

	@Override
	public void SetKol_vo(int kol_vo)
	{
		this.kol_vo = kol_vo;
	}

	@Override
	public int GetKol_vo()
	{
		return kol_vo;
	}
}

class Ogurec extends Ovosh
{
	private String name;
	private int kol_vo = 0;
	private double Plosh;
	private int PerSozr;
	private String Sort;

	Ogurec() // конструктор
	{
		Plosh = 70 * 45;
		PerSozr = 30;
	}

	public String GetSort()
	{
		return Sort;
	}

	public void SetSort(String Sort)
	{
		this.Sort = Sort;
	}

	@Override
	public double GetPlosh()
	{
		return Plosh;
	}

	@Override
	public int GetPeriodSozr()
	{
		return PerSozr;
	}

	@Override
	public void SetPlosh(double Plosh)
	{
		this.Plosh = Plosh;
	}

	@Override
	public void SetPerSozr(int PerSozr)
	{
		this.PerSozr = PerSozr;
	}

	public void SetName(String name)
	{
		this.name = name;
	}

	@Override
	public String GetName()
	{
		return name;
	}

	@Override
	public void SetKol_vo(int kol_vo)
	{
		this.kol_vo = kol_vo;
	}

	@Override
	public int GetKol_vo()
	{
		return kol_vo;
	}
}

// Основной класс программы
public class Lab_2_1
{
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		Random rnd = new Random();

		// String abc;
		double obsh_plosh = 0;
		int per = 0;
		int kk = 1;// просто счетчик

		int n = rnd.nextInt(7) + 3;
		//n = 2; // для проверки работы программы.
		Ovosh[] ov = new Ovosh[n]; // максимум 10

		System.out.println("Всего культур: " + n + "\nНеобходимо выбрать овощ (1 - картофель, 2 - огурцы).");

		for (int i = 0; i < n; i++)
		{
			System.out.println("Овощ №" + i);
			if (scn.nextInt() == 1)
			{
				ov[i] = new Kartofel();
				System.out.println("Введите название сорта: ");
				((Kartofel) ov[i]).SetSort(scn.next());

			}
			else
			{
				ov[i] = new Ogurec();
				System.out.println("Введите название сорта: ");
				((Ogurec) ov[i]).SetSort(scn.next());

			}
			System.out.println("Введите название культуры: ");
			ov[i].SetName(scn.next());
			System.out.println("Введите количество сажаемых кустов: ");
			ov[i].SetKol_vo(scn.nextInt());
			System.out.println("Эта культура отличается от стандартных по площади посадки и периоду созревания?\n"
					+ "1 - да, 2 - нет");
			if (scn.nextInt() == 1)
			{
				System.out.println("Введите период созревания: ");
				ov[i].SetPerSozr(scn.nextInt());
				System.out.println("Введите площадь посадки одного куста: ");
				ov[i].SetPlosh(scn.nextDouble());
			}

			obsh_plosh += ov[i].GetKol_vo() * ov[i].GetPlosh();
		}

		System.out.println("\n\nОбщая площадь посадки всех растений: " + obsh_plosh + "см^2");

		// ----------------------------------------------------------------------------
		System.out.println("------------------------------------------------------------"
				+ "\n\nИнформация о растениях с заданным периодом созревания.\nВведите период созревания:");

		per = scn.nextInt();

		for (int i = 0; i < n; i++)
		{
			if (ov[i].GetPeriodSozr() == per)
			{
				String srt;
				if (Kartofel.class.isAssignableFrom(ov[i].getClass()))
				{
					srt = ((Kartofel) ov[i]).GetSort();
				}
				else
				{
					srt = ((Ogurec) ov[i]).GetSort();

				}
				System.out.println(kk + ")\n" + "Сорт :" + srt + "\nНазвание: " + ov[i].GetName()
						+ "\nПлощадь посадки одного растения (cm^2) - " + +ov[i].GetPlosh()
						+ "\nКол-во посаженных растений: " + ov[i].GetKol_vo());
				kk++;

			}
		}
		scn.close();
	}
}
