package com.japisoft.editix.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Iterator;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import com.japisoft.framework.ApplicationModel;
import com.japisoft.framework.application.descriptor.ActionModel;
import com.japisoft.framework.preferences.Preferences;
import com.japisoft.framework.ui.LinkLabel;
import com.japisoft.framework.ui.toolkit.BrowserCaller;
import com.japisoft.xmlpad.IXMLPanel;
import com.japisoft.xmlpad.XMLContainer;
import com.japisoft.xmlpad.XMLDocumentInfo;
import com.japisoft.xmlpad.bookmark.BookmarkContext;
import com.japisoft.xmlpad.tree.parser.Parser;

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
public class EditixInitPanel extends javax.swing.JPanel 
	implements 
		IXMLPanel, 
		MouseListener,
		ActionListener {
    
    /** Creates new form EditixInitPanel */
    public EditixInitPanel() {
        initComponents();
    }

    public Action getAction(String actionId) {
    	return null;
    }
    
    public IXMLPanel getPanelParent() {
    	return null;
    }
    
    public Parser createNewParser() {
    	return null;
    }
    
    public void dispose() {}
    public void setAutoDisposeMode(boolean disposeMode) {}    

	public XMLContainer getMainContainer() {
		return null;
	}
	
	public BookmarkContext getBookmarkContext() {
		return null;
	}	
	
	public XMLContainer getSelectedContainer() {
		return null;
	}		
	
	public XMLContainer getSubContainerAt(int index) {
		return null;
	}
	
	public void selectSubContainer(IXMLPanel panel) {
	}	

	public int getSubContainerCount() {
		return 0;
	}
	
	public void setDocumentInfo(XMLDocumentInfo info) {
	}	

	public Iterator getProperties() {
		return null;
	}

	public Object getProperty(String name, Object def) {
		return null;
	}

	public Object getProperty(String name) {
		return null;
	}

	public XMLContainer getSubContainer(String type) {
		return null;
	}

	public JComponent getView() {
		return this;
	}

	public void prepareToSave() {
	}	
	public void postLoad() {
	}
	
	public boolean reload() {
		return false;
	}	
	
	public void copy() {
	}
	public void cut() {
	}
	public void paste() {
	}
		
	@Override
	public Object print() {
		return null;
	}
	
	public void setProperty(String name, Object content) {
	}

	public void mouseClicked(MouseEvent e) {
		if ( e.getSource() == openLbl ) {
			ActionModel.activeActionById( "new", null );
		} else
		if ( e.getSource() == helpLbl ) {
			ActionModel.activeActionById( "Manual", null );
		} else
		if ( e.getSource() == urlLbl ) {
			BrowserCaller.displayURL( "http://www.editix.com" );
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		Preferences.setPreference("interface", "initialDocument", openNextCb.isSelected() );
	}	

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {
        logoLbl = new javax.swing.JLabel();
        
        logoLbl.setIcon( new ImageIcon( ClassLoader.getSystemResource( "images/logo.png" ) ) );
        
        logoLbl.setHorizontalAlignment( JLabel.LEFT );

        openLbl = new LinkLabel("Create a new document");
        helpLbl = new LinkLabel( "User Manual" );
        openNextCb = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        versionLbl = new javax.swing.JLabel();
        urlLbl = new LinkLabel("http://www.editix.com");

        // logoLbl.setBackground(new java.awt.Color(255, 255, 255));
        // logoLbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logoLbl.setOpaque(true);

        helpLbl.setForeground(new java.awt.Color(51, 51, 255));
        	
        openNextCb.setSelected(true);
       	openNextCb.setText("Open next time");
        openNextCb.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        openNextCb.setMargin(new java.awt.Insets(0, 0, 0, 0));

       	jLabel1.setText("Version :");
       	versionLbl.setText( ApplicationModel.getAppYear() );

        urlLbl.setForeground(new java.awt.Color(0, 102, 51));
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(logoLbl, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(openLbl)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 275, Short.MAX_VALUE)
                        .add(openNextCb))
                    .add(helpLbl)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(versionLbl)
                        .add(47, 47, 47)
                        .add(urlLbl))
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(logoLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(openLbl,GroupLayout.PREFERRED_SIZE,20,GroupLayout.PREFERRED_SIZE)
                    .add(openNextCb))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(helpLbl,GroupLayout.PREFERRED_SIZE,20,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(versionLbl)
                    .add(urlLbl,GroupLayout.PREFERRED_SIZE,20,GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void openNextCbActionPerformed(java.awt.event.ActionEvent evt) {}

    public String toString() {
		return "Starting";
	}    

    public void addNotify() {
    	super.addNotify();
    	openLbl.addMouseListener( this );
    	helpLbl.addMouseListener( this );
    	openNextCb.addActionListener( this );
    	urlLbl.addMouseListener( this );
    }

    public void removeNotify() {
    	super.removeNotify();
    	openLbl.removeMouseListener( this );
    	helpLbl.removeMouseListener( this );
    	urlLbl.removeMouseListener( this );
    	openNextCb.removeActionListener( this );
    }

    // Variables declaration - do not modify                     
    private LinkLabel helpLbl;
    private javax.swing.JLabel jLabel1;
    private LinkLabel urlLbl;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoLbl;
    private LinkLabel openLbl;
    private javax.swing.JCheckBox openNextCb;
    private javax.swing.JLabel versionLbl;
    // End of variables declaration                   
    
}
