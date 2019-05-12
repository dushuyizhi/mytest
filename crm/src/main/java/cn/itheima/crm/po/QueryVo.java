package cn.itheima.crm.po;
/**
 * 综合条件po
 * @author 刘政
 *
 */
public class QueryVo {
	private String custName; //客户姓名
	private String custSource;  //客户来源
	private String custIndustry; //客户行业
	private String custLevel;  //客户等级
	
	//分页数据
	private Integer start;  //开始索引
	private Integer page=1;  //第几页
	private Integer rows=10;//每页显示多少条数据
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	
	
}
