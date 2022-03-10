package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.io.BufferedReader;
import java.io.File;
import view.MyTableModel2;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import model.InvData;
import model.InvLine;
import view.MyTableModel;
import javax.swing.JMenuItem;

/**
 *
 * @author Win 10
 */
@SuppressWarnings("serial")
public class FileOperations extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

	public SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
	public ArrayList<InvoiceHeader> invoices = new ArrayList<>();
	public ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();
	public InvLine jLine;
	public InvData invData;
	public MyTableModel headerTabelModel;
	public MyTableModel2 linesTabelModel;

	public FileOperations() {
		initilaize();
	}

	public void initilaize() {

		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		headerTable = new javax.swing.JTable();
		headerTable.getSelectionModel().addListSelectionListener(this);
		createNewInvoice = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		InsertNewItem = new javax.swing.JButton();
		DeleteItem = new javax.swing.JButton();
		InvDatetextF = new javax.swing.JTextField();
		InvCustomerNameTestF = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		LineTable = new javax.swing.JTable();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		loadFileMenuItem = new javax.swing.JMenuItem("Open",'O');
		loadFileMenuItem.setAccelerator(KeyStroke.getKeyStroke('O',KeyEvent.CTRL_DOWN_MASK));
		loadFileMenuItem.addActionListener(this);
		loadFileMenuItem.setActionCommand("O");
		saveFileMenuItem = new javax.swing.JMenuItem("Save",'S');
		saveFileMenuItem.setAccelerator(KeyStroke.getKeyStroke('S',KeyEvent.CTRL_DOWN_MASK));
		saveFileMenuItem.addActionListener(this);
		saveFileMenuItem.setActionCommand("S");

		ExitMenuItem = new javax.swing.JMenuItem("Exit",'X');
		ExitMenuItem.setAccelerator(KeyStroke.getKeyStroke('X',KeyEvent.CTRL_DOWN_MASK));
		ExitMenuItem.addActionListener(this);
		ExitMenuItem.setActionCommand("X");

		jMenuItem1.setText("jMenuItem1");
		jMenuItem4.setText("jMenuItem4");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		headerTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null}
				},
				new String [] {
						"1", "2", "3", "4"
				}
				));
		headerTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setViewportView(headerTable);

		createNewInvoice.setText("Create New Invoice");
		createNewInvoice.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createNewInvoiceActionPerformed(evt);
			}
		});

		jButton2.setText("Delete Invoice");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel1.setText("Invoices Table");

		btnNewButton_1 = new JButton("cancel");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(createNewInvoice)
										.addGap(31)
										.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
										.addGap(65)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(52, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(48)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addGap(138)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(createNewInvoice, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGap(108))
				);
		jPanel1.setLayout(jPanel1Layout);

		jLabel2.setText("Invoice Number");

		jLabel3.setText("Invoice Date");

		jLabel4.setText("Customer Name");

		jLabel6.setText("Invoice Total");

		jLabel8.setText("Invoice Items");

		InsertNewItem.setText("Insert New Item");
		InsertNewItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				InsertNewItemActionPerformed(evt);
			}
		});

		DeleteItem.setText("Delete Item");
		DeleteItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteItemActionPerformed(evt);
			}
		});

		InvDatetextF.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				InvDatetextFActionPerformed(evt);
			}
		});

		LineTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null}
				},
				new String [] {
						"1", "2", "3", "4", "5"
				}
				));
		LineTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane2.setViewportView(LineTable);

		JButton btnNewButton = new JButton("cancel");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap(18, Short.MAX_VALUE)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE))
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(82)
						.addComponent(InsertNewItem, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addGap(72)
						.addComponent(DeleteItem, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGap(51))
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(33)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel4)
								.addComponent(jLabel2)
								.addComponent(jLabel6)
								.addComponent(jLabel3))
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(InvDatetextF)
								.addComponent(InvCustomerNameTestF, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)))
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(189)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel7)
								.addComponent(jLabel5))
						.addGap(440))
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(33)
						.addComponent(jLabel8)
						.addGap(531))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(35)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(jLabel5))
						.addGap(26)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(InvDatetextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(InvCustomerNameTestF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(jLabel7))
						.addGap(52)
						.addComponent(jLabel8)
						.addGap(18)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addGap(164)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(InsertNewItem, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(DeleteItem, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGap(105))
				);
		jPanel2.setLayout(jPanel2Layout);

		jMenu1.setText("File");


		loadFileMenuItem.setText("Open File");
		loadFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadFileMenuItemActionPerformed(evt);
			}
		});
		jMenu1.add(loadFileMenuItem);

		saveFileMenuItem.setText("Save File");
		saveFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveFileMenuItemActionPerformed(evt);
			}
		});
		jMenu1.add(saveFileMenuItem);

		jMenuBar1.add(jMenu1);

		ExitMenuItem = new JMenuItem("Exit");
		jMenu1.add(ExitMenuItem);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}

	public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		deleteInv();
	}

	public void InvDatetextFActionPerformed(java.awt.event.ActionEvent evt) {

	}

	public void loadFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("User clicked on Open File");
		try {
			loadfile();
		} catch (Exception ex) {
			Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void loadfile() throws Exception {
		invoices.clear();
		invoiceLines.clear();
		JOptionPane.showMessageDialog(this, "Select Invoice Header CSV File", "InvoiceHeader", JOptionPane.WARNING_MESSAGE);
		JFileChooser fc = new JFileChooser();
		int option = fc.showOpenDialog(this);
		File selectFile;
		if (option == JFileChooser.APPROVE_OPTION) 
		{
			selectFile = fc.getSelectedFile();
			FileReader fr = new FileReader(selectFile);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] headerLine = line.split(",");
				int invNum = Integer.parseInt(headerLine[0]);
				Date invdate = df.parse(headerLine[1]);
				String custName = headerLine[2];
				InvoiceHeader header = new InvoiceHeader(invNum, invdate, custName);
				invoices.add(header);
			}
			br.close();
			fr.close();
			System.out.println("Choose Invoice Header CSV File");
		}
		System.out.println("Choose Invoice Line CSV File");
		JOptionPane.showMessageDialog(this, "Select Invoice Line CSV File", "Invoice Line", JOptionPane.WARNING_MESSAGE);
		option = fc.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			selectFile = fc.getSelectedFile();
			FileReader fr = new FileReader(selectFile);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] InvoiceLines = line.split(",");
				int invNum = Integer.parseInt(InvoiceLines[0]);
				String CustomerName = InvoiceLines[1];
				double price = Double.parseDouble(InvoiceLines[2]);
				int count = Integer.parseInt(InvoiceLines[3]);
				InvoiceHeader header = findByNumHeader(invNum);
				InvoiceLine Invline = new InvoiceLine(CustomerName, price, count, header);
				header.addLine(Invline);


			}
			br.close();
			fr.close();

			headerTabelModel = new MyTableModel(invoices);
			headerTabelModel = new MyTableModel(invoices);
			headerTable.setModel(headerTabelModel);
			headerTable.validate();
		}

	}

	public InvoiceHeader findByNumHeader(int headerNum) 
	{

		for (InvoiceHeader header : invoices) 
		{
			if (header.getNum() == headerNum)
			{
				return header;
			}
		}

		return null;
	}
	public void createNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvoiceActionPerformed
		createNewINv();
	}//GEN-LAST:event_createNewInvoiceActionPerformed

	public void saveFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenuItemActionPerformed
		try {
			savefile();
		} catch (Exception ex) {
			Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
		}
	}//GEN-LAST:event_saveFileMenuItemActionPerformed

	public void InsertNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertNewItemActionPerformed
		InsertNewItems();
	}//GEN-LAST:event_InsertNewItemActionPerformed

	public void DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemActionPerformed
		deleteItem();
	}//GEN-LAST:event_DeleteItemActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) 
	{
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FileOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FileOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FileOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FileOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}


		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FileOperations().setVisible(true);
			}
		});
	}

	public javax.swing.JButton InsertNewItem;
	public javax.swing.JTextField InvCustomerNameTestF;
	public javax.swing.JTextField InvDatetextF;
	public javax.swing.JTable LineTable;
	public javax.swing.JButton createNewInvoice;
	public javax.swing.JButton DeleteItem;
	public javax.swing.JTable headerTable;
	public javax.swing.JButton jButton2;
	public javax.swing.JLabel jLabel1;
	public javax.swing.JLabel jLabel2;
	public javax.swing.JLabel jLabel3;
	public javax.swing.JLabel jLabel4;
	public javax.swing.JLabel jLabel5;
	public javax.swing.JLabel jLabel6;
	public javax.swing.JLabel jLabel7;
	public javax.swing.JLabel jLabel8;
	public javax.swing.JMenu jMenu1;
	public javax.swing.JMenuBar jMenuBar1;
	public javax.swing.JMenuItem jMenuItem1;
	public javax.swing.JMenuItem jMenuItem4;
	public javax.swing.JPanel jPanel1;
	public javax.swing.JPanel jPanel2;
	public javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JScrollPane jScrollPane2;
	public javax.swing.JMenuItem loadFileMenuItem;
	public javax.swing.JMenuItem saveFileMenuItem;
	public JButton btnNewButton_1;
	public JMenuItem ExitMenuItem;


	@Override
	public void valueChanged(ListSelectionEvent e) {
		headerRowSelect();
	}

	public void headerRowSelect() {
		int indexrow = headerTable.getSelectedRow();
		if (indexrow >= 0) {
			InvoiceHeader rowselect = headerTabelModel.getInvoices().get(indexrow);
			InvCustomerNameTestF.setText(rowselect.getCusName());
			InvDatetextF.setText(rowselect.getDate().toString());
			jLabel5.setText("" + rowselect.getNum());
			jLabel7.setText("" + rowselect.getInvTotal());
			ArrayList<InvoiceLine> lines = rowselect.getLines();
			linesTabelModel = new MyTableModel2(lines);
			LineTable.setModel(linesTabelModel);
			linesTabelModel.fireTableDataChanged();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("createOk")) {
			createOkInv();
		} else if (e.getActionCommand().equals("createcancel")) {
			cancelInvoice();
		} else if (e.getActionCommand().equals("createItemOk")) {
			createOkItem();
		} else if (e.getActionCommand().equals("createItemcancel")) {
			cancel();
		}

	}

	public void createNewINv() 
	{
		invData = new InvData(this);
		invData.setVisible(true);

	}

	public void InsertNewItems()
	{
		jLine = new InvLine(this);
		jLine.setVisible(true);
	}

	public void createOkInv() 
	{
		String customername = invData.getCustomerNameField().getText();
		String invdateString = invData.getInDateF().getText();
		Date invdate = new Date();
		try {
			@SuppressWarnings("unused")
			Date inDate = df.parse(invdateString);
		} catch (ParseException ex) {

		}
		invData.setVisible(false);

		int newNumber = getMaxNumber();
		InvoiceHeader headerNew = new InvoiceHeader(newNumber, invdate, customername);
		invoices.add(headerNew);
		headerTabelModel.fireTableDataChanged();
		System.out.println("new inv add");
	}


	public void cancelInvoice() {
		invData.setVisible(false);
	}

	public int getMaxNumber() {
		int num = 0;
		for (InvoiceHeader header : invoices) 
		{

			if (header.getNum() > num) 
			{
				num = header.getNum();
			}
		}

		return num+1;
	}



	public void deleteInv() {
		int indexrow = headerTable.getSelectedRow();
		headerTabelModel.removeRow(indexrow);
		headerTabelModel.fireTableDataChanged();
		linesTabelModel.fireTableDataChanged();

	}


	public void deleteItem() {
		int indexRow = LineTable.getSelectedRow();
		linesTabelModel.removeRow(indexRow);
		linesTabelModel.fireTableDataChanged();

	}

	public void cancel() {
		jLine.setVisible(false);
	}



	public void savefile() throws Exception {
		JOptionPane.showMessageDialog(this, "Please Chosce File Header to Save", "Invooice Header", JOptionPane.WARNING_MESSAGE);
		JFileChooser fileChoosers = new JFileChooser();
		int option = fileChoosers.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File f = fileChoosers.getSelectedFile();
			PrintWriter out = new PrintWriter(f);

			for (InvoiceHeader header : invoices) {
				out.printf(" %d , %s, %s",header.getNum(),header.getDate().toString(),header.getCusName());
				out.println();
			}
			out.close();
			JOptionPane.showMessageDialog(this, "Invoices Header has been saved", "Information", JOptionPane.INFORMATION_MESSAGE);
		}

		JOptionPane.showMessageDialog(this, "Please Chosce File Line to Save", "Invooice Line", JOptionPane.WARNING_MESSAGE);
		fileChoosers = new JFileChooser();
		option = fileChoosers.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File fe = fileChoosers.getSelectedFile();
			PrintWriter outt = new PrintWriter(fe);


			for (InvoiceHeader header : invoices) {
				for(InvoiceLine Lines : header.getLines()){
					outt.printf("%s,%s,%d",Lines.getProduct(),""+Lines.getPrice(),Lines.getCount());
					outt.println();
				}}
			outt.close();
			JOptionPane.showMessageDialog(this, "Invoices Lines has been saved", "Information", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void createOkItem() 
	{
		String itemNameS = jLine.getItemNameTF().getText();
		String itemCountS = jLine.getItemCountTF().getText();
		String itemPriceS = jLine.getItemPriceTF().getText();
		int itemCount = Integer.parseInt(itemCountS);
		double itemPrice = Double.parseDouble(itemPriceS);

		jLine.setVisible(false);

		int row = headerTable.getSelectedRow();
		if (row >= 0) {
			InvoiceHeader header = invoices.get(row);
			InvoiceLine li = new InvoiceLine(itemNameS, itemPrice, itemCount, header);
			header.addLine(li);

			linesTabelModel.fireTableDataChanged();
			headerTabelModel.fireTableDataChanged();
		}
	}


}