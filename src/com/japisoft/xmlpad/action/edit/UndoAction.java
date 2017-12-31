package com.japisoft.xmlpad.action.edit;

import com.japisoft.xmlpad.action.XMLAction;

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
public class UndoAction extends XMLAction  {

	public static final String ID = UndoAction.class.getName();
	
	public UndoAction() {
		super();
	}

	public boolean notifyAction() {
		editor.undo();
		return VALID_ACTION;
	}

	protected boolean autoRequestFocus() { return false; }

	protected void notifyXMLContainer() {
		try {
			Boolean previousState = ( Boolean )container.getProperty( "state.undo" );
			if ( previousState != null ) {
				setEnabled( previousState.booleanValue() );
				return;
			}

			setEnabled( 
				container.isEditable() && 
					container.getEditor().getUndoManager().canUndo() );

		} catch( NullPointerException ex ) {
			// ??
			setEnabled( false );
		}
	}

}

// NewAction ends here
