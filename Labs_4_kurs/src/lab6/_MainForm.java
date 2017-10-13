package lab6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.RowSorter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
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

class MainForm implements TableModelListener
{
	JFrame MainFrame;

	ArrayList<Ovosh> ovoshi;

	private JPanel pnl_table, pnl_dob, pnl_filtr;
	private JTable tbl_ovoshi;
	private JScrollPane skroll;
	private RowSorter<Ovosh_TableModel> sorter;
	private Ovosh_TableModel tmodel;
	private JButton btn_filtr, btn_add;
	private JLabel lbl_filtr;
	private JTextField txt_filtr, txt_nazv, txt_sort, txt_plosh_pos, txt_per_sozr, txt_kolvo;
	private JComboBox cmb_dob;
	private String[] item_class_ovosh = { "Картофель", "Огурец" };

	public MainForm()
	{
		Initialization();

	}

	private void Initialization()
	{
		MainFrame = new JFrame();
		MainFrame.setPreferredSize(new Dimension(750, 570));// setSize(400,
															// 450);
		MainFrame.setMinimumSize(MainFrame.getPreferredSize());
		MainFrame.setTitle("Овощи");
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setLayout(new BorderLayout());

		pnl_table = new JPanel();
		pnl_table.setLayout(new MigLayout("fill")); // чтоб растягивалась
													// таблица, при ресайзе
													// формы (только в ширину)
		pnl_dob = new JPanel();
		pnl_dob.setPreferredSize(new Dimension(20, 50));
		pnl_dob.setMaximumSize(pnl_dob.getPreferredSize());
		pnl_dob.setLayout(new FlowLayout());
		pnl_filtr = new JPanel();
		pnl_filtr.setPreferredSize(new Dimension(20, 10));
		pnl_filtr.setMaximumSize(pnl_dob.getPreferredSize());
		pnl_filtr.setLayout(new FlowLayout());

		MainFrame.getContentPane().add(pnl_table, BorderLayout.NORTH);
		MainFrame.getContentPane().add(pnl_filtr, BorderLayout.CENTER);
		MainFrame.getContentPane().add(pnl_dob, BorderLayout.SOUTH);

		// Создаем первоначальные данные для таблицы
		ovoshi = new ArrayList<Ovosh>();
		ovoshi.add(new Ogurec("Огурчик молодой", "С пупырками", 900, 5, 30));
		ovoshi.add(new Kartofel("Картошечка к чаю", "Розовая", 500, 10, 90));
		ovoshi.add(new Ogurec("Огурчик Гладкий", "Без пупырок", 800, 15, 29));
		ovoshi.add(new Ogurec("Огурчик гусарский", "Русь матушка", 900, 5, 30));
		ovoshi.add(new Kartofel("Сахарная картошка", "Сахарная", 500, 15, 40));
		// ---------------------------------------------------------------------

		tmodel = new Ovosh_TableModel(ovoshi);
		tmodel.addTableModelListener(this);
		tbl_ovoshi = new JTable(tmodel);
		tbl_ovoshi.setDefaultRenderer(Double.class, new NumbRenderer());
		tbl_ovoshi.setDefaultRenderer(Object.class, new StrRenderer(ovoshi));
		skroll = new JScrollPane(tbl_ovoshi);

		// Сортировщик всегда после скрола!
		
		sorter = new TableRowSorter<Ovosh_TableModel>(tmodel);
		tbl_ovoshi.setRowSorter(sorter);
		pnl_table.add(skroll, "growx, span");

		// Панель сортировки данных по периоду созревания
		lbl_filtr = new JLabel("Период созревания:");
		btn_filtr = new JButton("Отобрать");
		txt_filtr = new JTextField(10);

		pnl_filtr.add(lbl_filtr);
		pnl_filtr.add(txt_filtr);
		pnl_filtr.add(btn_filtr);

		// Слушатель кнопки фильтрации
		btn_filtr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String text_filtr = txt_filtr.getText();
				if (text_filtr.length() == 0)
				{
					((DefaultRowSorter<Ovosh_TableModel, Integer>) sorter).setRowFilter(null);
				}
				else
				{
					try
					{
						((DefaultRowSorter<Ovosh_TableModel, Integer>) sorter).setRowFilter(
								RowFilter.numberFilter(ComparisonType.EQUAL, Double.valueOf(text_filtr), 3));
					}
					catch (PatternSyntaxException pse)
					{
						System.err.println("Ошибка в выражении отбора ");
					}
				}
			}
		});

		// Панель добавления записей
		btn_add = new JButton("Добавить запись");
		txt_nazv = new JTextField(10);
		txt_sort = new JTextField(10);
		txt_plosh_pos = new JTextField(5);
		txt_per_sozr = new JTextField(5);
		txt_kolvo = new JTextField(5);
		cmb_dob = new JComboBox(item_class_ovosh);

		pnl_dob.add(cmb_dob);
		pnl_dob.add(txt_nazv);
		pnl_dob.add(txt_sort);
		pnl_dob.add(txt_plosh_pos);
		pnl_dob.add(txt_per_sozr);
		pnl_dob.add(txt_kolvo);
		pnl_dob.add(btn_add);

		// Слушатель кнопки добавления
		btn_add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if (cmb_dob.getSelectedItem().toString().equals("Картофель"))
					{
						ovoshi.add(new Kartofel(txt_nazv.getText(), txt_sort.getText(),
								new Double(txt_plosh_pos.getText()), new Integer(txt_per_sozr.getText()),
								new Integer(txt_kolvo.getText())));
					}
					else
					{
						ovoshi.add(
								new Ogurec(txt_nazv.getText(), txt_sort.getText(), new Double(txt_plosh_pos.getText()),
										new Integer(txt_per_sozr.getText()), new Integer(txt_kolvo.getText())));
					}
				}

				catch (NumberFormatException e)
				{
					e.printStackTrace();
				}
				// Генерируем событие «изменение данных»
				((AbstractTableModel) tmodel).fireTableDataChanged();
			}
		});
		MainFrame.pack();
	}

	// Событие изменения данных
	@Override
	public void tableChanged(TableModelEvent e)
	{
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel) e.getSource();
		String columnName = model.getColumnName(column);
		Object data = model.getValueAt(row, column);
	}

}
