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
import beans.Item;
import database.HistorysInsertRequestor;
import database.ItemIdRequestor;
import database.ItemUpdateInventoryRequestor;

/**
 * 商品購入
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
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
		Map<String, Cart> carts = (Map<String, Cart>) session.getAttribute("cart");
		
		// データベース処理の準備
		ItemIdRequestor itemIdRe = new ItemIdRequestor();
		ItemUpdateInventoryRequestor itemUpdateRe = new ItemUpdateInventoryRequestor();
		HistorysInsertRequestor historyInsertRe = new HistorysInsertRequestor();
		
		
		// 在庫確認用
		boolean flg = true;
		
		// 在庫があるのか確認
		for(String key : carts.keySet()) {
			Cart c = carts.get(key);
			// データベースから対象の商品を取得する
			Item item = itemIdRe.execute(c.getItem().getId());
			
			// 商品を取得できなかったら処理を停止する
			if(item == null) {
				flg = false;
				break;
			}
			
			// 在庫を確認する
			if(c.getCount() > item.getInventory()) {
				// 在庫がない場合
				flg = false;
				break;
			}
		}
		
		// 在庫があるかどうか
		if(flg) {
			// 在庫がある場合
			for(String key : carts.keySet()) {
				Cart c = carts.get(key);
				// 在庫更新
				itemUpdateRe.execute(c.getItem().getId(), c.getCount());
			}
			
			// 購入履歴を追加
			for(String key : carts.keySet()) {
				Cart c = carts.get(key);
				
				// 履歴追加
				historyInsertRe.execute(request.getRemoteUser(),c.getItem().getId(),c.getCount());
				
				log("["+request.getRemoteAddr()+"]"+request.getRemoteUser()+"が"+c.getItem().getName()+"を"+c.getCount()+"個、購入しました。");
			}
			
			// カート削除
			session.setAttribute("cart", null);
			
			getServletContext().getRequestDispatcher("/completed.jsp").forward(request, response);
			
		}else {
			// 在庫がない場合
			getServletContext().getRequestDispatcher("/home").forward(request, response);

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
