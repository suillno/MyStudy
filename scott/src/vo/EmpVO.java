package vo;

/**
 * java.sql.Date : DB와 상호 작용할때 날짜 형식만 처리하는 클래스 (SQL DATE 형식일때)
 * java.util.Date : 날짜, 시간, 밀리초 
 * 
 * java.sql.Time, java.sql.Timestemp 
 */
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EmpVO {

	// null 체크가 필요하면 앞자리를 대문자로 ex) long => Long
	private Long empNo;
	private String eName;
	private String job;
	private Long mgr;
	private Date hireDate;
	private Double sal;
	private Double comm;
	private Long deptNo;
	

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getMgr() {
		return mgr;
	}

	public void setMgr(Long mgr) {
		this.mgr = mgr;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Long getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", eName=" + eName + ", job=" + job + ", mgr=" + mgr + ", hireDate=" + hireDate
				+ ", sal=" + sal + ", comm=" + comm + ", deptNo=" + deptNo + "]";
	}

}
