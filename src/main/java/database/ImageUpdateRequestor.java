package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 画像データ更新
 */
public class ImageUpdateRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "UPDATE images SET control_id = ?,path = ?,count = ? WHERE id = ?";
	
	// 実行に必要なパラメーター
	private int id = 0;
	private int control_id = 0;
	private String path = "";
	private int count = 0;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setInt(1, control_id);
		ps.setString(2, path);
		ps.setInt(3, count);
		ps.setInt(4, id);
		
		// 完成したものを返す
		return ps;
	}

	@Override
	public void setData(ResultSet rs) throws SQLException {
		// 今回はデータ取り出しなし
		;
	}
	

	public void execute(int id,int control_id,String path,int count) {
		
		// パラメータ設定
		this.id = id;
		this.control_id = control_id;
		this.path = path;
		this.count = count;
		
		// 実行
		new TestECDAO().updata(this);
		
	}
}

