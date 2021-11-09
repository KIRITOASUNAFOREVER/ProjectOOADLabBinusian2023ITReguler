package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.EmployeeHandler;
import controller.ProductHandler;
import controller.RoleHandler;
import controller.VoucherHandler;
import model.EmployeeModel;
import model.Model;
import model.ProductModel;
import model.RoleModel;
import model.VoucherModel;

public class ProductAdminInternalView extends JInternalFrame implements ActionListener {
	
	private JTable tbl_data;
	private JTextField txt_price;
	private JTextField txt_name;
	private JTextField txt_stock;
	private JTextField txt_updPrice;
	private JTextField txt_updName;
	private JTextField txt_delPrice;
	private JTextField txt_delName;
	private JTextField txt_delStock;
	private JTextArea txt_description;
	private JButton btn_insert;
	private JComboBox cb_updID;
	private JTextArea txt_updDesc;
	private JButton btn_update;
	private JComboBox cb_delID;
	private JTextArea txt_delDesc;
	private JButton btn_delete;
	private JTextField txt_stkStock;
	private JTextField txt_stkName;
	private JTextField txt_stkNewStock;
	private JButton btn_addStock;
	private JComboBox cb_stkID;
	private JTextArea txt_stkDesc;
	
	private JTable tbl_dataVoucher;
	private JTextField txt_discount;
	private JTextField txt_updDiscount;
	private JTextField txt_delDiscount;
	private JComboBox cb_date;
	private JComboBox cb_month;
	private JComboBox cb_year;
	private JButton btn_insertVoucher;
	private JComboBox cb_updVoucherID;
	private JComboBox cb_updDate;
	private JComboBox cb_updMonth;
	private JComboBox cb_updYear;
	private JButton btn_updateVoucher;
	private JComboBox cb_delVoucherID;
	private JTextField txt_delDate;
	private JTextField txt_validDate;
	private JButton btn_deleteVoucher;

	public ProductAdminInternalView() {
		setBounds(0, 0, 759, 735);
		setTitle("Product Admin");
		getContentPane().setLayout(null);
		
		JPanel container = new JPanel();
		container.setBounds(0, 0, 751, 741);
		getContentPane().add(container);
		container.setLayout(null);
		
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanel.setBounds(0, 0, 751, 735);
		container.add(tabbedPanel);
		
		JPanel employeeTab = new JPanel();
		tabbedPanel.addTab("Product Management", null, employeeTab, null);
		employeeTab.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 730, 262);
		employeeTab.add(scrollPane);
		
		tbl_data = new JTable();
		scrollPane.setViewportView(tbl_data);
		
		JPanel insertTab = new JPanel();
		insertTab.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 280, 730, 397);
		employeeTab.add(tabbedPane);
	
		insertTab.setLayout(null);
		tabbedPane.addTab("Add New Product", null, insertTab, null);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProductName.setBounds(199, 46, 97, 16);
		insertTab.add(lblProductName);

		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(325, 41, 194, 26);
		insertTab.add(txt_name);
		
		JLabel lblDescription = new JLabel("Product Description");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(171, 84, 125, 16);
		insertTab.add(lblDescription);
		
		txt_description = new JTextArea();
		txt_description.setLineWrap(true);
		insertTab.add(txt_description);
		
		JLabel lblNewLabel_2 = new JLabel("Product Price");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(150, 179, 146, 16);
		insertTab.add(lblNewLabel_2);
		
		txt_price = new JTextField();
		txt_price.setColumns(10);
		txt_price.setBounds(325, 174, 194, 26);
		insertTab.add(txt_price);
		
		JLabel lblNewLabel_2_1 = new JLabel("Product Stock");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(188, 220, 108, 16);
		insertTab.add(lblNewLabel_2_1);
		
		txt_stock = new JTextField();
		txt_stock.setColumns(10);
		txt_stock.setBounds(325, 215, 194, 26);
		insertTab.add(txt_stock);
		
		btn_insert = new JButton("Add New Product");
		btn_insert.setBounds(272, 264, 175, 29);
		insertTab.add(btn_insert);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(329, 84, 187, 72);
		insertTab.add(scrollPane_1);
		
		txt_description = new JTextArea();
		txt_description.setLineWrap(true);
		scrollPane_1.setViewportView(txt_description);
		
		JPanel updateTab = new JPanel();
		tabbedPane.addTab("Update Product", null, updateTab, null);
		updateTab.setLayout(null);
		
		JLabel lblProductName_1 = new JLabel("Product Name");
		lblProductName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProductName_1.setBounds(191, 90, 97, 16);
		updateTab.add(lblProductName_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Product Price");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setBounds(142, 223, 146, 16);
		updateTab.add(lblNewLabel_2_2);
		
		txt_updPrice = new JTextField();
		txt_updPrice.setColumns(10);
		txt_updPrice.setBounds(317, 218, 194, 26);
		updateTab.add(txt_updPrice);
		
		txt_updName = new JTextField();
		txt_updName.setColumns(10);
		txt_updName.setBounds(317, 85, 194, 26);
		updateTab.add(txt_updName);
		
		JLabel lblDescription_1 = new JLabel("Product Description");
		lblDescription_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription_1.setBounds(163, 128, 125, 16);
		updateTab.add(lblDescription_1);
		
		btn_update = new JButton("Update product");
		btn_update.setBounds(268, 265, 175, 29);
		updateTab.add(btn_update);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Product ID");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1.setBounds(207, 48, 81, 16);
		updateTab.add(lblNewLabel_2_1_1_1);
		
		cb_updID = new JComboBox();
		cb_updID.setBounds(316, 43, 197, 26);
		updateTab.add(cb_updID);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(321, 128, 187, 72);
		updateTab.add(scrollPane_2);
		
		txt_updDesc = new JTextArea();
		txt_updDesc.setLineWrap(true);
		scrollPane_2.setViewportView(txt_updDesc);
		
		JPanel deleteTab = new JPanel();
		deleteTab.setLayout(null);
		tabbedPane.addTab("Delete Product", null, deleteTab, null);
		
		JLabel lblProductName_1_1 = new JLabel("Product Name");
		lblProductName_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProductName_1_1.setBounds(192, 68, 97, 16);
		deleteTab.add(lblProductName_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Product Price");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_1.setBounds(143, 202, 146, 16);
		deleteTab.add(lblNewLabel_2_2_1);
		
		txt_delPrice = new JTextField();
		txt_delPrice.setEditable(false);
		txt_delPrice.setBounds(318, 197, 194, 26);
		deleteTab.add(txt_delPrice);
		
		txt_delName = new JTextField();
		txt_delName.setEditable(false);
		txt_delName.setBounds(318, 63, 194, 26);
		deleteTab.add(txt_delName);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Product Stock");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_2.setBounds(181, 243, 108, 16);
		deleteTab.add(lblNewLabel_2_1_1_2);
		
		txt_delStock = new JTextField();
		txt_delStock.setEditable(false);
		txt_delStock.setBounds(318, 238, 194, 26);
		deleteTab.add(txt_delStock);
		
		JLabel lblDescription_1_1 = new JLabel("Product Description");
		lblDescription_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription_1_1.setBounds(164, 106, 125, 16);
		deleteTab.add(lblDescription_1_1);
		
		btn_delete = new JButton("Delete Product");
		btn_delete.setBounds(269, 279, 175, 29);
		deleteTab.add(btn_delete);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Product ID");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1_1.setBounds(208, 26, 81, 16);
		deleteTab.add(lblNewLabel_2_1_1_1_1);
		
		cb_delID = new JComboBox();
		cb_delID.setBounds(317, 21, 197, 26);
		deleteTab.add(cb_delID);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(322, 107, 187, 72);
		deleteTab.add(scrollPane_3);
		
		txt_delDesc = new JTextArea();
		txt_delDesc.setLineWrap(true);
		txt_delDesc.setEditable(false);
		scrollPane_3.setViewportView(txt_delDesc);
		
		btn_delete.addActionListener(this);
		btn_insert.addActionListener(this);
		btn_update.addActionListener(this);
		cb_delID.addActionListener(this);
		cb_updID.addActionListener(this);
		
		fillTable(tbl_data);
		fillIdComboBox(cb_delID);
		fillIdComboBox(cb_updID);
		refreshUpdateCombo(cb_updID, txt_updName, txt_updDesc, txt_updPrice);
		refreshDeleteCombo(cb_delID, txt_delName, txt_delDesc, txt_delPrice, txt_delStock);
		
		JPanel voucherTab = new JPanel();
		tabbedPanel.addTab("Voucher Management", null, voucherTab, null);
		voucherTab.setLayout(null);
		
		JScrollPane scrollPanels = new JScrollPane();
		scrollPanels.setBounds(6, 6, 730, 262);
		voucherTab.add(scrollPanels);
		
		tbl_dataVoucher = new JTable();
		scrollPanels.setViewportView(tbl_dataVoucher);
		
		JPanel insertTabs = new JPanel();
		insertTabs.setLayout(null);
		
		JTabbedPane tabbedsPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedsPane.setBounds(6, 280, 730, 397);
		voucherTab.add(tabbedsPane);
	
		insertTabs.setLayout(null);
		tabbedsPane.addTab("Generate Voucher", null, insertTabs, null);
		
		JLabel lblNewLabel_2_10 = new JLabel("Discount (1-100)%");
		lblNewLabel_2_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_10.setBounds(128, 117, 130, 16);
		insertTabs.add(lblNewLabel_2_10);
		
		txt_discount = new JTextField();
		txt_discount.setColumns(10);
		txt_discount.setBounds(287, 112, 194, 26);
		insertTabs.add(txt_discount);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Valid Date");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2.setBounds(150, 163, 108, 16);
		insertTabs.add(lblNewLabel_2_1_2);
		
		btn_insertVoucher = new JButton("Generate New Voucher");
		btn_insertVoucher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_insertVoucher.setBounds(266, 204, 175, 29);
		insertTabs.add(btn_insertVoucher);
		
		cb_date = new JComboBox();
		cb_date.setBounds(287, 159, 79, 27);
		cb_date.setModel(new DefaultComboBoxModel(new String[] {"Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		insertTabs.add(cb_date);
		
		cb_month = new JComboBox();
		cb_month.setBounds(366, 159, 116, 27);
		cb_month.setModel(new DefaultComboBoxModel(new String[] {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		insertTabs.add(cb_month);
		
		cb_year = new JComboBox();
		cb_year.setBounds(482, 159, 77, 27);
		cb_year.setModel(new DefaultComboBoxModel(new String[] {"Year", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059"}));
		insertTabs.add(cb_year);
		
		JPanel updateVoucherTab = new JPanel();
		tabbedsPane.addTab("Update Voucher", null, updateVoucherTab, null);
		updateVoucherTab.setLayout(null);
		
		JLabel lblNewLabel_2_1_1_1_7 = new JLabel("Voucher ID");
		lblNewLabel_2_1_1_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1_7.setBounds(155, 97, 108, 16);
		updateVoucherTab.add(lblNewLabel_2_1_1_1_7);
		
		cb_updVoucherID = new JComboBox();
		cb_updVoucherID.setBounds(290, 93, 197, 26);
		updateVoucherTab.add(cb_updVoucherID);
		
		JLabel lblNewLabel_2_2_8 = new JLabel("Discount (1-100)%");
		lblNewLabel_2_2_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_8.setBounds(134, 141, 129, 16);
		updateVoucherTab.add(lblNewLabel_2_2_8);
		
		txt_updDiscount = new JTextField();
		txt_updDiscount.setColumns(10);
		txt_updDiscount.setBounds(292, 136, 194, 26);
		updateVoucherTab.add(txt_updDiscount);
		
		JLabel lblNewLabel_2_1_1_9 = new JLabel("Valid Date");
		lblNewLabel_2_1_1_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_9.setBounds(155, 187, 108, 16);
		updateVoucherTab.add(lblNewLabel_2_1_1_9);
		
		btn_updateVoucher = new JButton("Update Voucher");
		btn_updateVoucher.setBounds(266, 234, 175, 29);
		updateVoucherTab.add(btn_updateVoucher);
		
		cb_updDate = new JComboBox();
		cb_updDate.setBounds(292, 183, 79, 27);
		cb_updDate.setModel(new DefaultComboBoxModel(new String[] {"Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		updateVoucherTab.add(cb_updDate);
		
		cb_updMonth = new JComboBox();
		cb_updMonth.setBounds(371, 183, 116, 27);
		cb_updMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		updateVoucherTab.add(cb_updMonth);
		
		cb_updYear = new JComboBox();
		cb_updYear.setBounds(487, 183, 77, 27);
		cb_updYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059"}));
		updateVoucherTab.add(cb_updYear);
		
		JPanel deleteVoucherTab = new JPanel();
		deleteVoucherTab.setLayout(null);
		tabbedsPane.addTab("Delete Voucher", null, deleteVoucherTab, null);
		
		JLabel lblNewLabels_2_1_1_1_1 = new JLabel("Voucher ID");
		lblNewLabels_2_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabels_2_1_1_1_1.setBounds(168, 97, 108, 16);
		deleteVoucherTab.add(lblNewLabels_2_1_1_1_1);
		
		cb_delVoucherID = new JComboBox();
		cb_delVoucherID.setBounds(303, 93, 197, 26);
		deleteVoucherTab.add(cb_delVoucherID);
		
		btn_deleteVoucher = new JButton("Delete Voucher");
		btn_deleteVoucher.setBounds(273, 233, 175, 29);
		deleteVoucherTab.add(btn_deleteVoucher);
		
		btn_insertVoucher.addActionListener(this);
		btn_updateVoucher.addActionListener(this);
		cb_updVoucherID.addActionListener(this);
		btn_deleteVoucher.addActionListener(this);
		cb_delVoucherID.addActionListener(this);
		
		fillIdComboBox1(cb_updVoucherID);
		fillIdComboBox1(cb_delVoucherID);
		
		fillVoucherTable(tbl_dataVoucher);
		refreshCombo(cb_updVoucherID, txt_updDiscount, cb_updDate, cb_updMonth, cb_updYear);
	}

		//method untuk mengambil data dari database dan mengisi JTable dengan data tersebut
		private void fillVoucherTable(JTable table) {
			List<Model> data = VoucherHandler.getInstance().getAllData();
			Vector<String> tableColumn = new Vector<String>();
			tableColumn.add("ID");
			tableColumn.add("Discount");
			tableColumn.add("Valid Date");
			tableColumn.add("Status");
			
			DefaultTableModel model = new DefaultTableModel(tableColumn,0){
				public boolean isCellEditable(int row, int column)
			    {
			      return false;
			    }
			};
			for (Model d : data) {
				Vector<Object> e = new Vector<Object>();
				e.add( ((VoucherModel)d).getId() );
				e.add( ((VoucherModel)d).getDiscount() );
				e.add( ((VoucherModel)d).getValidDate().toString() );
				e.add( ((VoucherModel)d).getStatus() );
				
				
				model.addRow(e);
				
			}
			table.setModel(model);
		}
		
	
	//method untuk mengambil data dari database dan mengisi JTable dengan data tersebut
	private void fillTable(JTable table) {
		List<Model> data = ProductHandler.getInstance().getAllData();
		Vector<String> tableColumn = new Vector<String>();
		tableColumn.add("ID");
		tableColumn.add("Product Name");
		tableColumn.add("Description");
		tableColumn.add("Price");
		tableColumn.add("Stock");
		DefaultTableModel model = new DefaultTableModel(tableColumn,0){
			public boolean isCellEditable(int row, int column)
		    {
		      return false;
		    }
		};
		for (Model d : data) {
			Vector<Object> e = new Vector<Object>();
			e.add( ((ProductModel)d).getId() );
			e.add(((ProductModel)d).getName());
			e.add(((ProductModel)d).getDescription());
			e.add(((ProductModel)d).getPrice());
			e.add(((ProductModel)d).getStock());
			model.addRow(e);
		}
		table.setModel(model);
	}
	
	//method untuk mengisi comboBox dengan id product yang ada
	private void fillIdComboBox(JComboBox cb) {
		List<Model> data = ProductHandler.getInstance().getAllData();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for (Model x : data) {
			model.addElement(Integer.toString(x.getId()));
		}
		cb.setModel(model);
	}
	
	//method untuk mengisi comboBox dengan id voucher yang ada
		private void fillIdComboBox1(JComboBox cb) {
			List<Model> data = VoucherHandler.getInstance().getAllData();
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
			for (Model x : data) {
				model.addElement(Integer.toString(x.getId()));
			}
			cb.setModel(model);
		}

	//method untuk melakukan update isi pada textfield yang ada pada menu restock jika ada perubahan pada comboBox id pada menu restock
	private void refreshStkCombo(JComboBox cb, JTextField txt_name, JTextArea txt_desc, JTextField txt_currStock ) {
		if(cb.getSelectedItem() != null) {			
			int id = Integer.parseInt(cb.getSelectedItem().toString());
			Model data = ProductHandler.getInstance().find(id);
			txt_name.setText(((ProductModel)data).getName());
			txt_desc.setText(((ProductModel)data).getDescription());
			txt_currStock.setText(Integer.toString(((ProductModel)data).getStock()));
		}
	}
	
	//method untuk melakukan update isi pada textfield yang ada pada menu update jika ada perubahan pada comboBox id pada menu update
	private void refreshUpdateCombo(JComboBox cb, JTextField txt_name, JTextArea txt_desc, JTextField txt_price ) {
		if(cb.getSelectedItem()!=null) {			
			int id = Integer.parseInt(cb.getSelectedItem().toString());
			Model data = ProductHandler.getInstance().find(id);
			txt_name.setText(((ProductModel)data).getName());
			txt_desc.setText(((ProductModel)data).getDescription());
			txt_price.setText(Integer.toString(((ProductModel)data).getPrice()));
		}
	}
	
	//method untuk melakukan update isi pada textfield yang ada pada menu delete jika ada perubahan pada comboBox id pada menu delete
	private void refreshDeleteCombo(JComboBox cb, JTextField txt_name, JTextArea txt_desc, JTextField txt_price, JTextField txt_stock ) {
		if(cb.getSelectedItem()!=null) {			
			int id = Integer.parseInt(cb.getSelectedItem().toString());
			Model data = ProductHandler.getInstance().find(id);
			txt_name.setText(((ProductModel)data).getName());
			txt_desc.setText(((ProductModel)data).getDescription());
			txt_price.setText(Integer.toString(((ProductModel)data).getPrice()));
			txt_stock.setText(Integer.toString(((ProductModel)data).getStock()));
		}
	}
	
	//method untuk melakukan update isi pada textfield yang ada pada menu update jika ada perubahan pada comboBox id pada menu update
		private void refreshCombo(JComboBox cb, JTextField txt_discount, JComboBox cb_date, JComboBox cb_month, JComboBox cb_year) {
			if(cb.getSelectedItem()!=null) {			
				int id = Integer.parseInt(cb.getSelectedItem().toString());
				Model data = VoucherHandler.getInstance().find(id);
				
				long discount = ((VoucherModel)data).getDiscount().longValue();
				txt_discount.setText(Long.toString(discount));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(((VoucherModel)data).getValidDate());
				
				cb_date.setSelectedItem(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
				cb_month.setSelectedIndex(cal.get(Calendar.MONTH)+1);
				cb_year.setSelectedItem(Integer.toString(cal.get(Calendar.YEAR)));
			}
		}
	
	//method untuk validasi data voucher pada saat insert voucher
		private Boolean validateVoucherInsert(String discount, String date) {
			VoucherHandler controller = VoucherHandler.getInstance();
			if(controller.checkDiscount(discount)==false) {
				JOptionPane.showMessageDialog(this, "Discount cannot be empty, must be in numeric, and must be between 1-100(inclusive)!");
				return false;
			}
			if(controller.checkDate(date)==false) {
				JOptionPane.showMessageDialog(this, "Date must be in the future!");
				return false;
			}
			return true;
		}
	
	//method untuk validasi data product baru pada saat insert data
	private Boolean validateInsert(String name, String desc, String price, String stock) {
		ProductHandler controller = ProductHandler.getInstance();
		if(!controller.checkName(name)) {
			JOptionPane.showMessageDialog(this, "Name cannot be empty!");
			return false;
		}
		if(!controller.checkDesc(desc)) {
			JOptionPane.showMessageDialog(this, "Description cannot be empty");
			return false;
		}
		if(!controller.checkPrice(price)) {
			JOptionPane.showMessageDialog(this, "Price must be numeric and above zero!");
			return false;
		}
		if(!controller.checkStock(stock)) {
			JOptionPane.showMessageDialog(this, "Stock must be numeric and above zero!");
			return false;
		}
		return true;
	}
	
	//method untuk validasi data product baru pada saat update data
	private Boolean validateUpdate(String id, String name, String desc, String price) {
		ProductHandler controller = ProductHandler.getInstance();
		if(!controller.checkID(Integer.parseInt(id))) {
			JOptionPane.showMessageDialog(this, "ID cannot be null and must be exist!");
		}
		if(!controller.checkName(name)) {
			JOptionPane.showMessageDialog(this, "Name cannot be empty!");
			return false;
		}
		if(!controller.checkDesc(desc)) {
			JOptionPane.showMessageDialog(this, "Description cannot be empty");
			return false;
		}
		if(!controller.checkPrice(price)) {
			JOptionPane.showMessageDialog(this, "Price must be numeric and above zero!");
			return false;
		}
		return true;
	}
	
	//method untuk validasi data voucher pada saat update voucher
		private Boolean validateVoucherUpdate(int voucherID, String discount, String date) {
			VoucherHandler controller = VoucherHandler.getInstance();
			if(controller.checkUsed(voucherID)) {
				JOptionPane.showMessageDialog(this, "Used voucher cannot be deleted!");
				return false;
			}
			if(controller.checkID(voucherID)==false) {
				JOptionPane.showMessageDialog(this, "Voucher id must be exist!");
				return false;
			}
			if(controller.checkDiscount(discount)==false) {
				JOptionPane.showMessageDialog(this, "Discount cannot be empty, must be in numeric, and must be between 1-100(inclusive)!");
				return false;
			}
			if(controller.checkDate(date)==false) {
				JOptionPane.showMessageDialog(this, "Date must be in the future!");
				return false;
			}
			return true;
		}
	
	//method untuk validasi data product id pada saat delete data 
	private boolean validateDelete(String id) {
		ProductHandler controller = ProductHandler.getInstance();
		if(!controller.checkID(Integer.parseInt(id))) {
			JOptionPane.showMessageDialog(this, "ID cannot be null and must be exist!");
		}
		return true;
	}
	
	//method untuk validasi data voucher id pada saat delete voucher
		private Boolean validateVoucherDelete(int voucherID) {
			if(VoucherHandler.getInstance().checkUsed(voucherID)) {
				JOptionPane.showMessageDialog(this, "Used voucher cannot be deleted!");
			}
			if(!VoucherHandler.getInstance().checkID(voucherID)) {
				JOptionPane.showMessageDialog(this, "Voucher id must be exist!");
				return false;
			}
			return true;
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_insert) {
			//jika tombol insert ditekan
			String name = txt_name.getText();
			String desc = txt_description.getText();
			String price = txt_price.getText();
			String stock = txt_stock.getText();
			if(validateInsert(name, desc, price, stock)) {
				ProductModel res = ProductHandler.getInstance().insertData(name, desc, Integer.parseInt(price), Integer.parseInt(stock));
				if(res!=null) {
					JOptionPane.showMessageDialog(this, "Add new product success!");
					fillTable(tbl_data);
					fillIdComboBox(cb_delID);
					fillIdComboBox(cb_updID);
					fillIdComboBox(cb_stkID);
					refreshStkCombo(cb_stkID, txt_stkName, txt_stkDesc, txt_stkStock);
					refreshUpdateCombo(cb_updID, txt_updName, txt_updDesc, txt_updPrice);
					refreshDeleteCombo(cb_delID, txt_delName, txt_delDesc, txt_delPrice, txt_delStock);
				}
				else {
					JOptionPane.showMessageDialog(this, "Add new product failed!");
				}
			}
		}
		
		if(e.getSource() == btn_update) {
			//jika tombol update ditekan
			String id = cb_updID.getSelectedItem().toString();
			String name = txt_updName.getText();
			String desc = txt_updDesc.getText();
			String price = txt_updPrice.getText();
			if(validateUpdate(id, name, desc, price)) {
				ProductModel item = (ProductModel) ProductHandler.getInstance().find(Integer.parseInt(id));
				ProductModel res = ProductHandler.getInstance().updateData(Integer.parseInt(id), name, desc, Integer.parseInt(price), item.getStock());
				if(res!=null) {
					JOptionPane.showMessageDialog(this, "Update product success!");
					fillTable(tbl_data);
					fillIdComboBox(cb_delID);
					fillIdComboBox(cb_updID);
					fillIdComboBox(cb_stkID);
					refreshStkCombo(cb_stkID, txt_stkName, txt_stkDesc, txt_stkStock);
					refreshUpdateCombo(cb_updID, txt_updName, txt_updDesc, txt_updPrice);
					refreshDeleteCombo(cb_delID, txt_delName, txt_delDesc, txt_delPrice, txt_delStock);
				}
				else {
					JOptionPane.showMessageDialog(this, "Update product failed!");
				}
			}
		}
		
		if(e.getSource() == btn_delete) {
			//jika tombol delete ditekan
			ProductHandler controller = ProductHandler.getInstance();
			String id = cb_delID.getSelectedItem().toString();
			int confirm = JOptionPane.showConfirmDialog(this, "Delete this product?");
			if(confirm==0) {				
				if (validateDelete(id)) {
					if(controller.deleteData(Integer.parseInt(id))) {
						JOptionPane.showMessageDialog(this, "Delete success!");
						fillTable(tbl_data);
						fillIdComboBox(cb_delID);
						fillIdComboBox(cb_updID);
						fillIdComboBox(cb_stkID);
						refreshStkCombo(cb_stkID, txt_stkName, txt_stkDesc, txt_stkStock);
						refreshUpdateCombo(cb_updID, txt_updName, txt_updDesc, txt_updPrice);
						refreshDeleteCombo(cb_delID, txt_delName, txt_delDesc, txt_delPrice, txt_delStock);
					}
					else {
						JOptionPane.showMessageDialog(this, "Delete fail!");
					}
				}
			}
		}
		
		if(e.getSource()==btn_insertVoucher) {
			//jika tombol insert ditekan
			String discount = txt_discount.getText();
			String date = cb_year.getSelectedItem().toString();
			date = date.concat("-"+cb_month.getSelectedIndex());
			date = date.concat("-"+cb_date.getSelectedItem().toString());
			if(validateVoucherInsert(discount, date)) {
				VoucherModel res = VoucherHandler.getInstance().insertData(Float.parseFloat(discount), date);
				if(res!=null) {
					JOptionPane.showMessageDialog(this, "Create success!\nVoucher ID = "+res.getId()+"\nDiscount = "+res.getDiscount()+"%");
					fillVoucherTable(tbl_dataVoucher);
					fillIdComboBox1(cb_delVoucherID);
					fillIdComboBox1(cb_updVoucherID);
					
					
					refreshCombo(cb_updVoucherID, txt_updDiscount, cb_updDate, cb_updMonth, cb_updYear);
				}
				else {
					JOptionPane.showMessageDialog(this, "Create Voucher fail!");
				}
			}
		}
		
		if(e.getSource()==btn_updateVoucher) {
			//jika tombol update ditekan
			System.out.println(cb_updVoucherID.getSelectedItem().toString());
			int voucherID = Integer.parseInt(cb_updVoucherID.getSelectedItem().toString());
			String discount = txt_updDiscount.getText();
			String date = cb_updYear.getSelectedItem().toString();
			date = date.concat("-"+cb_updMonth.getSelectedIndex());
			date = date.concat("-"+cb_updDate.getSelectedItem().toString());
			if(validateVoucherUpdate(voucherID, discount, date)) {
				VoucherModel res = VoucherHandler.getInstance().updateData(voucherID, Float.parseFloat(discount), date);
				if(res!=null) {
					JOptionPane.showMessageDialog(this, "Update success!");
					fillVoucherTable(tbl_dataVoucher);
					fillIdComboBox1(cb_delVoucherID);
					fillIdComboBox1(cb_updVoucherID);
					refreshCombo(cb_updVoucherID, txt_updDiscount, cb_updDate, cb_updMonth, cb_updYear);
				}
				else {
					JOptionPane.showMessageDialog(this, "Update fail!");
				}
			}
		}
		
		if(e.getSource()==btn_deleteVoucher) {
			//jika tombol delete ditekan
			int voucherID = Integer.parseInt(cb_delVoucherID.getSelectedItem().toString());
			
			int confirm = JOptionPane.showConfirmDialog(this, "Delete this voucher?");
			if(confirm==0) {
				if(validateVoucherDelete(voucherID)) {	
					if(VoucherHandler.getInstance().deleteData(voucherID)) {
						JOptionPane.showMessageDialog(this, "Delete success!");
						fillVoucherTable(tbl_dataVoucher);
						fillIdComboBox1(cb_delVoucherID);
						fillIdComboBox1(cb_updVoucherID);
						
						refreshCombo(cb_updVoucherID, txt_updDiscount, cb_updDate, cb_updMonth, cb_updYear);
					}
					else {
						JOptionPane.showMessageDialog(this, "Delete fail!");
					}
				}
			}
		}
		
		if(e.getSource() == cb_updID) {
			//jika terjadi perubahan pilihan pada comboBox id pada menu update
			refreshUpdateCombo(cb_updID, txt_updName, txt_updDesc, txt_updPrice);
		}
		
		if(e.getSource() == cb_delID) {
			//jika terjadi perubahan pilihan pada comboBox id pada menu delete
			refreshDeleteCombo(cb_delID, txt_delName, txt_delDesc, txt_delPrice, txt_delStock);
		}
		
		if(e.getSource()==cb_updVoucherID) {
			//jika terjadi perubahan pilihan pada comboBox id pada menu update
			refreshCombo(cb_updID, txt_updDiscount, cb_updDate, cb_updMonth, cb_updYear);
		}
	}

	
}
