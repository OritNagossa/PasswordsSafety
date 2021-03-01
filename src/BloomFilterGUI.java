

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;

public class BloomFilterGUI {

	private static final int N = 100;
    static BloomFilter bf = new BloomFilter(N,7);
	
	PasswordApp p = new PasswordApp(bf);

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloomFilterGUI window = new BloomFilterGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BloomFilterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		JFrame frame1 = new JFrame();
		frame1.setBounds(100, 100, 880, 411);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 1057, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton b1 = new JButton("1.Show bits state");
		b1.setBounds(361, 126, 253, 36);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,bf.toString());
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(b1);
		
		
		JButton b2 = new JButton("2. Insert new password");
		b2.setBounds(361, 178, 253, 36);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	passwordFr  passF = new passwordFr(p);
				//passF.setVisible(true);
				String pass = JOptionPane.showInputDialog(frame, "Enter Password", null);
				
				JOptionPane.
				
				showMessageDialog(null,p.isStrong(pass));

			}
		});
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		frame.getContentPane().add(layeredPane);
		frame.getContentPane().add(b2);
		
		JButton b3 = new JButton("3. Check if password exist");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = JOptionPane.showInputDialog(frame, "Enter Password To Check", null);
				//bf.contain(pass)
				if(bf.contain(pass))
				JOptionPane.showMessageDialog(null,"Password exist");
				else	
					JOptionPane.showMessageDialog(null,"Password Doesn't exist ");


				
				
				
			}
		});
		b3.setBounds(361, 231, 253, 36);
		frame.getContentPane().add(b3);
		
		JButton b4 = new JButton("4. Number of hash collisions ");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = JOptionPane.showInputDialog(frame, "Enter Password ", null);
				
				JOptionPane.showMessageDialog(null,bf.hashCollisions(pass));
				
			}
		});
		b4.setBounds(361, 283, 253, 36);
		frame.getContentPane().add(b4);
		
		JButton b5 = new JButton("5. Number of false positive");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,bf.getFalsePositiveAmount());
			}
		});
		b5.setBounds(361, 335, 253, 36);
		frame.getContentPane().add(b5);
		
		JButton b6 = new JButton("6. Check password strength");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = JOptionPane.showInputDialog(frame, "Enter Password ", null);
				if (p.passwordCheck(pass)==1)
					JOptionPane.showMessageDialog(null,"Weak password");
				if (p.passwordCheck(pass)==2)
					JOptionPane.showMessageDialog(null,"Medium password");
				if (p.passwordCheck(pass)==3)
					JOptionPane.showMessageDialog(null,"Strong password");
				
				
			}
		});
		b6.setBounds(361, 387, 253, 36);
		frame.getContentPane().add(b6);
		
		JLabel lblNewLabel = new JLabel("Bloom Filter Passwords ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(368, 16, 330, 77);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("By: Ron Benshimol And Orit Nagossa");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel_1.setBounds(690, 395, 330, 53);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
