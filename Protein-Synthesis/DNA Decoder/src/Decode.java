
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Decode {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField in = new JTextField(20);
	JTextArea output = new JTextArea();
	boolean notStopped = true;
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
			if (in.getText() != null && in.getText() != "" && notStopped) {
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
			if(t.substring(1,2).equalsIgnoreCase("A")) {
				if(t.substring(2,3).equalsIgnoreCase("A") || t.substring(2,3).equalsIgnoreCase("G")) {
					// GAA or GAG
					output.setText(output.getText() + "Glutamic Acid ");
				}
				else if(t.substring(2,3).equalsIgnoreCase("T") || t.substring(2,3).equalsIgnoreCase("C")) {
					output.setText(output.getText() + "Aspartic Acid ");
				}
			}
			else if(t.substring(1,2).equalsIgnoreCase("G")) {
				output.setText(output.getText() + "Glycine ");
			}
			else if(t.substring(1,2).equalsIgnoreCase("T")) {
				output.setText(output.getText() + "Valine ");
			}
			else if(t.substring(1,2).equalsIgnoreCase("C")) {
				output.setText(output.getText() + "Alanine ");
			}
		} else if (t.substring(0, 1).equalsIgnoreCase("C")) {
			// Begins with C
			if(t.substring(1,2).equalsIgnoreCase("A")) {
				if(t.substring(2,3).equalsIgnoreCase("A") || t.substring(2,3).equalsIgnoreCase("G")) {
					output.setText(output.getText() + "Glutamine ");
				}
				else if(t.substring(2,3).equalsIgnoreCase("T") || t.substring(2,3).equalsIgnoreCase("C")) {
					output.setText(output.getText() + "Histidine ");
				}
			}
			else if(t.substring(1,2).equalsIgnoreCase("C")) {
				output.setText(output.getText() + "Proline ");
			}
			else if(t.substring(1,2).equalsIgnoreCase("T")) {
				output.setText(output.getText() + "Leucine ");
			}
			else if(t.substring(1,2).equalsIgnoreCase("G")) {
				output.setText(output.getText() + "Arginine ");
			}
		} else if (t.substring(0, 1).equalsIgnoreCase("T")) {
			// Begins with T
			if(t.substring(1,2).equalsIgnoreCase("A")) {
				if(t.substring(2,3).equalsIgnoreCase("A") || t.substring(2,3).equalsIgnoreCase("G")) {
					output.setText(output.getText() + "Stop Codon");
					notStopped = false;
				}
				else if(t.substring(2,3).equalsIgnoreCase("T") || t.substring(2,3).equalsIgnoreCase("C")) {
					output.setText(output.getText() + "Tyrosine ");
				}
			}
			else if(t.substring(1,2).equalsIgnoreCase("C")) {
				output.setText(output.getText() + "Serine ");
			}
			else if(t.substring(1,2).equalsIgnoreCase("G")) {
				if(t.substring(2,3).equalsIgnoreCase("A")) {
					output.setText(output.getText() + "Stop Codon");
					notStopped = false;
				}
				else if(t.substring(2,3).equalsIgnoreCase("G")) {
					output.setText(output.getText() + "Tryptophan ");
				}
				else if(t.substring(2,3).equalsIgnoreCase("T") || t.substring(2,3).equalsIgnoreCase("C")) {
					output.setText(output.getText() + "Tyrosine ");
				}
			}
			else if(t.substring(1,2).equalsIgnoreCase("T")) {
				if(t.substring(2,3).equalsIgnoreCase("A") || t.substring(2,3).equalsIgnoreCase("G")) {
					output.setText(output.getText() + "Leucine");
				}
				else if(t.substring(2,3).equalsIgnoreCase("T") || t.substring(2,3).equalsIgnoreCase("C")) {
					output.setText(output.getText() + "Phenylalanine ");
				}
			}
		} 
		in.setText("");
	}

	public static void main(String[] args) {
		new Decode();
	}
}
