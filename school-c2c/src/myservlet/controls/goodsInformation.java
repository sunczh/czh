package myservlet.controls;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myclass.bol.goodsInfo;
import myclass.dal.goodsDal;

/**
 * Servlet implementation class goodsInformation
 */
@WebServlet("/goodsInformation")
public class goodsInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public goodsInformation() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<goodsInfo>goods=new ArrayList<goodsInfo>();
		String item = request.getParameter("item");
		goodsDal gd=new goodsDal();
		item=gd.toUtf8(item);
		if(item.equals("all")){
			goods=gd.getgoodsAll();
		}else if(item.equals("shenghuoyongpin")){
			goods=gd.getgoodsAstype("������Ʒ");
		}else if(item.equals("xuexiwenju")){
			goods=gd.getgoodsAstype("ѧϰ�ľ�");
		}else if(item.equals("yiwu")){
			goods=gd.getgoodsAstype("����");
		}else if(item.equals("xuexiziliao")){
			goods=gd.getgoodsAstype("ѧϰ����");
		}else if(item.equals("xianzhishuma")){
			goods=gd.getgoodsAstype("��������");
		}else if(item.equals("xiebao")){
			goods=gd.getgoodsAstype("Ь��");
		}else if(item.equals("guizhongwupin")){
			goods=gd.getgoodsAstype("������Ʒ");
		}else{
			goods=gd.getgoodsAstype("��������");
		}
		request.setAttribute("goods", goods);
		RequestDispatcher dis = request.getRequestDispatcher("/sellitems.jsp");
		dis.forward(request, response);
	}

}
