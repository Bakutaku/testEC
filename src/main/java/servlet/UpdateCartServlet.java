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
 * カート更新
 */
@WebServlet("/UpdateCart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
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
		
		// カートを更新する
		for(String key : carts.keySet()) {
			try {
				// 個数を取得
				int count = Integer.parseInt(request.getParameter("item-"+key));
				
				// カート内の個数を変更する
				carts.get(key).setCount(count);
				
				
			}catch (Exception e) {
				;
			}
		}
		
		// セッションに登録する
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
