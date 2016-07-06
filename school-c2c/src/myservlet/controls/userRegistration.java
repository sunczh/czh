package myservlet.controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myclass.bll.userBll;
import myclass.dal.timeDal;
import myclass.dal.userDal;

/**
 * Servlet implementation class userRegistration
 */
@WebServlet("/userRegistration")
public class userRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegistration() {
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
		userBll ub=new userBll();
		userDal ud=new userDal();
		timeDal td=new timeDal();

		RequestDispatcher dis = request.getRequestDispatcher("/zhucejieguo.jsp");
		String userid=request.getParameter("userid");
		String realname=request.getParameter("realname");
		String email=request.getParameter("email");
		String userpassword1=request.getParameter("userpassword1");
		String userpassword2=request.getParameter("userpassword2");
		String userphone=request.getParameter("userphone");
		String secondpassword=request.getParameter("secondpassword");

		userid=ub.toUtf8(userid);
		realname=ub.toUtf8(realname);
		email=ub.toUtf8(email);
		userpassword1=ub.toUtf8(userpassword1);
		userpassword2=ub.toUtf8(userpassword2);
		userphone=ub.toUtf8(userphone);
		secondpassword=ub.toUtf8(secondpassword);
		String zhucejieguo=ub.userRegistration(userid, userpassword1, userpassword2, email, userphone, secondpassword);
		if(zhucejieguo.equals("")){	
		ud.addUser(userid, userpassword1, email, userphone, realname, "user", secondpassword,td.getNowtime(),"");
		
		}
		request.setAttribute("zhucejieguo", zhucejieguo);
		dis.forward(request, response);
	}

}
