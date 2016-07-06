package myservlet.controls;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myclass.bll.userBll;
import myclass.bol.userInfo;

/**
 * Servlet implementation class userLogin
 */
@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userLogin() {
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
		// TODO Auto-generated method stub
		userBll ub = new userBll();
		userInfo ui = new userInfo();
		RequestDispatcher dis = request.getRequestDispatcher("/warning.jsp");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		username = ub.toUtf8(username);
		password = ub.toUtf8(password);
		ui = ub.userLogin(username, password);
		if (ui != null && ui.getUserName() != null) {
			request.getSession().setAttribute("user", ui);
			dis = request.getRequestDispatcher("/index.jsp");
		}
		request.setAttribute("warning", "用户名或密码输入错误，请重新输入");
		request.setAttribute("returnurl", "login.jsp");
		dis.forward(request, response);
	}

}
