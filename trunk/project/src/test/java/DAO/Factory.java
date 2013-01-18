package DAO;

import DAO.Impl.UserDAOImpl;
import DAO.Impl.Users_typeDAOImpl;
import DAO.Impl.FormDAOImpl;
import DAO.Impl.InterviewDAOImpl;
import DAO.Impl.HR_markDAOImpl;

public class Factory {
     
      private static UserDAO userDAO = null;
      private static InterviewDAO interviewDAO = null;
      private static Users_typeDAO users_typeDAO = null;
      private static FormDAO formDAO = null;
      private static HR_markDAO hr_markDAO = null;
      private static Factory instance = null;

      public static synchronized Factory getInstance(){
            if (instance == null){
              instance = new Factory();
            }
            return instance;
      }

      public UserDAO getUserDAO(){
            if (userDAO == null){
              userDAO = new UserDAOImpl();
            }
            return userDAO;
      }
      
      public Users_typeDAO getUsers_typeDAO(){
    	  if(users_typeDAO == null){
    		  users_typeDAO = new Users_typeDAOImpl();
    	  }
    	  return users_typeDAO;
      }
      
      public InterviewDAO getInterviewDAO(){
    	  if(interviewDAO == null){
    		  interviewDAO = new InterviewDAOImpl();
    	  }
    	  return interviewDAO;
      }
      
      public HR_markDAO getHR_markDAO(){
    	  if(hr_markDAO == null){
    		  hr_markDAO = new HR_markDAOImpl();
    	  }
    	  return hr_markDAO;
      }
      
      public FormDAO getFormDAO(){
    	  if(formDAO == null){
    		  formDAO = new FormDAOImpl();
    	  }
    	  return formDAO;
      }
}