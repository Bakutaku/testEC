package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.Image;
import beans.Item;

/**
 * 特定の商品取得
 */
public class ItemIdRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "SELECT * FROM items WHERE id = ?";
	
	// 結果格納用
	private Item item;
	
	// 実行に必要なパラメーター
	private int id = 0;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setInt(1, id);
		
		// 完成したものを返す
		return ps;
	}

	@Override
	public void setData(ResultSet rs) throws SQLException {
		
		// 初期化
		item = new Item();
		
		// データがあるかどうか
		if(rs.next()) {
			// データを取り出す
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			item.setImage_id(rs.getInt("image_id"));
			item.setDescription(rs.getString("description"));
			item.setPrice(rs.getInt("price"));
			item.setInventory(rs.getInt("inventory"));
			
			// 画像のパスを取得
			List<Image> images = new ImageIdRequester().execute(item.getImage_id());
			
			// 表紙の画像を取得
			item.setImage(images.get(0).getPath());
		}
	}
	
	/**
	 * SQLを実行する
	 * @return {@link Item}
	 */
	public Item execute(int id){
		
		// パラメータ設定
		this.id = id;
		
		// 実行
		new TestECDAO().query(this);
		
		// 結果を返す
		return item;
	}
}
