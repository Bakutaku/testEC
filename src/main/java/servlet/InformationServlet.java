package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Item;
import database.ItemIdRequestor;

/**
 * 詳細表示
 */
@WebServlet("/info")
public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// パラメータ取得
		int itemId = Integer.parseInt(request.getParameter("item"));
		
		// データベース準備
		ItemIdRequestor itemReq = new ItemIdRequestor();
		
		// データベースから商品情報を取得
		Item item = itemReq.execute(itemId);
		
		// ページに渡す
		request.setAttribute("item", item);
		
		// ページ遷移
		getServletContext().getRequestDispatcher("/information.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
