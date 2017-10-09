package lab3_1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Lab_3_GUI
{
	public static void main(String[] args)
	{
		SimpleGUI frm = new SimpleGUI();
		// frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}

/*
 * 17. Создать фрейм. Добавить 2 поля и меню. В 1-поле записать число (байтов).
 * Подпункты меню задают перевод числа в Кб, Мб, Гб, Тб. Bключающий JRadioButton
 * с указанием единиц измерения: Кб, Мб, Гб, Тб. При выборе пункта меню
 * выполнять перевод и записывать результат перевода во 2-поле. Рядом с полем
 * указывать (в метке) единицы перевода.
 * 
 * Кароч, при нажатии на кнопку меню или радио кнопку, выполняется перевод числа
 * из байтов в Кб/Мб/Гб/Тб (в зависимости от нажатого пункта). Число беертся в
 * первом поле, а переведенное число выводится во второе поле.
 */

class SimpleGUI extends JFrame
{
	JPanel pnl1, pnl2; // Панели
	JTextArea txt1, txt2; // Текст бокс
	ButtonGroup bg;
	JRadioButton rb1, rb2, rb3, rb4; // радио баттон
	JLabel lbl1; // метка
	JMenuBar mb; // меню бар
	JMenu mn;
	JMenuItem mi1, mi2, mi3, mi4; // пункты меню
	ActionListener lst1, lst2, lst3, lst4;

	public SimpleGUI()
	{
		setSize(300, 200);
		setLocation(10, 10);
		setTitle("Царский GUI");
		// setResizable(false);
		CreateGUI(); // Создаем
		pack();
	}

	private void CreateGUI()
	{
		pnl1 = new JPanel(); // тут будут тексты
		pnl2 = new JPanel(); // тут будут кнопки
		pnl1.setLayout(new FlowLayout());
		pnl2.setLayout(new FlowLayout());
		txt1 = new JTextArea(2, 10);// начальные условия
		txt2 = new JTextArea(2, 10);// выходные данные
		lbl1 = new JLabel("Кб");
		// Меню
		mb = new JMenuBar();
		mn = new JMenu("Переводи");
		mi1 = new JMenuItem("Кб");
		mn.add(mi1);
		mi2 = new JMenuItem("Мб");
		mn.add(mi2);
		mi3 = new JMenuItem("Гб");
		mn.add(mi3);
		mi4 = new JMenuItem("Тб");
		mn.add(mi4);
		mb.add(mn);
		// Радио кнопки
		bg = new ButtonGroup();
		rb1 = new JRadioButton("Кб");
		bg.add(rb1);
		rb1.setSelected(true); // чтоб была выбрана при запуске программы
		rb2 = new JRadioButton("Мб");
		bg.add(rb2);
		rb3 = new JRadioButton("Гб");
		bg.add(rb3);
		rb4 = new JRadioButton("Тб");
		bg.add(rb4);
		//

		// Слушатели
		lst1 = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lbl1.setText("Кб");
				txt2.setText(Double.toString((Double.parseDouble(txt1.getText()) / 1024)));
			}
		};
		mi1.addActionListener(lst1);
		rb1.addActionListener(lst1);
		lst2 = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lbl1.setText("Мб");
				txt2.setText(
						String.format("%f", (Double.parseDouble(txt1.getText()) / 1024 / 1024)));
			}
		};
		mi2.addActionListener(lst2);
		rb2.addActionListener(lst2);
		lst3 = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lbl1.setText("Гб");
				txt2.setText(String.format("%f", (Double.parseDouble(txt1.getText()) / 1024 / 1024 / 1024)));
			}
		};
		mi3.addActionListener(lst3);
		rb3.addActionListener(lst3);
		lst4 = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lbl1.setText("Тб");
				txt2.setText(String.format("%f", (Double.parseDouble(txt1.getText()) / 1024 / 1024 / 1024 / 1024)));
			}
		};
		mi4.addActionListener(lst4);
		rb4.addActionListener(lst4);

		//
		pnl1.add(txt1);
		pnl1.add(txt2);
		pnl1.add(lbl1);
		pnl2.add(rb1);
		pnl2.add(rb2);
		pnl2.add(rb3);
		pnl2.add(rb4);
		setLayout(new GridLayout(2, 1));
		setJMenuBar(mb);
		getContentPane().add(pnl1);
		getContentPane().add(pnl2);
	}

}
