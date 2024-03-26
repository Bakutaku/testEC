package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.RoleInsertRequestor;
import database.UserIdRequestor;
import database.UserInsertRequestor;

/**
 * アカウント作成
 */
@WebServlet("/Sign")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private final String DEF_ROLE = "user";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/signUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// パラメータ取得
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		// データベース接続準備
		UserIdRequestor userIdRe = new UserIdRequestor();
		UserInsertRequestor userInsertRe = new UserInsertRequestor();
		RoleInsertRequestor roleInsertRe = new RoleInsertRequestor();
		
		// 登録されているか調べる
		if(userIdRe.execute(name).getUserid() == null) {
			// 登録されていない場合
			
			// ユーザを登録する
			userInsertRe.execute(name, password);
			
			// ロールを登録する
			roleInsertRe.execute(name, DEF_ROLE);
			
			log("アカウントが作成されました。("+name+")");
			
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
		}else {
			getServletContext().getRequestDispatcher("/error.jsp?error=すでにユーザIDが使用されています&error-title=アカウント作成に失敗しました").forward(request, response);
		}
		
		
		
	}

}
