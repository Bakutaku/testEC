package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Image;
import beans.Item;

/**
 * 商品一覧取得(在庫がない物を除く)
 */
public class ItemAllRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "SELECT * FROM items WHERE inventory > 0";
	
	// 結果格納用
	private List<Item> items;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		return db.prepareStatement(SQL);
	}

	@Override
	public void setData(ResultSet rs) throws SQLException {
		
		// 初期化
		items = new ArrayList<>();
		
		// データ取り出し
		while(rs.next()) {
			Item item = new Item();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			item.setDescription(rs.getString("description"));
			item.setPrice(rs.getInt("price"));
			item.setInventory(rs.getInt("inventory"));
			item.setImage_id(rs.getInt("image_id"));
			
			
			// 画像のパスを取得
			List<Image> images = new ImageIdRequester().execute(item.getImage_id());
			
			// 表紙の画像を取得
			if(images.size() > 0) {
				item.setImage(images.get(0).getPath());
			}
			// リストに追加
			items.add(item);
		}
	}
	
	/**
	 * SQLを実行する
	 * @return {@link List}<{@link Item}>
	 */
	public List<Item> execute(){
		
		// 実行
		new TestECDAO().query(this);
		
		return items;
	}
	

}
