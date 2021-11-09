package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.CartHandler;
import controller.EmployeeHandler;
import controller.ProductHandler;
import controller.TransactionHandler;
import model.CartModel;
import model.Model;
import model.ProductModel;
import model.TransactionModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import view.MainView;

public class DeleteItemCartInternalView extends JInternalFrame implements ActionListener, MouseListener{
	private JTable tbl_data;
	private JButton btn_delete;
	private JComboBox cb_delName;
	private JTextField txt_name;

	public DeleteItemCartInternalView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Barista - Delete Item Cart");
		setBounds(0, 0, 691, 521);
		getContentPane().setLayout(null);
		
		JPanel container = new JPanel();
		container.setLayout(null);
		container.setBounds(0, 0, 683, 492);
		getContentPane().add(container);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 667, 212);
		container.add(scrollPane);
		
		tbl_data = new JTable();
		scrollPane.setViewportView(tbl_data);
		
		btn_delete = new JButton("Delete From Cart");
		btn_delete.setBounds(269, 320, 175, 29);
		container.add(btn_delete);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Product name");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1_1.setBounds(208, 269, 81, 16);
		container.add(lblNewLabel_2_1_1_1_1);
		
		cb_delName = new JComboBox();
		cb_delName.setBounds(325, 269, 81, 16);
		container.add(cb_delName);
		
		refresh();
		btn_delete.addActionListener(this);
		cb_delName.addMouseListener(this);
	}
	
	//method untuk mengambil data dari database dan mengisi JTable dengan data tersebut
	private void fillTable() {
		List<CartModel> data = CartHandler.getInstance().getCartList();
		System.out.println(CartHandler.getInstance());
		Vector<String> tableColumn = new Vector<String>();
		tableColumn.add("Product ID");
		tableColumn.add("Product Name");
		tableColumn.add("Unit Price");
		tableColumn.add("Quantity");
		tableColumn.add("Price");
		DefaultTableModel model = new DefaultTableModel(tableColumn,0){
			public boolean isCellEditable(int row, int column)
		    {
		      return false;
		    }
		};
		for (CartModel d : data) {
			Vector<Object> e = new Vector<Object>();
			ProductModel item = d.getProduct();
			e.add(item.getId());
			e.add(item.getName());
			e.add(item.getPrice());
			e.add(d.getQuantity());
			int price = item.getPrice() * d.getQuantity();
			e.add(price);
			
			model.addRow(e);
			
		}
		tbl_data.setModel(model);
	}

	//method untuk mengembalikan tampilan ke tampilan awal dan mengisi ulang JTable dengan data terbaru
	public void refresh() {
		fillTable();
	}
	
	//method untuk mengisi comboBox dengan id product yang ada
		private void fillIdComboBox(JComboBox cb) {
			List<CartModel> data = CartHandler.getInstance().getCartList();
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
			for (CartModel x : data) {
				ProductModel item = x.getProduct();
				model.addElement(item.getName());
			}
			cb.setModel(model);
		}
	
		//method untuk validasi data product name pada saat delete data 
		private boolean validateDelete(String name) {
			CartHandler controller = CartHandler.getInstance();
			
			if(!controller.checkName(name)) {
				JOptionPane.showMessageDialog(this, "Name cannot be null and must be exist!");
			}
			return true;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_delete) {
			//jika tombol delete ditekan
			String name = cb_delName.getSelectedItem().toString();
			int confirm = JOptionPane.showConfirmDialog(this, "Delete From Cart?");
			if(confirm==0) {
				List<CartModel> items = CartHandler.getInstance().getCartList();
				for(int i = 0; i<items.size(); i++)
				{
					if(items.get(i).getProduct().getName() == name)
					{
						items.remove(i);
						JOptionPane.showMessageDialog(null, "Removed Successfully...");
						break;
					}
				}
			}
			fillTable();
			List<CartModel> items = CartHandler.getInstance().getCartList();
			if(items.size()==0) {
				BaristaInternalView.getInstance().reset();
				MainView.getInstance().refreshCheckoutFrame();
				JOptionPane.showMessageDialog(null, "No More Item to Delete!!!");
				MainView.getInstance().visibleCheckoutFrame();
				MainView.getInstance().updateButtonBaristaItemCart();
				this.setVisible(false);
			}else {
				int confirms = JOptionPane.showConfirmDialog(this, "Do you want to delete more items?");
				if(confirms==0) {
					BaristaInternalView.getInstance().reset();
					MainView.getInstance().refreshCheckoutFrame();
				}else {
					BaristaInternalView.getInstance().reset();
					MainView.getInstance().refreshCheckoutFrame();
					this.setVisible(false);
				}
			}
		}
		
	}
	
	public void windowClosing(WindowEvent e) {
		MainView.getInstance().resetBaristaView();
		MainView.getInstance().refreshCheckoutFrame();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cb_delName) {
			refresh();
			fillIdComboBox(cb_delName);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
