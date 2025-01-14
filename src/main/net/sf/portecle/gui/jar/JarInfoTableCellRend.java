/*
 * JarInfoTableCellRend.java
 * This file is part of Portecle, a multipurpose keystore and certificate tool.
 *
 * Copyright © 2004 Wayne Grant, waynedgrant@hotmail.com
 *             2008 Ville Skyttä, ville.skytta@iki.fi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package net.sf.portecle.gui.jar;

import java.awt.Component;
import java.text.MessageFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import net.sf.portecle.FPortecle;

/**
 * Custom cell renderer for the cells of the Jar Information table of DJarInfo.
 */
@SuppressWarnings("serial")
class JarInfoTableCellRend
    extends DefaultTableCellRenderer
{
	/** Size column message format */
	private static final String SIZE_COL_FORMAT = FPortecle.RB.getString("JarInfoTableModel.Size");

	/**
	 * Returns the rendered cell for the supplied value and column.
	 *
	 * @param jtJarInfo The JTable
	 * @param value The value to assign to the cell
	 * @param bIsSelected True if cell is selected
	 * @param iRow The row of the cell to render
	 * @param iCol The column of the cell to render
	 * @param bHasFocus If true, render cell appropriately
	 * @return The rendered cell
	 */
	@Override
	public Component getTableCellRendererComponent(JTable jtJarInfo, Object value, boolean bIsSelected,
	    boolean bHasFocus, int iRow, int iCol)
	{
		JLabel cell =
		    (JLabel) super.getTableCellRendererComponent(jtJarInfo, value, bIsSelected, bHasFocus, iRow, iCol);
		if (iCol == 1)
		{
			cell.setText(MessageFormat.format(SIZE_COL_FORMAT, Math.round((Long) value / (double) 1024)));
		}

		cell.setBorder(new EmptyBorder(0, 5, 0, 5));

		return cell;
	}
}
