package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * データベースとのやり取りをするクラス
 *
 */
public class TestECDAO {
	
	// 接続先データベース
	private final String url = "java:comp/env/jdbc/testEC";
	
	
	public void query(DatabaseRequestor re){
		
		Connection db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// データベース接続
			db = ((DataSource) new InitialContext().lookup(url)).getConnection();
			
			
			// SQL作成
			ps = re.getSQL(db);
			
			// 実行
			rs = ps.executeQuery();
			
			// データ取り出し
			re.setData(rs);
			
			// レスポンスを閉じる
			rs.close();
			
		}catch (SQLException | NamingException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("予期しないエラー:"+e.getMessage());
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(db != null) {db.close();}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	};
	
	public void updata(DatabaseRequestor re) {
		
		Connection db = null;
		PreparedStatement ps = null;
		
		try {
			
			// データベース接続
			db = ((DataSource) new InitialContext().lookup(url)).getConnection();
			
			// SQL作成
			ps = re.getSQL(db);
			
			// 実行
			ps.executeUpdate();
			
			
		}catch (SQLException | NamingException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("予期しないエラー:"+e.getMessage());
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(db != null) {db.close();}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
