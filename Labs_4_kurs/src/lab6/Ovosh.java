package lab6;

interface IOvosh
{
	void SetKol_vo(int kol_vo);

	int GetKol_vo();

	void SetPlosh(double Plosh);

	void SetPerSozr(int PerSozr);

	double GetPlosh(); // площадь каждого растения

	int GetPeriodSozr(); // период созревания в дняхэ

	void SetName(String Name);

	String GetName();

	String GetSort();

	void SetSort(String Sort);
}

public class Ovosh implements IOvosh
{
	private String Name;
	private int Kol_vo = 1;
	private double Plosh;
	private int PerSozr;
	private String Sort;

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
	public void SetName(String Name)
	{
		this.Name = Name;
	}

	@Override
	public String GetName()
	{
		return Name;
	}

	@Override
	public void SetKol_vo(int Kol_vo)
	{
		this.Kol_vo = Kol_vo;
	}

	@Override
	public int GetKol_vo()
	{
		return Kol_vo;
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
}