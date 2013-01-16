package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import util.HibernateUtil;
import DAO.Users_typeDAO;
import test.Users_type;

public class Users_typeDAOImpl implements Users_typeDAO{

	public void addUser_type(Users_type user_type) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user_type);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

	public void updateUser_type(Users_type user_type) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user_type);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

	public Users_type getUser_typeById(int id) throws SQLException {
		 Session session = null;
         Users_type user_type = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             user_type = (Users_type) session.get(Users_type.class, id);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
         } finally {
             if (session != null && session.isOpen()) {
                 session.close();
             }
         }
         return user_type;
	}

	public List getAllUser_types() throws SQLException {
		Session session = null;
        List<Users_type> user_types = new ArrayList<Users_type>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user_types = session.createCriteria(Users_type.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user_types;
	}

	public void deleteUser_type(Users_type user_type) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user_type);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

	
}
