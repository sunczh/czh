package myservlet.controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myclass.bll.cartBll;
import myclass.bol.goodsInfo;
import myclass.bol.userInfo;

/**
 * Servlet implementation class shoppingcart
 */
@WebServlet("/shoppingcart")
public class shoppingcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buyerName="";
		cartBll cb=new cartBll();
		goodsInfo gd=new goodsInfo();
		userInfo ui=new userInfo();
		RequestDispatcher dis = request.getRequestDispatcher("shoppingcart.jsp");
		try {			
			gd=(goodsInfo)request.getSession().getAttribute("goodsdiscription");			
			ui=(userInfo)request.getSession().getAttribute("user");
			 buyerName=ui.getUserName();			
				String jieguo=cb.addshoppingcart(buyerName, gd, "Î´Ö§¸¶");
				if(!jieguo.equals("")){
					request.setAttribute("warning", jieguo);
					request.setAttribute("returnurl", "sellitems.jsp");
					dis = request.getRequestDispatcher("warning.jsp");
				}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("warning", "ÇëµÇÂ¼ºóÔÙ¹ºÂò");
			request.setAttribute("returnurl", "login.jsp");
			dis = request.getRequestDispatcher("warning.jsp");
			System.out.println("³ö´íÁË");
		}
		
			
		dis.forward(request, response);
	}

}
