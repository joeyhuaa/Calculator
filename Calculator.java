import javax.swing.*;
import java.awt.*;

public class Calculator {
   SciComponents sComponents = new SciComponents();
   GComponents gComponents = new GComponents();
   MyCanvas canvas = new MyCanvas();
                  
   public Calculator()
   {
	createPanel1();
	createPanel2();
   }
 
   public void createPanel1()
   {
	GridBagConstraints c = new GridBagConstraints();
	c.gridx = 0;
	c.gridy = 0;

	c.fill = GridBagConstraints.BOTH;
	c.insets = new Insets( 2, 0, 0, 0 );
	c.gridwidth = 4;
	sComponents.panel1.add( sComponents.scroll, c ); 
	
	c.gridy = 1;
	c.gridwidth = 1;
	c.insets = new Insets( 2, 2, 2, 2 );
	c.gridheight = 1;	
	sComponents.panel1.add( sComponents.power, c );	

	c.gridy++;
	sComponents.panel1.add( sComponents.one, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.four, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.seven, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.pi, c );
	c.gridy++;

	c.gridwidth = 2;
	sComponents.panel1.add( sComponents.ans, c );
	c.gridx++;
	
	c.gridwidth = 1;
	c.gridy = 1;
	sComponents.panel1.add( sComponents.log, c );
	c.gridy++;
	
	sComponents.panel1.add( sComponents.two, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.five, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.eight, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.zero, c );
	c.gridx++;
	
	c.gridy = 1;
	sComponents.panel1.add( sComponents.del, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.three, c );
	c.gridy++;
	
	sComponents.panel1.add( sComponents.six, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.nine, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.point, c );
	c.gridy++;

	c.gridwidth = 2;
	sComponents.panel1.add( sComponents.calc, c );
	c.gridx++;

	c.gridy = 1;
	c.gridwidth = 1;
	sComponents.panel1.add( sComponents.clr, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.plus, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.minus, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.multiply, c );
	c.gridy++;

	sComponents.panel1.add( sComponents.divide, c );
   }

   public void createPanel2()
   {
	GridBagConstraints c = new GridBagConstraints();

	sComponents.tPane.addTab( "Graphing", gComponents.panel2 );
	
	gComponents.panel2.add( gComponents.gPanel, BorderLayout.NORTH );
	gComponents.panel2.add( canvas, BorderLayout.CENTER );	

	c.fill = GridBagConstraints.HORIZONTAL;

	c.gridy = 0;
	c.gridx = 0;

	gComponents.gPanel.add( gComponents.topPanel, c );
	gComponents.topPanel.setBorder(
	   BorderFactory.createTitledBorder( "Equations" ) );
	c.gridx++;
	
	c.insets = new Insets( 0, 0, 0, 0 );
	gComponents.topPanel.add( gComponents.label1, c );
	c.gridy++;

	gComponents.topPanel.add( gComponents.label2, c );
	c.gridy++;

	gComponents.topPanel.add( gComponents.label3, c );
	c.gridy = 0;
	c.gridx++;

	c.gridwidth = 2;
	gComponents.topPanel.add( canvas.inputField1, c );
	c.gridy++;

	gComponents.topPanel.add( canvas.inputField2, c );
	c.gridy++;

	gComponents.topPanel.add( canvas.inputField3, c );
	c.gridy++;

	c.gridwidth = 1;
	gComponents.topPanel.add( canvas.graph, c );
	c.gridx++;

	gComponents.topPanel.add( canvas.clrEquation, c );	
   }			

   public static void main( String[] args )
   {
	   new Calculator();
   }
}