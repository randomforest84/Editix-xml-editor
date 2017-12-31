package com.japisoft.editix.ui.locationbar;

import java.awt.Color;

import com.japisoft.framework.xml.parser.node.FPNode;

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
public class FOLabel implements Label {

	Color c = new Color( Integer.parseInt( "EDC87E", 16 ) );
	
	public Color getColor(FPNode node) {
		if ( node.matchContent( "page-sequence" ) || node.matchContent( "flow" ) ) {
			return c;
		}
		if ( node.hasAttribute( "id" ) )
			return c;
		return null;
	}

	public String getLabel(FPNode node) {
		if ( node.matchContent( "page-sequence" ) ) {
			return "page-sequence[" + node.getAttribute( "master-reference" )+ "]";
		}
		if ( node.matchContent( "flow" ) ) {
			return "page-sequence[" + node.getAttribute( "flow-name" ) + "]";
		}
		if ( node.hasAttribute( "id" ) ) {
			return node.getContent() + "[" + node.getAttribute( "id" ) + "]"; 
		}
		return null;
	}

}
