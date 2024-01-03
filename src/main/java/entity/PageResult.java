package entity;
import java.io.Serializable;
import java.util.List;
/**
 * 分页结果的实体类
 */
public class PageResult implements Serializable{
	private long total; // 总数
	private long pages; //总页数
	private long pageNum; //当前页码
	private List rows; // 返回的数据集合

	public PageResult(long total, long pages, long pageNum, List rows) {
		super();
		this.total = total;
		this.pages = pages;
		this.pageNum = pageNum;
		this.rows = rows;
	}

//	public PageResult(long total, List rows) {
//		super();
//		this.total = total;
//		this.rows = rows;
//	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
