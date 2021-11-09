package view;

import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.EmployeeHandler;
import main.Main;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView extends View implements ActionListener{
	private static MainView mainView;
	
	JDesktopPane desktopPane;
	private CheckoutInternalView checkOutView;
	private DeleteItemCartInternalView deleteItemView;
	private LoginInternalView loginView;
	private ProductAdminInternalView storageView;
	private HumanResourceInternalView hrView;
	private ManagerInternalView managerView;
	private BaristaInternalView baristaView;
	private JMenuItem btn_logOut;
	private JMenuItem txt_name;
	
	//method untuk membuka JInternalFrame
	private void openInternalFrame(JInternalFrame frame) {
	    Dimension jInternalFrameSize = frame.getSize();
	    int width = (900 - jInternalFrameSize.width) / 2;
	    System.out.println(jInternalFrameSize.height);
	    int height = (785 - jInternalFrameSize.height)/2;
	    frame.setLocation(width, height);
	    frame.setVisible(true);
	}
	
	//method untuk membuka InternalFrame CheckOut
	public void openCheckoutFrame() {
		checkOutView.refresh();
		openInternalFrame(checkOutView);
	}
	public void refreshCheckoutFrame() {
		checkOutView.refresh();
	}
	public void visibleCheckoutFrame() {
		checkOutView.setVisible(false);
	}
	
	//method untuk membuka InternalFrame Delete Item Cart
		public void openDeleteItemCartFrame() {
			deleteItemView.refresh();
			openInternalFrame(deleteItemView);
		}
		public void refreshDeleteItemCartView() {
			deleteItemView.refresh();
		}
		public void visibleDeleteItemCartView() {
			deleteItemView.setVisible(false);
		}
	
	//method untuk membuka InternalFrame Login
	public void openLoginFrame() {
		openInternalFrame(loginView);
	}
	
	//method untuk membuka InternalFrame HumanResource
	public void openHrView() {
		openInternalFrame(hrView);
	}
	
	//method untuk membuka InternalFrame Manager
	public void openManagerView() {
		openInternalFrame(managerView);
	}
	
	//method untuk membuka InternalFrame Storage
	public void openStorageView() {
		openInternalFrame(storageView);
	}
	
	//method untuk membuka InternalFrame cashier
	public void openBaristaView() {
		baristaView.refresh();
		openInternalFrame(baristaView);
	}
	public void resetBaristaView() {
		baristaView.reset();
	}
	public void updateButtonBaristaItemCart() {
		baristaView.updateButton();
	}
	
	//method untuk menambahkan internalFrame kedalam JDesktopPane
	private void addInternalFrame() {
		desktopPane.add(loginView);
		desktopPane.add(storageView);
		desktopPane.add(baristaView);
		desktopPane.add(checkOutView);
		desktopPane.add(deleteItemView);
		desktopPane.add(hrView);
		desktopPane.add(managerView);
	}

	//method untuk menutup dan membuat object internal view baru
	public void reset() {
		loginView.setVisible(false);
		hrView.setVisible(false);
		managerView.setVisible(false);
		storageView.setVisible(false);
		baristaView.setVisible(false);
		checkOutView.setVisible(false);
		deleteItemView.setVisible(false);
		
		desktopPane.remove(loginView);
		desktopPane.remove(hrView);
		desktopPane.remove(managerView);
		desktopPane.remove(storageView);
		desktopPane.remove(baristaView);
		desktopPane.remove(checkOutView);
		desktopPane.remove(deleteItemView);
		
		loginView = new LoginInternalView();
		hrView = new HumanResourceInternalView();
		managerView = new ManagerInternalView();
		storageView = new ProductAdminInternalView();
		baristaView = BaristaInternalView.getInstance();
		checkOutView = new CheckoutInternalView();
		deleteItemView = new DeleteItemCartInternalView();
		
		addInternalFrame();
	}
	
	//method untuk mengassign nama account yang terlogin pada bagian menu account
	public void setAccountName(String name) {
		txt_name.setText(name);
	}
	
	private MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Coffee Vibes");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		setBounds(new Rectangle(0, 23, 900, 795));
		
		desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 888, 22);
		desktopPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Account");
		menuBar.add(mnNewMenu);
		
		txt_name = new JMenuItem("Not Logged In");
		txt_name.setEnabled(false);
		mnNewMenu.add(txt_name);
		
		btn_logOut = new JMenuItem("Log out");
		mnNewMenu.add(btn_logOut);
		btn_logOut.addActionListener(this);
		
		loginView = new LoginInternalView();
		hrView = new HumanResourceInternalView();
		managerView = new ManagerInternalView();
		storageView = new ProductAdminInternalView();
		baristaView = BaristaInternalView.getInstance();
		checkOutView = new CheckoutInternalView();
		deleteItemView = new DeleteItemCartInternalView();
		
		addInternalFrame();
		openLoginFrame();
	}
	
	public static synchronized MainView getInstance() {
		return (mainView==null) ? mainView = new MainView() : mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_logOut) {
			EmployeeHandler.getInstance().logout();
		}
		
	}
}
