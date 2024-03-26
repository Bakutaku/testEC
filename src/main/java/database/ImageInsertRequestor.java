package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 画像データ登録
 */
public class ImageInsertRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "insert images(control_id,path,count,creation_time) values(?,?,?,now())";
	
	// 実行に必要なパラメーター
	private int control_id;
	private String path;
	private int count;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setInt(1, control_id);
		ps.setString(2, path);
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
	public void execute(int countrol_id,String path,int count) {
		
		// パラメータ設定
		this.control_id = countrol_id;
		this.path = path;
		this.count = count;
		
		// 実行
		new TestECDAO().updata(this);
		
	}
}

