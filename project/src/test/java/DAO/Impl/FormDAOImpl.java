package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import util.HibernateUtil;
import DAO.FormDAO;
import test.Form;

public class FormDAOImpl implements FormDAO{

	public void addForm(Form form) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(form);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

	public void updateForm(Form form) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(form);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

	public Form getFormById(int id) throws SQLException {
		Session session = null;
        Form form = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            form = (Form) session.get(Form.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return form;
	}

	public List getAllForms() throws SQLException {
		Session session = null;
        List<Form> forms = new ArrayList<Form>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            forms = session.createCriteria(Form.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return forms;
	}

	public void deleteForm(Form form) throws SQLException {
		 Session session = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.delete(form);
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
