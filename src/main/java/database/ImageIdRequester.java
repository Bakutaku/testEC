package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Image;

/**
 * 画像データ取得
 */
public class ImageIdRequester implements DatabaseRequestor{

	private final String SQL = "SELECT * FROM images WHERE control_id = ?";
	
	// 結果格納用
	private List<Image> images;
	
	// 実行に必要なパラメーター
	private int control_id = 0;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setInt(1, control_id);
		
		// 完成したものを返す
		return ps;
	}

	@Override
	public void setData(ResultSet rs) throws SQLException {
		// 初期化
		images = new ArrayList<>();
		
		// データを取り出す
		while (rs.next()) {
			Image i = new Image();
			
			// データを設定
			i.setControl_id(rs.getInt("control_id"));
			i.setPath(rs.getString("path"));
			i.setCount(rs.getInt("count"));
			
			// リストに追加
			images.add(i);
		}
		
	}
	
	/**
	 * SQLを実行する
	 * @param id 
	 * @return {@link List}<{@link Image}>
	 */
	public List<Image> execute(int control_id){
		// パラメータを設定
		this.control_id = control_id;
		
		// 実行
		new TestECDAO().query(this);
		
		// 結果を返す
		return images;
	}
	
	

}
