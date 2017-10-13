package lab6;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

class NumbRenderer extends DefaultTableCellRenderer
{
	NumbRenderer()
	{
		setHorizontalAlignment(SwingConstants.RIGHT);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column)
	{
		if (value == null)
			return this;
		Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Double nm = (Double) value;
		renderer.setBackground((nm > 300.) ? Color.yellow : Color.pink);
		return renderer;
	}
}
