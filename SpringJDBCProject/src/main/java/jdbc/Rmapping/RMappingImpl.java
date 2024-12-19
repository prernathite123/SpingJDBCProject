package jdbc.Rmapping;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.RowMapper;

import jdbc.Entity.Student;

public class RMappingImpl implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s1=new Student();
		s1.setName(rs.getString("name"));
		s1.setId(rs.getInt("id"));
		s1.setMarks(rs.getDouble("marks"));
		
		
		return s1;
	}

	

}
