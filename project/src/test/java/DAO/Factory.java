package DAO;

import DAO.Impl.UserDAOImpl;
import DAO.Impl.Users_typeDAOImpl;
import DAO.Impl.FormDAOImpl;

public class Factory {
     
      private static UserDAO userDAO = null;
      private static Users_typeDAO users_typeDAO = null;
      private static FormDAO formDAO = null;
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
      
      public FormDAO getFormDAO(){
    	  if(formDAO == null){
    		  formDAO = new FormDAOImpl();
    	  }
    	  return formDAO;
      }
}