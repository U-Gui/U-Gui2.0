package cn.edu.neu.vo;

//返回的json对象
public class backJSON {
	private int code;
	private Object data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "backJSON [code=" + code + ", data=" + data + "]";
	}
	public backJSON(int code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}
	public backJSON() {
		// TODO Auto-generated constructor stub
	}
}
