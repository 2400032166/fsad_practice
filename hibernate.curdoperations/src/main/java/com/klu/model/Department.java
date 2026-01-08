package com.klu.model;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="dept")

public class Department {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int deptid;
private String deptname;

@OneToMany(mappedBy = "department",cascade=CascadeType.ALL)

 private List<Employee> employee;
public int getDeptid() {
	return deptid;
}
public void setDeptid(int deptid) {
	this.deptid = deptid;
}
public String getDeptname() {
	return deptname;
}
public void setDeptname(String deptname) {
	this.deptname = deptname;
}
}