package http;

import java.util.ArrayList;
import java.util.List;

public class AccData<T> {
	private List<T> data = new ArrayList<T>();

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	private String msg;
	private String otherStr;
	private String pageStr;
	private boolean success;
	private int totalCount;
	private String url;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getOtherStr() {
		return otherStr;
	}

	public void setOtherStr(String otherStr) {
		this.otherStr = otherStr;
	}

	public String getPageStr() {
		return pageStr;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
