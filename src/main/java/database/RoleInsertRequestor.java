package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ロール追加
 */
public class RoleInsertRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "insert user_roles(userid,role) values(?,?)";
	
	// 実行に必要なパラメーター
	private String userid;
	private String role;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setString(1, userid);
		ps.setString(2, role);
		
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
	 */
	public void execute(String userid,String role) {
		
		// パラメータ設定
		this.userid = userid;
		this.role = role;
		
		// 実行
		new TestECDAO().updata(this);
		
	}
}

