public class ModPrimaryOperators {
	String[] newNumArray, newOpArray;
	int loop = 1;
	
	public void modify(String[] nArray, String[] oArray ) 
	{
		String operator = "";
		double x = 0, y = 0;
		for(int i = 0; i <= oArray.length; i++) {
			if(i == oArray.length) {
				if(loop == 1) {
					loop++;
					modify(nArray, oArray);
				}
				else {
					newNumArray = nArray;
					newOpArray = oArray;
					return;
				}
			}
			else {
			    operator = oArray[i];
			    try {
			    	x = Double.parseDouble(nArray[i]);
			    }
			    catch(NumberFormatException e) {
			    	if(loop == 1) {
						loop++;
						modify(nArray, oArray);
					}
					else {
						newNumArray = nArray;
						newOpArray = oArray;
						return;
					}
			    }			   
			    try {
			    	y = Double.parseDouble(nArray[i+1]);
			    }
			    catch(NumberFormatException e) {
			    	if(loop == 1) {
						loop++;
						modify(nArray, oArray);
					}
					else {
						newNumArray = nArray;
						newOpArray = oArray;
						return;
					}
			    }
			}			
			switch(operator) {
				case "*": 
					nArray[i] = Double.toString(x * y);
					for (int p = i; p < oArray.length; p++) {
						if(p == oArray.length - 1) {
							oArray[p] = "n";
							break;
						}
						else if(p == oArray.length - 2) {
						    oArray[p] = oArray[p + 1];
						    oArray[p + 1] = "n";
						    break;
					    }
					    else {
						    oArray[p] = oArray[p + 1];
						    oArray[p + 1] = oArray[p + 2];
					    }
				    }
				    for (int a = i; a < nArray.length - 1; a++) {
					    if(a == nArray.length - 2) {
						    nArray[a + 1] = "n";
					        break;
					    }
					    else {
						    nArray[a + 1] = nArray[a + 2]; 
					    }
				    }
		            break;
				case "/": 
					nArray[i] = Double.toString(x / y);
					for (int p = i; p < oArray.length; p++) {
						if(p == oArray.length - 1) {
							oArray[p] = "n";
						    break;
					    }
					    else if(p == oArray.length - 2) {
						    oArray[p] = oArray[p + 1];
						    oArray[p + 1] = "n";
						    break;
					    }
					    else {
						    oArray[p] = oArray[p + 1];
						    oArray[p + 1] = oArray[p + 2];
					    }
				    }
				    for (int a = i; a < nArray.length - 1; a++) {
					    if(a == nArray.length - 2) {
						    nArray[a + 1] = "n";
					        break;
					    }
					    else {
					  	    nArray[a + 1] = nArray[a + 2]; 
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


