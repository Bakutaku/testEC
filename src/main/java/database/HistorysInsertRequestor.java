package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 履歴追加
 */
public class HistorysInsertRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "insert historys(user_id,item_id,count,time) values(?,?,?,now())";
	
	// 実行に必要なパラメーター
	private String user_id;
	private int item_id;
	private int count;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setString(1, user_id);
		ps.setInt(2, item_id);
		ps.setInt(3, count);
		
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
	 * @param countrol_id
	 * @param path
	 * @param count
	 */
	public void execute(String user_id,int item_id,int count) {
		
		// パラメータ設定
		this.user_id = user_id;
		this.item_id = item_id;
		this.count = count;
		
		// 実行
		new TestECDAO().updata(this);
		
	}
}

