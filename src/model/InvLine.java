package model;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.FileOperations;

@SuppressWarnings("serial")
public class InvLine extends JDialog {

	private JButton    okButton;
	private JButton    cancelBtn;
	private JTextField itemNameTF;
	private JLabel     itemNameL;
	private JTextField itemCountTF;
	private JLabel     itemCountL;
	private JTextField itemPriceTF;
	private JLabel     itemPriceL;
	
	public  InvLine(FileOperations frame) {


		itemNameL = new JLabel("Item Name : ");
		itemNameTF = new JTextField(20);

		itemCountL = new JLabel("Count : ");
		itemCountTF = new JTextField(20);

		itemPriceL = new JLabel("Item Price : ");
		itemPriceTF = new JTextField(20);

		okButton = new JButton("Ok");
		cancelBtn = new JButton("Cancel");

		okButton.setActionCommand("createItemOk");
		cancelBtn.setActionCommand("createItemCancel");

		okButton.addActionListener(frame);
		cancelBtn.addActionListener(frame);
		setLayout(new GridLayout(4, 2));
		setSize(200, 200);
		setLocation(200, 300);

		add(itemNameL);
		add(itemNameTF);
		add(itemCountL);
		add(itemCountTF);
		add(itemPriceL);
		add(itemPriceTF);
		add(okButton);
		add(cancelBtn);
		pack();

	}

	public JTextField getItemNameTF() {

		return itemNameTF;
	}

	public JTextField getItemCountTF() {

		return itemCountTF;
	}

	public JTextField getItemPriceTF() {

		return itemPriceTF;
	}



}