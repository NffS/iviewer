package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import test.User;
import test.Users_type;
import test.Form;
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Locale.setDefault(Locale.ENGLISH);
			Factory factory = Factory.getInstance();
			List<User> usrs = factory.getUserDAO().getAllUsers();
			List<Users_type> users_types =factory.getUsers_typeDAO().getAllUser_types();
			Form form=factory.getFormDAO().getFormById(1);
			PrintWriter out = response.getWriter();
			try {
				out.print("<HTML><BODY>=============All users========== ");
				for(int i = 0; i < usrs.size(); i++) {
					out.print("<br>");
					out.print(i+". "+usrs.get(i).getFirst_name()+" "+usrs.get(i).getLast_name()+" "+usrs.get(i).getSurname()
						+", "+usrs.get(i).getEmail());
				}
				out.print("<br>");
				out.print("<br>");
				out.print("<br>");
				out.print("===========All users types======== ");
				for(int i = 0; i < users_types.size(); i++) {
					out.print("<br>");
					out.print(users_types.get(i).getUser_type_id()+" "+users_types.get(i).getType_name());
					
				}
				out.print("<br>");
				out.print("<br>");
				out.print("<br>");
				out.print("=============Some form==============");
				out.print("<br>");
				out.print("<br>");
				out.print(form.getForm_id());
				out.print("<br>");
				for(int i=0; i<usrs.size();i++){
					if(form.getCandidate_id()==usrs.get(i).getUserId()){
						form.setUser(usrs.get(i));
						usrs.get(i).setForm(form);
					}
				}
				out.print(form.getCandidate_id()+" "+form.getUser().getFirst_name()
						+" "+form.getUser().getLast_name());
				out.print("<br>");
				out.print("University "+form.getUniversity());
				out.print("<br>");
				out.print("Faculty "+form.getFaculty());
				out.print("<br>");
				out.print("Course "+form.getCourse());
				out.print("<br>");
				out.print(form.getSource());
				
				out.print("</BODY></HTML>");
			}
			finally {
				out.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
