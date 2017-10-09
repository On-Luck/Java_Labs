package lab3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Lab_3_GUI
{
	private JFrame frame;

	public static void main(String[] args)
	{
		SimpleGUI frm = new SimpleGUI();
		// frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}

// 6. Создать фрейм. Поместить в него текстовое поле,
// кнопку и список. При нажатии на кнопку выделенный
// элемент списка копировать в поле ввода.

class SimpleGUI extends JFrame
{
	// Объявили
	JPanel pnl1, pnl2;
	JButton button1;
	JTextPane textbox1;
	JList list1;
	ActionListener listener1;

	public SimpleGUI()
	{
		setSize(200, 200);
		setLocation(10, 10);
		setTitle("Царский GUI");
		// setResizable(false);
		CreateGUI(); // Создаем
		pack();
	}

	private void CreateGUI()
	{
		String[] data = { "Chrome", "Firefox", "Internet Explorer", "Safari", "Opera" };
		// потому что мне лень писать по другому, а в задании не указан способ
		// заполнения листа

		// Создали
		// Панели
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl1.setLayout(new FlowLayout());
		pnl2.setLayout(new FlowLayout());
		// Текст
		textbox1 = new JTextPane();
		textbox1.setText("Тут текстбокс");
		// Лист бокс
		list1 = new JList(data); // ТУТ БЛЯДЬ ОШИБКА, ОН НИХУЯ НЕ ВЫВОДИТ ЛИСТ С
									// ЭТОЙ ХУЙНЕЙ!
		list1.setLayoutOrientation(JList.VERTICAL);
		list1.setVisibleRowCount(0);

		// Слушатель событий
		listener1 = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textbox1.setText((String) list1.getSelectedValue());
			}
		};
		// Кнопка
		button1 = new JButton("Не нажимать!");
		button1.addActionListener(listener1);

		// Добавление элементов на панели
		pnl1.add(textbox1);
		pnl1.add(button1);
		pnl2.add(list1);
		// Добавление панелей на фрейм (я проклинаю тот день, когда это стало
		// нормой)
		setLayout(new GridLayout(4, 1));
		getContentPane().add(pnl1);
		getContentPane().add(pnl2);
	}
}