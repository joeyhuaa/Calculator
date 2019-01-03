import javax.swing.*;
import java.awt.*;

public class GComponents {
   JPanel panel2, gPanel, topPanel, topPanel2;
   JLabel label1, label2, label3, labelP1, labelP2;
                
   public GComponents()
   {
	panel2 = new JPanel( new BorderLayout() );
	gPanel = new JPanel( new GridBagLayout() );
	topPanel = new JPanel( new GridBagLayout() );
	topPanel2 = new JPanel( new GridBagLayout() );
	label1 = new JLabel( "y1=" );
	label1.setForeground( Color.red );
	label2 = new JLabel( "y2=" );
	label2.setForeground( Color.blue );
	label3 = new JLabel( "y3=" );
	label3.setForeground( Color.green );
   }
}
