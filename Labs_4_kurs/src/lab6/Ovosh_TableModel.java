package lab6;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

//Модель таблицы. Я не знаю как это работает, но так написано в описании к лабораторной работе
public class Ovosh_TableModel extends AbstractTableModel
{
	ArrayList<Ovosh> ovoshi;

	Ovosh_TableModel(ArrayList<Ovosh> ovoshi)
	{
		super();
		this.ovoshi = ovoshi;
	}

	@Override
	public int getColumnCount()
	{
		return 5;
	}

	@Override
	public String getColumnName(int c)
	{
		String result = "";
		switch (c)
		{
		case 0:
			result = "Название";
			break;
		case 1:
			result = "Сорт";
			break;
		case 2:
			result = "Площадь посадки";
			break;
		case 3:
			result = "Период созревания";
			break;
		case 4:
			result = "Количество";
			break;
		}
		return result;
	}

	@Override
	public int getRowCount()
	{
		return ovoshi.size();
	}

	public Class getColumnClass(int c)
	{
		return getValueAt(0, c).getClass();
	}

	@Override
	public Object getValueAt(int r, int c)
	{
		switch (c)
		{
		case 0:
			return ovoshi.get(r).GetName();
		case 1:
			return ovoshi.get(r).GetSort();
		case 2:
			return ovoshi.get(r).GetPlosh();
		case 3:
			return ovoshi.get(r).GetPeriodSozr();
		case 4:
			return ovoshi.get(r).GetKol_vo();
		default:
			return "";
		}
	}

}
