public class Solve {
	String expression, operator = "", holdOperator = "", logStr = "";
	StringBuffer expBuff;
	String[] numStr, opStr;
	double num = 0, holdNum = 0, runningAnswer = 0, prevAnswer = 0;	
	int passCalc = 0;	
	
	public void getNegatives()
	{	
		int index;
		
		for (int i = 0; i < expBuff.length(); i++) {
			if (i == 0) {
				if (expBuff.charAt(0) == '-') {
					expBuff.deleteCharAt(0);
					expBuff.insert(0, "$");
				}
			}
			else {
				switch (expBuff.charAt(i)) {
					case '*': if (expBuff.charAt(i+1) == '-') {
								  index = i+1;
								  expBuff.deleteCharAt(i+1);
								  expBuff.insert(index, "$");
							  }
							  break;
					case '-': if (expBuff.charAt(i+1) == '-') {
								  index = i+1;
						  		  expBuff.deleteCharAt(i+1);
						  		  expBuff.insert(index, "$");
					  		  }
							  break;
					case '+': if (expBuff.charAt(i+1) == '-') {
								  index = i+1;
						  		  expBuff.deleteCharAt(i+1);
						  		  expBuff.insert(index, "$");
					  		  }
							  break;
					case '/': if (expBuff.charAt(i+1) == '-') {
								  index = i+1;
						  		  expBuff.deleteCharAt(i+1);
						  		  expBuff.insert(index, "$");
					  		  }
							  break;
					case '^': if (expBuff.charAt(i+1) == '-') {
						  		  index = i+1;
						  		  expBuff.deleteCharAt(i+1);
						  		  expBuff.insert(index, "$");
			  		  		  }
					  		  break;
				}
			}
		}
		getArrays();
	}
	
	public void getArrays()
	{
		int index = 0;
		passCalc = 0;
		expression = expBuff.toString();
		
		numStr = expression.split( "-|\\+|\\*|/|\\^" );
		opStr = new String[ numStr.length - 1 ];
		
		for (int v = 0; v < numStr.length; v++) {
			if ( numStr[v].charAt(0) == '$') {
				StringBuffer buff = new StringBuffer(numStr[v]);
				buff.deleteCharAt(0);
				buff.insert(0, "-");
				numStr[v] = buff.toString();
			}
			if ( numStr[v].equals("pi") ) {
				numStr[v] = Double.toString(Math.PI);
			}
			if ( numStr[v].length() > 1 ) {
				if (numStr[v].charAt(0) == 'l') {
					logStr = numStr[v];
				    numStr[v] = Double.toString( log() );
				}
				//Fix this:
				else if (numStr[v].charAt(1) == 'l') {
					logStr = numStr[v].substring(1);
					double logResult = log();
					logStr = Double.toString(logResult);
					numStr[v] = logStr;
					System.out.println(numStr[v]);
				}
			}
		}
		for (int m = 0; m < expression.length(); m++) {
		   if ( expression.charAt( m ) == '+' ) {
		      opStr[ index ] = "+";
		      index++;
		   }
		   else if ( expression.charAt( m ) == '-' ) {
		      opStr[ index ] = "-";
		      index++;
		   }
		   else if ( expression.charAt( m ) == '*' ) {
		      opStr[ index ] = "*";
		      index++;
		   }
		   else if ( expression.charAt( m ) == '/' ) {
		      opStr[ index ] = "/";
		      index++;
		   }
		   else if ( expression.charAt( m ) == '^' ) {
		      opStr[ index ] = "^";
		      index++;
		   }
		}
		sortArrays();
	}
	
	public void sortArrays()
	{
		
		ModForExponents modex = new ModForExponents();
		ModPrimaryOperators mpe = new ModPrimaryOperators();
		
		modex.modify(numStr, opStr);
		numStr = modex.newNumArray;
		opStr = modex.newOpArray;
		
		mpe.modify(numStr, opStr);
		numStr = mpe.newNumArray;
		opStr = mpe.newOpArray;
		
		/*//DISPLAY CONTENT OF ARRAYS
		int c = 0;
		
		while (c < numStr.length) {
			System.out.print(numStr[c] + "  ");
			c++;
		}
		c = 0;
		System.out.println("\n");
		
		while (c < opStr.length) {
			System.out.print(opStr[c] + "  ");
			c++;
		}
		System.out.println("\n");
		//------------------------------//*/
		solveArrays();
	}
	
	public void solveArrays()
	{
		for ( int i = 0; i < numStr.length; i++ ) {
		   if ( passCalc == 0 ) {
			  if ( numStr[i] == "n" ) {
			     break;			  
			  }
			  runningAnswer = Double.parseDouble( numStr[ i ] );
		      passCalc++;
		   }	       
		   else {
			   if ( numStr[i] == "n" )
				  break;
		       try {
		          num = Double.parseDouble( numStr[ i ] );
		          holdOperator = opStr[ i - 1 ];
		          calculate();
		       }
		       catch ( NumberFormatException e ) {
		    	   holdOperator = opStr[ i - 1 ];
		           calculate();
		      }	     
		   }
		}
	}
	
	public double log()
	{
		String logString = logStr.substring( logStr.indexOf( 'g' ) + 1 );
		double logNum = Double.parseDouble( logString );		
		return Math.log10( logNum );
	}

	public void calculate()
	{
	    if ( holdOperator.equals( "+" ) ) 
		      runningAnswer += num;
		else if ( holdOperator.equals( "-" ) ) 
		      runningAnswer = runningAnswer - num;		
		else if ( holdOperator.equals( "*" ) )
		      runningAnswer = runningAnswer * num;
		else if ( holdOperator.equals( "/" ) )
		      runningAnswer = runningAnswer / num;
		else if ( holdOperator.equals( "^" ) ) 
		      runningAnswer = Math.pow( runningAnswer, num );
		return;		 		    
	}
}
