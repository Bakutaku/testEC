package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;

/**
 * カートから削除
 */
@WebServlet("/DeleteCart")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// セッション取得
		HttpSession session = request.getSession();
		
		// カート取得
		Map<String,Cart> carts = (Map<String,Cart>) session.getAttribute("cart");
		
		// 空の場合
		if(carts == null) {
			
			// エラーが画面を表示させる
			getServletContext().getRequestDispatcher("/error.jsp?error=カートの中身が見つかりませんでした").forward(request, response);
			
			// 処理を停止
			return;
		}
		
		// パラメーター取得
		String id = request.getParameter("item");
		
		// カートから指定された商品を削除する
		carts.remove(id);
		
		// sessionに保存
		session.setAttribute("cart", carts);

		// ページ移動
		getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
