
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Decode {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField in = new JTextField(20);
	JTextArea output = new JTextArea();

	Decode() {
		in.setText("");
		output.setWrapStyleWord(true);
	    output.setLineWrap(true);
	    output.setEditable(false);
		panel.add(in);
		panel.add(output);
		panel.setLayout(new GridLayout(1, 2));
		frame.add(panel);
		frame.pack();
		frame.setLocation(200, 100);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null,
				"This will be translating directly off of DNA, which uses the bases A, T, C, and G.");
		while (true) {
			if (in.getText() != null && in.getText() != "") {
				if (in.getText().length() == 3) {
					translate();
				}
			}
		}
	}

	public void translate() {
		String t = in.getText();
		if (t.substring(0, 1).equalsIgnoreCase("A")) {
			// Begins with A
			if (t.substring(1, 2).equalsIgnoreCase("A")) {
				// AA
				if (t.substring(2, 3).equalsIgnoreCase("G") || t.substring(2, 3).equalsIgnoreCase("A")) {
					// AAG, AAA
					output.setText(output.getText() + "Lysine ");
					
				}
				else if (t.substring(2, 3).equalsIgnoreCase("C") || t.substring(2, 3).equalsIgnoreCase("T")){
					// AAT, AAC
					output.setText(output.getText() + "Asparagine ");
				}
			}
			else if(t.substring(1, 2).equalsIgnoreCase("G")) {
				// AG
				if (t.substring(2, 3).equalsIgnoreCase("G") || t.substring(2, 3).equalsIgnoreCase("A")) {
					// ATG, ATA
					output.setText(output.getText() + "Arginine ");
					
				}
				else if (t.substring(2, 3).equalsIgnoreCase("C") || t.substring(2, 3).equalsIgnoreCase("T")){
					// ATT, ATC
					output.setText(output.getText() + "Serine ");
				}
			}
			else if(t.substring(1, 2).equalsIgnoreCase("C")) {
				// AC
				output.setText(output.getText() + "Threorine ");
			}
			else if(t.substring(1, 2).equalsIgnoreCase("T")) {
				// AT
				if(t.substring(2, 3).equalsIgnoreCase("G")) {
					output.setText(output.getText() +  "Methionine "); 
				}
				else if(t.substring(2, 3).equalsIgnoreCase("T")||t.substring(2, 3).equalsIgnoreCase("A")||t.substring(2, 3).equalsIgnoreCase("C")) {
					output.setText(output.getText() + "Isoleucine ");
				}
			}
		} else if (t.substring(0, 1).equalsIgnoreCase("G")) {
			// Begins with G
		} else if (t.substring(0, 1).equalsIgnoreCase("C")) {
			// Begins with C
		} else if (t.substring(0, 1).equalsIgnoreCase("T")) {
			// Begins with T
		} 
		in.setText("");
	}

	public static void main(String[] args) {
		new Decode();
	}
}
