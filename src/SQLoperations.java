import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLoperations {
	
	Connection con;
	
	public SQLoperations() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/survey";
		String usr = "root";
		String pass = "3XXXXXX";//password unique to individual users
		con = DriverManager.getConnection(url, usr, pass);
	}
	
	public void newUser(String name, String uname, String pass) throws SQLException {
		String str = "INSERT INTO actors(fname, uname, pass) values ('"+name+"', '"+uname+"', '"+pass+"')";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}
	
	public int authUser(String uname, String pass) throws SQLException {
		String str = "SELECT * FROM actors WHERE uname = '"+uname+"'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		if (!rst.next())
			return -1;
		else {
			if(rst.getString("pass").equals(pass))
				return rst.getInt("id");
			else
				return 0;
		}
	}
	
	public void newQuestion(String code, String question, String op1, String op2, String op3, String op4) throws SQLException {
		String str = "INSERT INTO questions values ('"+code+"', '"+question+"', '"+op1+"', '"+op2+"', '"+op3+"', '"+op4+"')";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}
	
	public void userQuestionAdd(int id, String quizcode) throws SQLException {
		String str = "INSERT INTO userQuestions values ("+id+", '"+quizcode+"', 0)";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}
	
	public void answerUpdt(String quizcode, int qno, int option) throws SQLException {
		String str = "INSERT INTO quizquestions values ('"+quizcode+"', " + qno + ", " + option + ")";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}
	
	public ResultSet getQuestions(String quizcode) throws SQLException {
		String str = "SELECT * FROM questions WHERE quizcode = '"+quizcode+"'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		return rst;
	}
	
	public ResultSet surveys(int id, String search) throws SQLException {
		String str = "SELECT * FROM userQuestions WHERE id = "+id+" and quizcode like '%"+search+"%'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		return rst;
	}
	
	public void addTotal() throws SQLException {
		String str = "UPDATE userQuestions SET total = total+1";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}
	
	public boolean check(String search) throws SQLException {
		String str = "SELECT * FROM userQuestions WHERE quizcode = '"+search+"'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		if(rst.next())
			return true;
		else
			return false;
	}
	
	public void removeSurvey(String quizcode) throws SQLException {
		String str = "DELETE FROM questions WHERE quizcode = '"+quizcode+"'";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
		str = "DELETE FROM quizquestions WHERE quizcode = '"+quizcode+"'";
		stm.executeUpdate(str);
		str = "DELETE FROM userQuestions WHERE quizcode = '"+quizcode+"'";
		stm.executeUpdate(str);
	}
	
	public int getCount(String quizcode, int qno, int op) throws SQLException {
		String str = "SELECT count(opno) FROM quizquestions WHERE quizcode = '"+quizcode+"' AND qno = "+(qno+1)+" AND opno = "+op;
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		if(rst.next())
			return rst.getInt("count(opno)");
		else
			return 0;
	}
	
}
