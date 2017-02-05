package cn.com.shukaiken.model;

/**
 * base bean
 * @author jiexuan.zhu
 *
 */
public class BaseModel {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -8347151078560938057L;
	
	//每页大小
	protected Integer pageSize;
	
	//起始行
	protected Integer startRow;
	
	//结束行
	protected Integer endRow;
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
}
