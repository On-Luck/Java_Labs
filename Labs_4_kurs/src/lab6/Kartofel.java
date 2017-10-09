package lab6;

public class Kartofel extends Ovosh
{
	private String Name;
	private int Kol_vo = 0;
	private double Plosh;
	private int PerSozr;
	private String Sort;

	Kartofel() // конструктор
	{
		this.Kol_vo = 1;
		this.Plosh = 50 * 30;
		this.PerSozr = 80;
		this.Name = "Неопределен";
		this.Sort = "Неопределен";
	}

	Kartofel(String Name, String Sort, double Plosh, int Kol_vo, int PerSozr) // конструктор
																				// с
																				// параметрами
	{
		this.Name = Name;
		this.Sort = Sort;
		this.Plosh = Plosh;
		this.Kol_vo = Kol_vo;
		this.PerSozr = PerSozr;
	}

	@Override
	public String GetSort()
	{
		return Sort;
	}

	@Override
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
		this.Name = name;
	}

	@Override
	public String GetName()
	{
		return Name;
	}

	@Override
	public void SetKol_vo(int kol_vo)
	{
		this.Kol_vo = kol_vo;
	}

	@Override
	public int GetKol_vo()
	{
		return Kol_vo;
	}
}