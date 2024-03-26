package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * データベースリクエストのインタフェース
 */
public interface DatabaseRequestor {

	/**
	 * PreparedStatementのSQLを取得する
	 * @param db {@link Connection}
	 * @return {@link PreparedStatement}
	 * @throws SQLException 
	 */
	public PreparedStatement getSQL(Connection db) throws SQLException;
	
	
	/**
	 * データを取り出す
	 * @param rs {@link ResultSet}
	 * @throws SQLException 
	 */
	public void setData(ResultSet rs) throws SQLException;
	
}
