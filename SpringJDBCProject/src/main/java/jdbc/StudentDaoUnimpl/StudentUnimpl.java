package jdbc.StudentDaoUnimpl;

import java.util.List;

import jdbc.Entity.Student;

public interface StudentUnimpl {

	public int insert(Student s1);
	
	public int update(Student s1,int id);
	
	public int delete(int id);
	
	public void getById(int id);
	
	public List<Student> select();
	
}
