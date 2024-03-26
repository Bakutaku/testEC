package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import beans.Item;
import database.ItemIdRequestor;

/**
 * カートに追加
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		
		// 空の場合作成する
		if(carts == null) {
			carts = new HashMap<>();
			// sessionに保存
			session.setAttribute("cart", carts);
		}
		
		// ページ移動
		getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// セッション取得
		HttpSession session = request.getSession();
		
		// カートに追加できるか
		if(session.getAttribute("addCart") == null) {
			// できない場合
			getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
			return;
		}
		
		
		// カート取得
		Map<String, Cart> carts = (Map<String, Cart>) session.getAttribute("cart");
		
		// 空の場合作成する
		if(carts == null) carts = new HashMap<>();
		
		
		// データを取り出す
		String id = request.getParameter("cart");
		int count = Integer.parseInt(request.getParameter(id));
		
		// データベースからItemを取得
		Item item = new ItemIdRequestor().execute(Integer.parseInt(id));
		
		Cart cart = new Cart();
		
		cart.setItem(item);
		cart.setCount(count);
		
		// カートから同じ商品のものを取得
		Cart temp = carts.get(id);
		
		// カートに同じ商品があった場合、数を追加する
		if(temp != null) {
			cart.setCount(count + temp.getCount());
		}
		
		// カートに追加
		carts.put(id, cart);
		
		// sessionに保存
		session.setAttribute("cart", carts);
		
		// カートに商品を追加することを拒否にする
		session.setAttribute("addCart", null);
		
		getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
	}

}
