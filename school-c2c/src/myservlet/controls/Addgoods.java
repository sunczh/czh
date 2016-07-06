package myservlet.controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myclass.bll.goodsBll;
import myclass.bol.userInfo;
import myclass.dal.goodsDal;
import myclass.dal.timeDal;

/**
 * Servlet implementation class Addgoods
 */
@WebServlet("/Addgoods")
public class Addgoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Addgoods() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dis = request.getRequestDispatcher("/warning.jsp");
		userInfo user = (userInfo)request.getSession().getAttribute("user");
		if(user!=null){
		String username=user.getUserName();
		if(!username.equals(null)&&!username.equals("")){
			String goodsName=request.getParameter("wpmc");
			String oldOrnew=request.getParameter("xjcd");
			String goodsprice=request.getParameter("jg");
			String contact=request.getParameter("lxfs");
			String goodstype=request.getParameter("wpzl");
			String discription=request.getParameter("discription");
		goodsDal gd=new goodsDal();
		timeDal td=new timeDal();
		goodsName=gd.toUtf8(goodsName);
		oldOrnew=gd.toUtf8(oldOrnew);
		goodsprice=gd.toUtf8(goodsprice);
		contact=gd.toUtf8(contact);
		goodstype=gd.toUtf8(goodstype);
		discription=gd.toUtf8(discription);
		String shangjiaDate=td.getNowtime();
		goodsBll gb=new goodsBll();
		String jieguo=gb.addgoodsyanzheng(goodsName, oldOrnew, goodsprice, contact, goodstype, discription);
		if(jieguo.equals("")){
		gd.addGoods(goodsName, oldOrnew, shangjiaDate, discription, username, contact, "", "images/nopicture.jpg", goodsprice, goodstype);
		dis = request.getRequestDispatcher("/sellitems.jsp");}
		else {
			request.setAttribute("warning", jieguo);
			request.setAttribute("returnurl", "release.jsp");
		}
		}
		else{
		System.out.println("没有用户");
		}
		}else {
			request.setAttribute("warning", "用户未登录");
			request.setAttribute("returnurl", "login.jsp");
		}

			dis.forward(request, response);

	
	}

}
