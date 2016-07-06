package myservlet.controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myclass.bol.goodsInfo;
import myclass.dal.goodsDal;

/**
 * Servlet implementation class goodsDiscription
 */
@WebServlet("/goodsDiscription")
public class goodsDiscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsDiscription() {
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
		String shangpinId = request.getParameter("shangpinid");
		goodsDal gd=new goodsDal();
		goodsInfo gi=new goodsInfo();
		shangpinId=gd.toUtf8(shangpinId);
		gi=gd.getgoodsId(shangpinId);
		request.getSession().setAttribute("goodsdiscription", gi);
		RequestDispatcher dis = request.getRequestDispatcher("/single.jsp");
		dis.forward(request, response);
		
	}

}
