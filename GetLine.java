public class GetLine {
   String eq;
   StringBuffer buff, buff2, buff3;
   
   public void getLine() 
   {
	   buff = new StringBuffer(eq);
	   
	   for (int x = 0; x < buff.length(); x++) {
			if (buff.charAt(x) == 'x' && x != 0) {
				if (Character.isDigit(buff.charAt(x-1))) {
					buff.insert(x, "*");
				}
			}
	   }
   }
}