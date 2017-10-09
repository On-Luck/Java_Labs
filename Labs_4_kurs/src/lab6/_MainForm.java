package lab6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableRowSorter;

import net.miginfocom.swing.MigLayout;

public class _MainForm
{
	public static void main(String[] args)
	{
		MainForm gggui = new MainForm();
		gggui.MainFrame.setVisible(true);

	}
}

class MainForm
{
	JFrame MainFrame;

	ArrayList<Ovosh> ovoshi;

	private JPanel pnl_table, pnl_dob, pnl_filtr;
	private JTable tbl_ovoshi;
	private JScrollPane skroll;
	private RowSorter<Ovosh_TableModel> sorter;
	private Ovosh_TableModel tmodel;
	private JButton btn1;
	
	public MainForm()
	{
		Initialization();
		
	}

	private void Initialization()
	{
		MainFrame = new JFrame();
		MainFrame.setSize(450, 300);
		MainFrame.setTitle("Овощи");
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setLayout(new BorderLayout());

		pnl_table = new JPanel();
		//pnl_table.setPreferredSize(new Dimension(400, 100));
		pnl_table.setLayout(new MigLayout("fill")); //чтоб растягивалась таблица, при ресайзе формы
		pnl_dob = new JPanel();
		pnl_dob.setLayout(new FlowLayout());
		pnl_filtr = new JPanel();
		pnl_filtr.setLayout(new FlowLayout());

		MainFrame.getContentPane().add(pnl_table, BorderLayout.NORTH);
		MainFrame.getContentPane().add(pnl_dob, BorderLayout.CENTER);
		MainFrame.getContentPane().add(pnl_filtr, BorderLayout.SOUTH);

		// Создаем первоначальные данные для таблицы
		ovoshi = new ArrayList<Ovosh>();
		ovoshi.add(new Ogurec("Огурчик молодой", "С пупырками", 900, 5, 30));
		ovoshi.add(new Kartofel("Картошечка к чаю", "Розовая", 500, 10, 90));
		ovoshi.add(new Ogurec("Огурчик Гладкий", "Без пупырок", 800, 15, 29));
		ovoshi.add(new Ogurec("Огурчик гусарский", "Русь матушка", 900, 5, 30));
		ovoshi.add(new Kartofel("Сахарная картошка", "Сахарная", 500, 15, 40));
		//---------------------------------------------------------------------
		
		tbl_ovoshi = new JTable(new Ovosh_TableModel(ovoshi));
		skroll = new JScrollPane(tbl_ovoshi);
		
		//Сортировщик всегда после скрола!
		tmodel = new Ovosh_TableModel(ovoshi);
		sorter = new TableRowSorter<Ovosh_TableModel>(tmodel);
		tbl_ovoshi.setRowSorter(sorter);
		//tbl_ovoshi.setPreferredScrollableViewportSize(new Dimension(430, 200));
		pnl_table.add(skroll, "growx, span");
		
		btn1 = new JButton("qweqwe");
		pnl_dob.add(btn1);
		pnl_filtr.add(new JButton("1231231"));
		MainFrame.pack();
		
	}
}
