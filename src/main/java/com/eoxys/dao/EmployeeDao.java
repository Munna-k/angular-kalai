package com.eoxys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.eoxys.model.EmployeesData;

@Repository
public class EmployeeDao {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	DateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	static final class EmployeeDB{
		static String tableName = "employee_detail";
		static final String id ="id";
		static final String empId = "empId";
		static final String email = "email";
		static final String firstName = "firstName";
		static final String lastName = "lastName";
		static final String designation = "designation";
		static final String project = "project";
		static final String updated_at = "updated_at";
				
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	
	public class EmployeesMapper implements RowMapper<EmployeesData>{

		@Override
		public EmployeesData mapRow(ResultSet rs, int arg1) throws SQLException {
			
			EmployeesData data = new EmployeesData();
			data.setEmpId(rs.getString(EmployeeDB.empId));
			data.setEmail(rs.getString(EmployeeDB.email));
			data.setFirstName(rs.getString(EmployeeDB.firstName));
			data.setLastName(rs.getString(EmployeeDB.lastName));
			data.setProject(rs.getString(EmployeeDB.project));
			data.setDesignation(rs.getString(EmployeeDB.designation));
			data.setUpdated_at(rs.getString(EmployeeDB.updated_at));
			return data;
		}
		
	}

	public boolean insertData(String firstName, String lastName, String empId, String email, String designation,
			String project) {
		String SQL = " INSERT INTO "+ EmployeeDB.tableName + " (" + EmployeeDB.empId +","+ EmployeeDB.email +","+EmployeeDB.firstName +","
				+ EmployeeDB.lastName +","+ EmployeeDB.designation +","+ EmployeeDB.project +","+ EmployeeDB.updated_at +") VALUES(?, ?, ?, ?, ?, ?, ?)";
		Date date = new Date();
		System.out.println("query is "+SQL);
		System.out.println("firstName is --> "+firstName);
		System.out.println(empId+","+ email+","+ firstName+","+lastName+","+designation+","+project+","+dateFormat.format(date));
		return jdbcTemplateObject.update(SQL,new Object[] {empId, email, firstName, lastName, designation, project, date}) > 0 ? true : false;
	}
	

}
