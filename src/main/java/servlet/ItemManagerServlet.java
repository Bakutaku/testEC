package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Image;
import beans.Item;
import database.ImageAllRequester;
import database.ImageUpdateRequestor;
import database.ItemAllNoWhereRequestor;
import database.ItemUpdateRequestor;

/**
 * 商品管理
 */
@WebServlet("/ItemManager")
public class ItemManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// すべての商品(在庫なしも含む)を取得し渡す
		request.setAttribute("items", new ItemAllNoWhereRequestor().execute());
		
		// すべての画像を取得し渡す
		request.setAttribute("images", new ImageAllRequester().execute());
		
		getServletContext().getRequestDispatcher("/itemManager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// データベース準備
		ItemUpdateRequestor updateItem = new ItemUpdateRequestor();
		ImageUpdateRequestor updateImage = new ImageUpdateRequestor();
		
		// 登録されているすべての商品を取得
		List<Item> items = new ItemAllNoWhereRequestor().execute();
		
		// 登録されているすべての画像を取得
		List<Image> images = new ImageAllRequester().execute();
		
		try {
			// 商品の内容を変更する
			for(Item i : items) {
				i.setName(request.getParameter(i.getId()+"-Name"));
				i.setPrice(Integer.parseInt(request.getParameter(i.getId()+"-Price")));
				i.setInventory(Integer.parseInt(request.getParameter(i.getId()+"-Inventory")));
				i.setImage_id(Integer.parseInt(request.getParameter(i.getId()+"-Image")));
				i.setDescription(request.getParameter(i.getId()+"-Description"));
				i.setImage("");
			}
			
			// 画像の内容を変更する
			for(Image img : images) {
				img.setControl_id(Integer.parseInt(request.getParameter(img.getId()+"-Control_id")));
				img.setPath(request.getParameter(img.getId()+"-Path"));
				img.setCount(Integer.parseInt(request.getParameter(img.getId()+"-Count")));
			}
			
			// データベースを変更する
			for(Item i : items) {
				updateItem.execute(i.getId(), i.getName(), i.getImage_id(), i.getDescription(), i.getPrice(), i.getInventory());
			}
			for(Image img : images) {
				updateImage.execute(img.getId(), img.getControl_id(), img.getPath(), img.getCount());
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
