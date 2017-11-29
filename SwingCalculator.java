import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * The SwingCalculator class inherits from the JFrame class all methods and attributes.  This class utilizes java Swing components to extend GUI capability.
 * This class contains a constructor method, a main() method, and an ActionListener method to handle the action of a button being clicked in order to sum two user-entered numbers.
 * email: email
 * Created: 27NOV2017
 * @author sapper
 * @version 1.0
 */
public class SwingCalculator extends JFrame {
	//class attributes
	private JTextField textField1;
	private JTextField textField2;
	private JLabel label1;

	//Constructor method defined to create calculator objects with default textfields, buttons, and layouts.
	public SwingCalculator() {
		//creating textfield and label objects
		textField1 = new JTextField(10);
		label1 = new JLabel("            0.0");
		textField2 = new JTextField(10);
		//the button will handle all action events
		JButton button = new JButton("Add");
		button.addActionListener(new CalculateButtonHandle());

		//Selecting and creating a new layout object
		FlowLayout layout = new FlowLayout();
		//creating a new panel and setting the layout onto the panel
		JPanel panel = new JPanel(layout);

		//adding all of the components to the panel
		panel.add(label1);
		panel.add(textField1);
		panel.add(textField2);
		panel.add(button);
		//setting the panel into the content pane
		setContentPane(panel);
	}

	/**
	 * The main() method is the entry point of the application and utilizes the methods defined outside of it to carry out the desired actions.
	 * @param args, arguments passed through the command line.
	 */
	public static void main(String[] args) {

		//must create an object to set visible
		SwingCalculator calculator = new SwingCalculator();
		//utilizing JFrame methods inherited by extension
		calculator.setSize(1000,1000);
		calculator.setTitle("Calc");
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//consolidates the components and window size
		calculator.pack();

		//set the frame to visible
		calculator.setVisible(true);
		//System.out.println(calculator.getInsets());

	}

	/**
	 * The CalculateButtonHandle class implements the ActionListener interface to handle the action of the user clicking the button.
	 */
	private class CalculateButtonHandle implements ActionListener {
		/**
		 * the actionPerformed() method carries out specific instructions that are activated when the button is clicked.
		 * @param e, an object representative of the button being clicked.
		 */
		public void actionPerformed(ActionEvent e) {
			//System.out.println("you have clicked the calculate button");
			double input1 = Double.parseDouble(textField1.getText());
			double input2 = Double.parseDouble(textField2.getText());
			double result = input1 + input2;
			DecimalFormat format = new DecimalFormat("####.00");
			label1.setText(String.valueOf(format.format(result)));

		}
	}
}
