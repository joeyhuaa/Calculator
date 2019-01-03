import javax.swing.*;
import java.awt.*;

public class Axes extends JPanel {
      
   public Axes()
   {
	setOpaque( false );
   }

   public void paintComponent( Graphics g )
   {
	super.paintComponent( g );
	g.drawLine( getWidth() / 2, 0,  getWidth() / 2, getHeight() );
	g.drawLine( 0, getHeight() / 2, getWidth(), getHeight() / 2 );

	for ( int i = 1; i <= 100; i++ ) 
	   g.drawString( "|", ( getWidth() / 2 ) + ( 20 * i ), ( getHeight() / 2 ) + 5 );
	
	for ( int j = 1; j <= 100; j++ ) 
	   g.drawString( "--", ( getWidth() / 2 ) - 3, ( getHeight() / 2 ) - ( 20 * j ) );

	for ( int k = 1; k <= 100; k++ )
	   g.drawString( "|", ( getWidth() / 2 ) - ( 20 * k ), ( getHeight() / 2 ) + 5 );

	for ( int m = 1; m <= 100; m++ )
	   g.drawString( "--", ( getWidth() / 2 ) - 3, ( getHeight() / 2 ) + ( 20 * m ) ); 
   }
} 