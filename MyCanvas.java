import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.lang.StringBuffer;
import java.util.ArrayList;

public class MyCanvas extends JPanel {
   JButton graph, clrEquation;
   JTextField inputField1, inputField2, inputField3;
   String equation, eq1, eq2, eq3;
   StringBuffer equationBuffer;
   DecimalFormat num = new DecimalFormat( "0.00" );
   GetLine g = new GetLine();
   Solve s = new Solve();
   ArrayList<Double> xList = new ArrayList<Double>();
   ArrayList<Double> yList = new ArrayList<Double>();
   ArrayList<Double> xList1 = new ArrayList<Double>();
   ArrayList<Double> yList1 = new ArrayList<Double>();
   ArrayList<Double> xList2 = new ArrayList<Double>();
   ArrayList<Double> yList2 = new ArrayList<Double>();
   ArrayList<Double> xList3 = new ArrayList<Double>();
   ArrayList<Double> yList3 = new ArrayList<Double>();
      
   public MyCanvas()
   {
	setBorder( BorderFactory.createLoweredBevelBorder() );
	setBackground( Color.white );
	setLayout( new BorderLayout() );
	add( new Axes() );	

	inputField1 = new JTextField( 10 );
	inputField2 = new JTextField( 10 );
	inputField3 = new JTextField( 10 );
	graph = new JButton( "Graph!" );
	graph.addActionListener(
	   new ActionListener() {
		public void actionPerformed( ActionEvent e ) {
		   equation = inputField1.getText();
		   if ( !equation.equals("") ) {
			  g.eq = equation;
		      g.getLine();
		      eq1 = g.buff.toString();
		   }
		   equation = inputField2.getText();
		   if ( !equation.equals("") ) {
			   System.out.println(equation);
			  g.eq = equation;
		      g.getLine();	
		      eq2 = g.buff.toString();
		   }
		   equation = inputField3.getText();
		   if ( !equation.equals("") ) {
			  g.eq = equation;
		      g.getLine();
		      eq3 = g.buff.toString();
	       }
		   graph();
		}
	   }
	);
	clrEquation = new JButton( "Clear" );
	clrEquation.addActionListener(
	   new ActionListener() {
		public void actionPerformed( ActionEvent e ) {
		   inputField1.setText( "" ); 
		   inputField2.setText( "" );
		   inputField3.setText( "" );
		   reset();
		   repaint();
		}
	   }
	);
   }
   
   public void reset() { xList.clear(); yList.clear(); }

   public void paintComponent( Graphics g )
   {
	   super.paintComponent( g );
	   Graphics2D g2 = ( Graphics2D ) g;
	   int offsetX = getWidth() / 2;
	   int offsetY = getHeight() / 2;
	   
	   for (int j = 0; j < xList1.size()-1; j++) {
		   g2.setColor(Color.red);
		   g2.draw(new Line2D.Double(20*xList1.get(j)+offsetX, -yList1.get(j)*20+offsetY, 
		   20*xList1.get(j+1)+offsetX, -yList1.get(j+1)*20+offsetY));
	   }
	   for (int j = 0; j < xList2.size()-1; j++) {
		   g2.setColor(Color.blue);
		   g2.draw(new Line2D.Double(20*xList2.get(j)+offsetX, -yList2.get(j)*20+offsetY, 
		   20*xList2.get(j+1)+offsetX, -yList2.get(j+1)*20+offsetY));
	   }		   
	   for (int j = 0; j < xList3.size()-1; j++) {
		   g2.setColor(Color.green);
		   g2.draw(new Line2D.Double(20*xList3.get(j)+offsetX, -yList3.get(j)*20+offsetY, 
		   20*xList3.get(j+1)+offsetX, -yList3.get(j+1)*20+offsetY));
	   }
   }
   
   public void graph()
   {
	   if (!eq1.equals("")) {
		   equationBuffer = new StringBuffer(eq1);
		   reset();
		   getYs();
		   xList1 = xList;
		   yList1 = yList;
		   System.out.println(xList1.size());
	   }
	   if (!eq2.equals("")) {
		   equationBuffer = new StringBuffer(eq2);
		   reset();
		   getYs();
		   xList2 = xList;
		   yList2 = yList;
	   }
	   if (!eq3.equals("")) {
		   equationBuffer = new StringBuffer(eq3);
		   reset();
		   getYs();
		   xList3 = xList;
		   yList3 = yList;
	   }
	   System.out.println(xList1.size());
	   repaint();
   }
   
   public void getYs()
   {	   
	   if (equationBuffer.charAt(0) == '-')
		   equationBuffer.insert(0, "0");
	   
	   String tempEq = equationBuffer.toString();
	   
	   for (double x = -100; x < 100; x+=0.05) {
		   int xOccurences = 0;
		   equationBuffer = new StringBuffer(tempEq);
		   
		   for (int n = 0; n < equationBuffer.length(); n++) {
			   	if (equationBuffer.charAt(n) == 'x')
			   		xOccurences++;
		   }		   
		   while (xOccurences > 0) {
			   int index = equationBuffer.indexOf("x");
			   equationBuffer.deleteCharAt(equationBuffer.indexOf("x"));
			   equationBuffer.insert(index, num.format(x));	
			   xOccurences--;
		   }
		   s.expBuff = equationBuffer;
		   s.getNegatives();
		   xList.add(x);
		   yList.add(s.runningAnswer);	
	   }
   }
}