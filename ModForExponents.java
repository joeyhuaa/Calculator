public class ModForExponents {
	String[] newNumArray, newOpArray;
	int loop = 1;
		
	public void modify(String[] numArray, String[] opArray)
	{
		String operator = "";
		double x = 0, y = 0;
		for(int i = 0; i <= opArray.length; i++) {
			if(i == opArray.length) {
				if(loop == 1) {
					loop++;
					modify(numArray, opArray);
				}
				else {
					newNumArray = numArray;
					newOpArray = opArray;
					return;
				}
			}
			else {
				operator = opArray[i];
				try {
			    	x = Double.parseDouble(numArray[i]);
			    }
			    catch(NumberFormatException e) {
			    	if(loop == 1) {
						loop++;
						modify(numArray, opArray);
					}
					else {
						newNumArray = numArray;
						newOpArray = opArray;
						return;
					}
			    }			 
			    try {
			    	y = Double.parseDouble(numArray[i+1]);
			    }
			    catch(NumberFormatException e) {
			    	if(loop == 1) {
						loop++;
						modify(numArray, opArray);
					}
					else {
						newNumArray = numArray;
						newOpArray = opArray;
						return;
					}
			    }
			}
			switch(operator) {
				case "^": 
					numArray[i] = Double.toString(Math.pow(x,y));
					for (int p = i; p < opArray.length; p++) {
						if(p == opArray.length - 1) {
							opArray[p] = "n";
							break;
						}
						else if(p == opArray.length - 2) {
							opArray[p] = opArray[p + 1];
							opArray[p + 1] = "n";
							break;
						}
					    else {
						    opArray[p] = opArray[p + 1];
						    opArray[p + 1] = opArray[p + 2];
					    }
					}
					for (int a = i; a < numArray.length - 1; a++) {
						if(a == numArray.length - 2) {
							numArray[a + 1] = "n";
							break;
						}
						else {
							numArray[a + 1] = numArray[a + 2]; 
					    }
				    }
				    break;
				case "n": 
					break;
				default: 
					break;
			}
		}
	}
}
