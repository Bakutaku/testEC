package beans;


/**
 * 画像情報
 */
public class Image {
	private int id;
	private int control_id;
	private String path;
	private int count;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getControl_id() {
		return control_id;
	}
	public void setControl_id(int id) {
		this.control_id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
