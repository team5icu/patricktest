/**
 * @author PatricioZ
 *Java F13 Java J2EE Programming
 */

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;

//Scope de aplicacion , ese servlet se va a isntancia una sola vez
//hello, saving this note
public class Hw7 extends HttpServlet {
int status2 = 0;
public static boolean isNumeric(String str)
{
  return str.matches("-?\\d+(\\.\\d+)?");  
}
public void doGet (HttpServletRequest request,HttpServletResponse response) throws IOException {
	String resultado = "";
	String x = "";
	String y = "";
	double yy = 0;
	double xx = 0;
	String operator = request.getParameter("operator");
	int status = 0;
	System.out.println(operator);
	String adminmail = getServletContext().getInitParameter("foodfd");
	System.out.println(status2);
	
	if(operator!=null){
		 x = request.getParameter("x").trim();
		y = request.getParameter("y").trim();
	if (x == null || x.equals("")){
		resultado = "X is empty";
		x = "";
		status = 1;
	}else{
		if (!isNumeric(x)){
			double yyy = 0;
			
			status = 1;
			
			
			resultado += "Dont use letters in X field";
			
			if(operator.equals("/") && isNumeric(y)){
				System.out.println(yy);
				if(yyy == Double.parseDouble(y)){
				resultado += "<br> Y cant be 0 (Infinity issue)";
				}
			}
			
		}else{
			xx = Double.parseDouble(x);
			
		}
		
		
		
	}
	if (y == null || y.equals("")){
		resultado += "<br> Y is empty";
		y = "";
		status = 1;
	}else{
		try {
			if (!isNumeric(y)){
				
				status = 1;
				
				
				resultado += "<br> Dont use letters in Y field";
				
			
			}else{
				yy = Double.parseDouble(y);
				
			}
		
		} catch (NumberFormatException e) {
			status = 1;
			
			
			resultado += "<br> Dont use letters in Y field";
		}
		
	}

	
	if (status==1){
		System.out.println("El estatus es 1");
		
	}
	
	if (status == 0){
		resultado = "";
	
		String resultx = String.format("%,.2f", xx);
		String resulty = String.format("%,.2f", yy);
		
		if(operator.equals("+")){
			double sum = xx + yy;
			String resultsum = String.format("%,.2f", sum);
			resultado = resultx +"  " +" +  "+ resulty + "  =  "+ resultsum;
			
		}
		if(operator.equals("-")){
			double sum = xx - yy;
			String resultsum = String.format("%,.2f", sum);
			resultado = resultx +"  " + " -  "+ resulty + "  =  "+ resultsum;		
					
				}
		if(operator.equals("*")){
			double sum = xx * yy;
			String resultsum = String.format("%,.2f", sum);
			resultado = resultx +"  " +" x  "+ resulty + "  =  "+ resultsum;
			
		}
		if(operator.equals("/")){
			if(yy==0){
				System.out.println(yy);
				resultado = "Y cant be 0 (Infinity issue)";
				
			}else{
				
				double sum = xx / yy;
				String resultsum = String.format("%,.2f", sum);
				resultado = resultx +"  " +" /  "+ resulty + "  =  "+ resultsum;
				
			}
			
			
		}
		
		
		
	}
	
	}
	
	
	
	
	
	
	PrintWriter out = response.getWriter();
	
	out.println("<html> 	<head> 	</head> 	<body > 			"
			+ "<div class=\"auto-style4\"> 			<hr> 			"
			+ "<form action=\"calc\" method=\"get\"> 				"
			+ "<table border=\"2\" align=\"center\" class=\"auto-style3\"><br> 						"
			+ "<tr> 		<br>		<td class=\"auto-style2\">"+resultado+"</td> 				"
			+ "</tr> 						<tr> 				"
			+ "<td class=\"auto-style2\">	"
			+ "<input name=\"x\" id=\"x\" type=\"text\" value=\""+x+"\"/>"+adminmail+"</td> 				"
			+ "</tr> 				<tr> 				"
			+ "<td class=\"auto-style2\"><input name=\"y\" id=\"y\" type=\"text\" value=\""+y+"\"/>"
			+ " Y	</td> 				</tr> 				 				"
			+ "<tr> 				<td class=\"auto-style2\"> 				"
			+ "<input name=\"operator\" type=\"submit\" value=\"+\"/> 				"
			+ "<input name=\"operator\" type=\"submit\"  value=\"-\"/> 				"
			+ "<input name=\"operator\" type=\"submit\"  value=\"*\"/> 				"
			+ "<input name=\"operator\" type=\"submit\"  value=\"/\"/></td> 		"
			+ "		</tr> 				</table> 		</form> 			<hr></div> "
			+ "			</body> </html>");
	
	
	
}
	
	

}
