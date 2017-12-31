package com.japisoft.editix.ui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import com.japisoft.framework.application.descriptor.helpers.MenuBuilderDelegate;
import com.japisoft.framework.preferences.Preferences;
import com.japisoft.framework.xml.Encoding;

/**
This program is available under two licenses : 

1. For non commercial usage : 

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

2. For commercial usage :

You need to get a commercial license for source usage at : 

http://www.editix.com/buy.html

Copyright (c) 2018 Alexandre Brillant - JAPISOFT SARL - http://www.japisoft.com

@author Alexandre Brillant - abrillant@japisoft.com
@author JAPISOFT SARL - http://www.japisoft.com

*/
public class XMLSpaceBuilder implements MenuBuilderDelegate {

	public void build(JMenu menu) {
		
		menu.setEnabled( true );		
		ChangeXMLSpaceAction action = new ChangeXMLSpaceAction();
		JCheckBoxMenuItem item = new JCheckBoxMenuItem( action );				
		item.setSelected( Preferences.getPreference( "xmlconfig", "format-xml:space", true ) );

		menu.add( item );

	}

	class ChangeXMLSpaceAction extends AbstractAction {
		
		ChangeXMLSpaceAction() {
			putValue( Action.NAME, "automatic" );
		}
		public void actionPerformed(ActionEvent e) {
			Preferences.setPreference( "xmlconfig", "format-xml:space", ( ( JCheckBoxMenuItem )e.getSource() ).isSelected() );
			EditixFactory.buildAndShowInformationDialog( "Please restart EditiX for applying" );
		}
	}

}
