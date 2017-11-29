package lab4;

import java.awt.Dimension;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Lab_4
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		L4_GUI gggui = new L4_GUI();
		gggui.Carskii_gui.setVisible(true);
	}

}

class L4_GUI
{
	JFrame Carskii_gui;
	private JPanel pnl_all;
	private JLabel lbl_otd, lbl_tab_nom, lbl_fio, lbl_dolj, lbl_srok_s, lbl_srok_po;
	private JTextField txt_otd, txt_tab_nom, txt_fio, txt_dolj, txt_srok_s, txt_srok_po;
	private JComboBox comb_dolj;
	private JButton btn_save, btn_cancel;
	private ActionListener lst_save;
	private ItemListener lst_cmb;
	private String selectedstring;
	private String[] item = { "Начальник", "Инженер", "Холоп", "Рандомный человек" };

	public L4_GUI()
	{
		SozdaemCarskuuGUI(); // Создаем
	}

	private void SozdaemCarskuuGUI()
	{
		Carskii_gui = new JFrame();
		Carskii_gui.setTitle("Царский GUI");
		Carskii_gui.setSize(400, 200);
		Carskii_gui.setLocation(10, 10);
		Carskii_gui.setResizable(false);
		Carskii_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnl_all = new JPanel(new MigLayout("fill", "[][][]"));
		// Элементы после которых переходить на новую строку,
		// количество колонок, количество строк
		Carskii_gui.add(pnl_all);

		lbl_otd = new JLabel("Отдел:");
		txt_otd = new JTextField();
		txt_otd.setColumns(15);
		pnl_all.add(lbl_otd, "span 3,center");
		pnl_all.add(txt_otd, "cell 0 0,center,wrap");

		pnl_all.add(new JSeparator(JSeparator.HORIZONTAL), "span,growx,wrap");

		lbl_tab_nom = new JLabel("Таб. номер:");
		txt_tab_nom = new JTextField();
		txt_tab_nom.setColumns(6);
		pnl_all.add(lbl_tab_nom, "left,growx");
		pnl_all.add(txt_tab_nom, " w 90!, growx,wrap");

		lbl_fio = new JLabel("ФИО:");
		txt_fio = new JTextField();
		txt_fio.setColumns(10);
		pnl_all.add(lbl_fio, "left,growx");
		pnl_all.add(txt_fio, "span 3, growx, wrap");

		txt_dolj = new JTextField();
		
		lst_cmb = new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemEvent)
			{
				int state = itemEvent.getStateChange();
				ItemSelectable is = itemEvent.getItemSelectable();
				txt_dolj.setText(selectedString(is));
			}
		};

		lbl_dolj = new JLabel("Должность:");
		comb_dolj = new JComboBox(item);
		comb_dolj.addItemListener(lst_cmb);
		pnl_all.add(lbl_dolj, "growx");
		pnl_all.add(txt_dolj, "growx");
		pnl_all.add(comb_dolj, "growx,split 2, wrap");

		lbl_srok_s = new JLabel("Срок контракта с");
		txt_srok_s = new JTextField();
		txt_srok_s.setColumns(6);
		lbl_srok_po = new JLabel("по");
		txt_srok_po = new JTextField();
		txt_srok_po.setColumns(6);
		pnl_all.add(lbl_srok_s, "");
		pnl_all.add(txt_srok_s, "growx");
		pnl_all.add(lbl_srok_po, "cell 2 5, split 2");
		pnl_all.add(txt_srok_po, "w 90!, cell 2 5,wrap");

		pnl_all.add(new JSeparator(JSeparator.HORIZONTAL), "span,growx,wrap");

		lst_save = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				txt_tab_nom.setText("САВЕ");
			}
		};
		btn_save = new JButton("Сохранить");
		btn_save.addActionListener(lst_save);
		btn_cancel = new JButton("Отменить");
		btn_cancel.addMouseListener(new Lst_cancel());
		pnl_all.add(btn_save, "cell 2 7, split 2");
		pnl_all.add(btn_cancel, "cell 2 7");
	}

	static private String selectedString(ItemSelectable is)
	{
		Object selected[] = is.getSelectedObjects();
		return ((selected.length == 0) ? "null" : (String) selected[0]);
	}

	public class Lst_cancel implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "Нельзя отменить!", "Информация", JOptionPane.INFORMATION_MESSAGE);
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}
	}
}
