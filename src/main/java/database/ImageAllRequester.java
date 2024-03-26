package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Image;

/**
 * 画像一覧取得
 */
public class ImageAllRequester implements DatabaseRequestor{

	private final String SQL = "SELECT * FROM images";
	
	// 結果格納用
	private List<Image> images;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);

		
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
			i.setId(rs.getInt("id"));
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
	public List<Image> execute(){

		
		// 実行
		new TestECDAO().query(this);
		
		// 結果を返す
		return images;
	}
	
	

}
