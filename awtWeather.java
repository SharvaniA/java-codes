// GUI for Weather report using AWT.

import java.io.*;
import java.net.*;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.json.JSONObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

class AwtApp 
{  
	AwtApp()
	{  

		Frame frame = new Frame();
		Label label = new Label("City Name:");  
		label.setBounds(20, 50, 80, 20);
		 // (x, y, l, h) 

		TextField cityNameTF = new TextField();  
		cityNameTF.setBounds(120, 50, 100, 20);

		// ButtonListener buttonListener
		Label tempLabel = new Label("Temperature");
		tempLabel.setBounds(20, 200, 80, 20);

		TextField tempValue = new TextField();
		tempValue.setBounds(120, 200, 100, 20);

		Button submit = new Button("Submit");  
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

		frame.setSize(300,300);  
		frame.setLayout(null);  
		frame.setVisible(true); 
	}
	
	public static void main(String[] args)
	{
		AwtApp a = new AwtApp();
	} 
}
// D:\training\java>javac -cp .;org.json.jar;commons-io-2.11.0.jar;MyJarMyTools.jar awtWeather.java

// D:\training\java>java -cp .;org.json.jar;commons-io-2.11.0.jar;MyJarMyTools.jar AwtApp



































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

// 		// DefaultCaret caret = (DefaultCaret) temp.getCaret();
//   //       caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

//         inputpanel.add(cityNameTF);
//         inputpanel.add(submitButton);

//         panel.add(inputpanel);

//         frame.getContentPane().add(panel);
//         frame.pack();

//         frame.setLocationByPlatform(true);
//         frame.setSize(300,300);
//         frame.setVisible(true);
//         frame.setResizable(true);
//         cityNameTF.requestFocus();
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


































// // import java.awt.*;  
// // class AwtApp extends Frame 
// // {  
// // 	AwtApp()
// // 	{  
// // 	Label cityName = new Label("City Name:");  
// // 	cityName.setBounds(20, 60, 80, 20); 

// // 	TextField cityNameTF = new TextField();  
// // 	cityNameTF.setBounds(120, 60, 100, 20);

// // 	Button sbmt = new Button("Submit");  
// // 	sbmt.setBounds(80, 160, 100, 30);

// // 	add(cityName);
// // 	add(cityNameTF); 
// // 	add(sbmt);  

// // 	setSize(300,300);  
// // 	setLayout(null);  
// // 	setVisible(true); 
// // 	}  

// // 	public static void main(String[] args) 
// // 	{  
// // 		// TODO Auto-generated method stub  
// // 		AwtApp awt = new AwtApp(); 
// // 	} 
// // }  
