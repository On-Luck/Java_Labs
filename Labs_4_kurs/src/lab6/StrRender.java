package lab6;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

class StrRenderer implements TableCellRenderer
{
	private ArrayList<Ovosh> ovoshi_1;

	StrRenderer(ArrayList<Ovosh> aaa)
	{
		this.ovoshi_1 = aaa;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column)
	{
		JTextField editor = new JTextField();
		if (value != null)
			editor.setText(value.toString());
		if (Ogurec.class.isAssignableFrom(ovoshi_1.get(row).getClass()))
		{
			editor.setBackground(Color.green);
		}
		else
			editor.setBackground(Color.lightGray);
		return editor;

	}
}
