package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 商品登録
 */
public class ItemInsertRequestor implements DatabaseRequestor{

	// 実行するSQL
	private final String SQL = "insert items(name,image_id,description,price,inventory) values(?,?,?,?,?)";
	
	// 実行に必要なパラメーター
	private String name = "";
	private int image = 0;
	private String description = "";
	private int price = 0;
	private int inventory = 0;
	
	@Override
	public PreparedStatement getSQL(Connection db) throws SQLException {
		
		// SQL作成
		PreparedStatement ps = db.prepareStatement(SQL);
		
		// 必要なパラメータを設定
		ps.setString(1, name);
		ps.setInt(2, image);
		ps.setString(3, description);
		ps.setInt(4, price);
		ps.setInt(5, inventory);
		
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
	 * @param id
	 * @param name
	 * @param image
	 * @param description
	 * @param price
	 * @param inventory
	 */
	public void execute(String name ,int image,String description,int price,int inventory) {
		
		// パラメータ設定
		this.name = name;
		this.image = image;
		this.description = description;
		this.price = price;
		this.inventory = inventory;
		
		// 実行
		new TestECDAO().updata(this);
		
	}
}

