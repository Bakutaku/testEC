package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ユーザ追加
 */
public class UserInsertRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "insert users(userid,passwd) values(?,?)";
	
	// 実行に必要なパラメーター
	private String userid;
	private String passwd;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setString(1, userid);
		ps.setString(2, passwd);
		
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
	public void execute(String userid,String passwd) {
		
		// パラメータ設定
		this.userid = userid;
		this.passwd = passwd;
		
		// 実行
		new TestECDAO().updata(this);
		
	}
}

