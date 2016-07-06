package myservlet.controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myclass.bll.cartBll;

/**
 * Servlet implementation class deleteCart
 */
@WebServlet("/deleteCart")
public class deleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCart() {
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
		RequestDispatcher dis = request.getRequestDispatcher("shoppingcart.jsp");
		try {
			cartBll cb=new cartBll();
			String deletecartid=request.getParameter("deleteid");
			System.out.println(deletecartid);
			String jieguo=cb.deleteshoppingcartbyid(deletecartid);
			if(!jieguo.equals("")){
				request.setAttribute("warning", "É¾³ýÊ§°Ü");
				request.setAttribute("returnurl", "sellitems.jsp");
				dis = request.getRequestDispatcher("warning.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("warning", "É¾³ýÊ§°Ü");
			request.setAttribute("returnurl", "sellitems.jsp");
			dis = request.getRequestDispatcher("warning.jsp");
		}
		
		
		dis.forward(request, response);
	}

}
