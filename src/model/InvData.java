package model;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.FileOperations;

@SuppressWarnings("serial")
public class InvData extends JDialog {

	private JButton    okBtn;
	private JButton    cancelbtn;
	private JTextField customerNameField;
	private JTextField inDateF;
	private JLabel     customerNameL;
	private JLabel     invDateL;


	public InvData(FileOperations frame) {
		customerNameL = new JLabel("Customer Name : ");
		customerNameField = new JTextField(20);
		invDateL = new JLabel("Inv Date : ");
		inDateF = new JTextField(20);
		okBtn = new JButton("Ok");
		cancelbtn = new JButton("Cancel");

		okBtn.setActionCommand("createOk");
		cancelbtn.setActionCommand("createCancel");

		okBtn.addActionListener(frame);
		cancelbtn.addActionListener(frame);

		setLayout(new GridLayout(3, 2));
		setSize(200, 200);
		setLocation(200, 300);

		add(customerNameL);
		add(customerNameField);
		add(invDateL);
		add(inDateF);
		add(okBtn);
		add(cancelbtn);

		pack();

	}

	public JTextField getCustomerNameField() {
		return customerNameField;
	}

	public JTextField getInDateF() {
		return inDateF;
	}

}