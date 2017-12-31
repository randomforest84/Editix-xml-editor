package com.japisoft.xflows.task.xslt;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import com.japisoft.framework.ui.text.FileTextField;
import com.japisoft.xflows.task.AbstractTaskUI;
import com.japisoft.xflows.task.FilesTaskRunner;
import com.japisoft.xflows.task.ui.XFlowsFactory;

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
public class XSLTUI extends AbstractTaskUI implements ActionListener {

	public static final String SOURCEPATH = FilesTaskRunner.SOURCEPATH;

	public static final String SOURCEFILTER = FilesTaskRunner.SOURCEFILTER;

	public static final String STYLESHEET = "stylesheet";

	public static final String TARGETPATH = FilesTaskRunner.TARGETPATH;

	public static final String TARGETNAME = FilesTaskRunner.TARGETNAME;

	public static final String STYLESHEET_VERSION = "version";

	TitledBorder titledBorder1;

	JLabel lblSource = new JLabel();

	FileTextField tfSourcePath = new FileTextField(null, "xml");

	JLabel lblSourceFilter = new JLabel();

	JComboBox cbSourceFilter = XFlowsFactory.getSourceFilter("xslt");

	JLabel lblXSLTPath = new JLabel();

	FileTextField tfStylesheetPath = new FileTextField(null, "xsl");

	JButton btnParameters = new JButton();

	JLabel lblParams = new JLabel();

	JLabel lblTarget = new JLabel();

	FileTextField tfTargetPath = new FileTextField(null, (String)null);

	JLabel lblTargetName = new JLabel();

	JComboBox cbTargetName = XFlowsFactory.getTargetName("xslt");

	GridBagLayout gridBagLayout1 = new GridBagLayout();

	JLabel lblVersion = new JLabel("XSLT Version");

	JComboBox cbVersion = new JComboBox(new String[] { "1.0", "2.0" });

	public XSLTUI() {
		super("xslt");
		try {
			jbInit();

			tfSourcePath.setName(SOURCEPATH);
			cbSourceFilter.setName(SOURCEFILTER);
			tfStylesheetPath.setName(STYLESHEET);
			tfTargetPath.setName(TARGETPATH);
			cbTargetName.setName(TARGETNAME);
			cbVersion.setName(STYLESHEET_VERSION);

			tfSourcePath.setDirectoryMode(true);
			tfTargetPath.setDirectoryMode(true);
			tfTargetPath.setOpenedMode(false);

			tfSourcePath.setPreferenceBinding("xflows", "defaultSourcePath");
			tfTargetPath.setPreferenceBinding("xflows", "defaultTargetPath");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addNotify() {
		super.addNotify();
		btnParameters.addActionListener(this);
	}

	public void removeNotify() {
		super.removeNotify();
		btnParameters.removeActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnParameters) {
			XSLTParametersDialog dialog = new XSLTParametersDialog(params);
			dialog.setVisible(true);
			dialog.dispose();
		} else
			super.actionPerformed(e);
	}

	void jbInit() throws Exception {
		titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "XSLT");
		lblSource.setText("XML Source path");
		this.setBorder(titledBorder1);
		this.setLayout(gridBagLayout1);
		tfSourcePath.setText("");
		lblSourceFilter.setText("XML Source filter");
		cbSourceFilter.setEditable(true);
		lblXSLTPath.setText("Stylesheet path");
		tfStylesheetPath.setText("");
		btnParameters.setText("...");
		lblParams.setText("Parameters");
		lblTarget.setToolTipText("");
		lblTarget.setText("Target path");
		tfTargetPath.setText("");
		lblTargetName.setText("Target name");
		cbTargetName.setEditable(true);
		this.add(lblSource, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,
						17, 0, 0), 0, 0));
		this.add(tfSourcePath, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(2, 9, 0, 14), 434, 4));
		this.add(lblSourceFilter, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 17, 0, 0), 0, 0));
		this.add(cbSourceFilter, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(16, 9, 0, 14), 406, -1));
		this.add(lblXSLTPath, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 17, 0, 7), 0, 0));
		this.add(tfStylesheetPath, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(16, 9, 0, 14), 434, 4));

		this.add(btnParameters, new GridBagConstraints(1, 3, 1, 2, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						14, 9, 28, 0), 50, 0));

		this.add(lblVersion, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 17, 0, 7), 00, 0));

		this.add(cbVersion, new GridBagConstraints(1, 4, 1, 2, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						14, 9, 28, 0), 50, 0));

		this.add(lblParams, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						19, 17, 0, 34), 0, 0));
		this.add(lblTarget, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						18, 17, 0, 31), 0, 0));
		this.add(tfTargetPath, new GridBagConstraints(1, 5, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(14, 9, 0, 14), 434, 4));
		this.add(lblTargetName, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						18, 17, 17, 25), 0, 0));
		this.add(cbTargetName, new GridBagConstraints(1, 6, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(14, 9, 17, 14), 406, -1));
	}

}
