package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 在庫更新
 */
public class ItemUpdateInventoryRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "UPDATE items SET inventory = inventory - ? WHERE id = ?";
	
	// 実行に必要なパラメーター
	private int id = 0;
	private int inventory = 0;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setInt(1, inventory);
		ps.setInt(2, id);
		
		// 完成したものを返す
		return ps;
	}

	@Override
	public void setData(ResultSet rs) throws SQLException {
		// 今回はデータ取り出しなし
		;
	}
	

	/**
	 * SQLを実行する
	 * @param id 対象商品のID
	 * @param inventory 減らす数
	 */
	public void execute(int id,int inventory) {
		
		// パラメータ設定
		this.id = id;
		this.inventory = inventory;
		
		// 実行
		new TestECDAO().updata(this);
		
	}
}