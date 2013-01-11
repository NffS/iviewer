package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import test.User;
import DAO.Factory;

/**
 * Servlet implementation class TestDB
 */
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Locale.setDefault(Locale.ENGLISH);
			List<User> usrs = Factory.getInstance().getUserDAO().getAllUsers();
			PrintWriter out = response.getWriter();
			try {
				out.print("<HTML><BODY>=============All users========== ");
				for(int i = 0; i < usrs.size(); ++i) {
				out.print("<br>");
				out.print(i+". "+usrs.get(i).getFirst_name()+" "+usrs.get(i).getLast_name()+" "+usrs.get(i).getSurname()
						+", "+usrs.get(i).getEmail());
				}
				out.print("</BODY></HTML>");
			}
			finally {
				out.close();
			}
		}catch(SQLException e){
			
		}
	}

}
