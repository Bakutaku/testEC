package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

/**
 * ユーザ取得
 */
public class UserIdRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "SELECT userid FROM users WHERE userid = ?";
	
	// 結果格納用
	private User user;
	
	// 実行に必要なパラメーター
	private String id;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setString(1, id);
		
		// 完成したものを返す
		return ps;
	}

	@Override
	public void setData(ResultSet rs) throws SQLException {
		
		// 初期化
		user = new User();
		
		// データがあるかどうか
		if(rs.next()) {
			// データを格納
			user.setUserid(rs.getString("userid"));
		}
	}
	
	/**
	 * SQLを実行する
	 * @return {@link User}
	 */
	public User execute(String id){
		
		// パラメータ設定
		this.id = id;
		
		// 実行
		new TestECDAO().query(this);
		
		// 結果を返す
		return user;
	}
}
