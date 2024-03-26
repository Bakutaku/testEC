package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Cart;

/**
 * 履歴取得
 */
public class HistoryIdRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "SELECT item_id,count FROM historys WHERE user_id = ?";
	
	// 実行に必要なパラメータ
	private String id;
	
	// 結果格納用
	private List<Cart> carts;
	
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// パラメータ設定
		ps.setString(1, id);
		
		// 完成したものを渡す
		return ps;
	}

	@Override
	public void setData(ResultSet rs) throws SQLException {
		
		// 初期化
		carts = new ArrayList<>();
		
		// データベース準備
		ItemIdRequestor itemidRe = new ItemIdRequestor();
		
		// データ取り出し
		while(rs.next()) {
			Cart c = new Cart();
			
			// データと取り出し格納する
			c.setItem(itemidRe.execute(rs.getInt("item_id")));
			c.setCount(rs.getInt("count"));
			
			// リストに追加
			carts.add(c);
		}
	}
	
	/**
	 * SQLを実行する
	 * @return {@link List}<{@link Cart}>
	 */
	public List<Cart> execute(String id){
		
		// パラメータ設定
		this.id = id;
		
		// 実行
		new TestECDAO().query(this);
		
		return carts;
	}
	

}
