package board.crud.bbs.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DeptVO {
    private String deptCd;
    private String deptName;
    private String deptId;
    private String fullName;
    private int salary;
    private String gender;
    private String memo;
    private Date hireDate;
    private String married;
    private String posName;
    private String posCode;
	public void setDeptId(String id) {
		// TODO Auto-generated method stub
		
	}

}
