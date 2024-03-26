package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 商品削除
 */
public class ItemDeleteRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "delete from items where id = ?";
	
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
		// 今回はデータ取り出しなし
		;
	}
	

	/**
	 * SQLを実行する
	 * @param id
	 */
	public void execute(int id) {
		
		// パラメータ設定
		this.id = id;
		
		// 実行
		new TestECDAO().updata(this);
		
	}
}

