 package jdbc.StudentDaoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.Entity.Student;
import jdbc.Rmapping.RMappingImpl;
import jdbc.StudentDaoUnimpl.StudentUnimpl;

public class StudentImple implements StudentUnimpl {

	public JdbcTemplate template;
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	@Override
	public int insert(Student s1) {
		
		String query ="insert into Student values(?,?,?);";
		int row=template.update(query,s1.getName(),s1.getId(),s1.getMarks());
		
		return row;
	}


	@Override
	public int update(Student s1, int id) {
	    // SQL query to update both name and marks in one statement
	    String query = "UPDATE Student SET name = ?, marks = ? WHERE id = ?;";
	    
	    // Execute the query and return the number of rows affected
	    return template.update(query, s1.getName(), s1.getMarks(), id);
	}


	@Override
	public int delete(int id) {
		String q1="delete From Student where id=?;";
		int row=template.update(q1,id);
		return row;
	}


	@Override
	public void getById(int id) {
		
		String q1="select * from Student where id=?;";
		RowMapper<Student> rm=new RMappingImpl();
		Student st=template.queryForObject(q1,rm,id);
		System.out.println(st);
		
		
		
	}


	@Override
	public List<Student> select() {
	    String q1 = "SELECT * FROM Student;";
	    RowMapper<Student> rm = new RMappingImpl();
	    
	    
	    List<Student> students = template.query(q1, rm);
	    
	    return students;
	}

	
	
}
