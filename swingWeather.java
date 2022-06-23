// GUI frow Weather using swing.

import java.io.*;
import java.net.*;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

class SwingApp 
{  
	SwingApp()
	{  

		JFrame frame = new JFrame();
		JLabel label = new JLabel("City Name:");  
		label.setBounds(20, 50, 80, 20);
		 // (x, y, l, h) 

		JTextField cityNameTF = new JTextField();  
		cityNameTF.setBounds(120, 50, 100, 20);

		// ButtonListener buttonListener
		JLabel tempLabel = new JLabel("Temperature");
		tempLabel.setBounds(20, 200, 80, 20);

		JTextField tempValue = new JTextField();
		tempValue.setBounds(120, 200, 100, 20);

		JButton submit = new JButton("Submit");  
		submit.setBounds(80, 100, 100, 30); 

		submit.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ev)
		{
			try
			{
				PrintInput obj = new PrintInput();
				// String city = obj.input("Enter City Name: ");
				String city = cityNameTF.getText();
				URL url = new URL ("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=e6b7427f8bf97526adf2869093c7509c&units=metric");
				
				URLConnection connec = url.openConnection();
				InputStream isr = connec.getInputStream();
				String input = IOUtils.toString(isr, StandardCharsets.UTF_8);
				
				JSONObject jsonObj = new JSONObject(input);
				JSONObject jo = (JSONObject)jsonObj.get("main");
				// System.out.println(jo.get("temp"));
				String temp = jo.getString("temp");
				tempValue.setText(temp);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}

		});


		frame.add(label); 
		frame.add(cityNameTF);
		frame.add(submit); 
		frame.add(tempLabel);
		frame.add(tempValue);
		// submit.addActionListener(ButtonListener);

		frame.setSize(300,300);  
		frame.setLayout(null);  
		frame.setVisible(true); 
	}
	
	public static void main(String[] args)
	{
		SwingApp s = new SwingApp();
	} 
}


// D:\training\java>javac -cp .;org.json.jar;commons-io-2.11.0.jar;MyJarMyTools.jar swingWeather.java

// D:\training\java>java -cp .;org.json.jar;commons-io-2.11.0.jar;MyJarMyTools.jar SwingApp


























// import javax.swing.*;
// import java.applet.*;
// import java.awt.*;
// import java.awt.event.*;

// class SApplet extends Applet implements ActionListener {
//    TextField input,output;
//    Label label1,label2;
//    Button b1;
//    JLabel lbl;
//    int num, sum = 0;
   
//    public static void main(String args[]) {
//       Label label1 = new Label("please enter number : ");
//       add(label1);
//       label1.setBackground(Color.yellow);
//       label1.setForeground(Color.magenta);
//       TextField input = new TextField(5);
      
//       add(input);
//       Label label2 = new Label("Sum : ");
      
//       add(label2);
//       label2.setBackground(Color.yellow);
//       label2.setForeground(Color.magenta);
//       TextField output = new TextField(20);
      
//       add(output);
//       JLabel b1 = new Button("Add");
      
//       add(b1);
//       b1.addActionListener(this);
//       JLabel lbl = new JLabel("Swing Applet Example. ");
//       add(lbl);
//       setBackground(Color.yellow);
//    } 
//    public void actionPerformed(ActionEvent ae ){
//       try {
//          int num = Integer.parseInt(input.getText());
//          int sum = sum+num;
//          input.setText("");
//          output.setText(Integer.toString(sum));
//          lbl.setForeground(Color.blue);
//          lbl.setText("Output of the second Text Box : " + output.getText());
//       } catch(NumberFormatException e) {
//          lbl.setForeground(Color.red);
//          lbl.setText("Invalid Entry!");
//       }
//    }  
// }


















// import java.io.*;
// import java.net.*;
// import org.apache.commons.io.IOUtils;
// import java.nio.charset.StandardCharsets;
// import java.util.*;
// import org.json.JSONObject;
// // import javax.swing.JButton;
// // import javax.swing.JFrame;
// // import javax.swing.JTextField;
// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.Container;


// class ClassFrame
// {
// 	public static final long serialVersionUID = 2451829341034438685L;
// 	public static JFrame frame;
// 	public static JPanel panel;
// 	public static JTextField cityNameTF;
// 	public static JTextArea temp;
// 	public static JButton submitButton;
// 	public static JLabel cityName;
// 	public static String myString;

// 	public static void main(String... args)
// 	{
// 		try
// 		{
// 			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	
// 		}
// 		catch (Exception e)
// 		{
// 			System.out.println(e);
// 		}
// 		createFrame();
// 	}
// 	public static void createFrame()
// 	{
// 		frame = new JFrame("Temperature!");
// 		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//         panel = new JPanel();
//         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//         panel.setOpaque(true);


//         temp = new JTextArea();
//         temp.setBounds(80, 100, 100, 20);
//         temp.setWrapStyleWord(true);
//         temp.setEditable(true);

//         JPanel inputpanel = new JPanel();
//         // inputpanel.setLayout(new FlowLayout());

//         cityNameTF = new JTextField();
// 		cityNameTF.setBounds(100, 50, 150, 20);

// 		cityName = new JLabel();
// 		cityName.setBounds(20, 50, 80, 20);

//         ButtonListener buttonListener = new ButtonListener();

// 		submitButton = new JButton("Submit");
// 		submitButton.setBounds(80, 150, 100, 30); 
// 		// submitButton.setActionCommand(ENTER);
// 		submitButton.addActionListener(buttonListener);

// 		// cityNameTF.setActionCommand(ENTER);
// 		cityNameTF.addActionListener(buttonListener);

// 		DefaultCaret caret = (DefaultCaret) temp.getCaret();
//         caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

//         inputpanel.add(cityNameTF);
//         inputpanel.add(submitButton);

//         panel.add(inputpanel);

//         frame.getContentPane().add(panel);
//         frame.pack();

//         frame.setLocationByPlatform(true);
//         frame.setSize(300,300);
//         frame.setVisible(true);
//         frame.setLayout(null);
//         // frame.setResizable(true);
//         // cityNameTF.requestFocus();
// 	}

// 	public static class ButtonListener implements ActionListener
// 	{
// 		public void actionPerformed(final ActionEvent ev)
// 		{
// 			try
// 			{
// 				PrintInput obj = new PrintInput();
// 				// String city = obj.input("Enter City Name: ");
// 				URL url = new URL ("https://api.openweathermap.org/data/2.5/weather?q=" + cityNameTF.getText() + "&appid=e6b7427f8bf97526adf2869093c7509c&units=metric");
				
// 				URLConnection connec = url.openConnection();
// 				InputStream isr = connec.getInputStream();
// 				String input = IOUtils.toString(isr, StandardCharsets.UTF_8);
				
// 				JSONObject jsonObj = new JSONObject(input);
// 				JSONObject jo = (JSONObject)jsonObj.get("main");
// 				System.out.println(jo.get("temp"));
// 			}
// 			catch (Exception e)
// 			{
// 				System.out.println(e);
// 			}
// 		}
// 	}
// }




























// public class Test
// {
//     private static String ENTER = "Enter";
//     static JButton enterButton;
//     public static JTextArea output;
//     public static JTextField input;
//     static JFrame frame;
//     static JPanel panel;
//     public static String testString = "test";

//     public static void main(String... args)
//     {
//         try
//         {
//             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//         }
//         catch (Exception ex)
//         {
//             ex.printStackTrace();
//         }
//         createFrame();
//     }

//     public static void createFrame()
//     {
//         frame = new JFrame("Test");
//         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         panel = new JPanel();
//         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//         panel.setOpaque(true);
//         ButtonListener buttonListener = new ButtonListener();
//         output = new JTextArea(15, 50);
//         output.setWrapStyleWord(true);
//         output.setEditable(false);
//         JScrollPane scroller = new JScrollPane(output);
//         scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//         scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//         JPanel inputpanel = new JPanel();
//         inputpanel.setLayout(new FlowLayout());
//         input = new JTextField(20);
//         enterButton = new JButton("Enter");
//         enterButton.setActionCommand(ENTER);
//         enterButton.addActionListener(buttonListener);
//         // enterButton.setEnabled(false);
//         input.setActionCommand(ENTER);
//         input.addActionListener(buttonListener);
//         DefaultCaret caret = (DefaultCaret) output.getCaret();
//         caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
//         panel.add(scroller);
//         inputpanel.add(input);
//         inputpanel.add(enterButton);
//         panel.add(inputpanel);
//         frame.getContentPane().add(BorderLayout.CENTER, panel);
//         frame.pack();
//         frame.setLocationByPlatform(true);
//         // Center of screen
//         // frame.setLocationRelativeTo(null);
//         frame.setVisible(true);
//         frame.setResizable(false);
//         input.requestFocus();
//     }

//     public static class ButtonListener implements ActionListener
//     {

//         public void actionPerformed(final ActionEvent ev)
//         {
//             if (!input.getText().trim().equals(""))
//             {
//                 String cmd = ev.getActionCommand();
//                 if (ENTER.equals(cmd))
//                 {
//                     output.append(input.getText());
//                     if (input.getText().trim().equals(testString)) output.append(" = " + testString);
//                     else output.append(" != " + testString);
//                     output.append("\n");
//                 }
//             }
//             input.setText("");
//             input.requestFocus();
//         }
//     }
// }





















































// import java.io.*;
// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;  
// class SwingApp 
// {  
// 	SwingApp()
// 	{  
// 	JFrame frame = new JFrame();
// 	JLabel cityName = new JLabel("City Name:");  
// 	cityName.setBounds(20, 50, 80, 20); 

// 	JTextField cityNameTF = new JTextField();  
// 	cityNameTF.setBounds(120, 50, 100, 20);
// 	// cityNameTF.addActionListener(this); 

// 	JButton submit = new JButton("Submit");  
// 	submit.setBounds(80, 160, 100, 30); 

// 	// String text = actionPerformed();

// 	// JLabel temp = new JLabel(text);
// 	// temp.setBounds(80, 100, 100, 20); 
// 	// (x, y, l, h)

// 	frame.add(cityName); 
// 	frame.add(cityNameTF);
// 	frame.add(submit); 
// 	submit.addActionListener(new ButtonHandler(cityNameTF));

// 	frame.setSize(300,300);  
// 	frame.setLayout(null);  
// 	frame.setVisible(true); 
// 	}

// 	// public static String actionPerformed(ActionEvent evt)
// 	// {
// 	// 	String text = cityNameTF.getText();
// 	// 	return text;
// 	// }

// 	public static void main(String[] args)
// 	{
// 		SwingApp s = new SwingApp();
// 	} 
// }

// class ButtonHandler implements ActionListener
// {
// 	public ButtonHandler(JTextField cityNameTF)
// 	{
// 		this.cityNameTF = cityNameTF;
// 	}

// 	public void actionPerformed(ActionEvent e)
// 	{
// 		String text = cityNameTF.getText();
// 		JOptionPane.showMessageDialog(null, text, JOptionPane.PLAIN_MESSAGE);
// 	}
// }

// // myString = editTextArea.getText();


































































// import javax.swing.*;  
// class SwingApp 
// {  
// 	SwingApp()
// 	{  
// 		JFrame frame = new JFrame();
// 		JLabel cityName = new JLabel("City Name:");  
// 		cityName.setBounds(20, 50, 80, 20); 

// 		JTextField cityNameTF = new JTextField();  
// 		cityNameTF.setBounds(120, 50, 100, 20);
// 		// cityNameTF.addActionListener(this); 

// 		JButton submit = new JButton("Submit");  
// 		submit.setBounds(80, 160, 100, 30); 

// 		frame.add(cityName); 
// 		frame.add(cityNameTF);
// 		frame.add(submit); 
// 		// submit.addActionListener(new ButtonHandler(cityNameTF));

// 		frame.setSize(300,300);  
// 		frame.setLayout(null);  
// 		frame.setVisible(true); 
// 	}

// 	public static void main(String[] args)
// 	{
// 		SwingApp s = new SwingApp();
// 	} 
// }
