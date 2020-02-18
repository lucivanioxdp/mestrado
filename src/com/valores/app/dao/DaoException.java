package com.valores.app.dao;

public class DaoException extends Exception{
    
    public DaoException(){
        
    }
    
    public DaoException(String message){
        super(message);        
    }
    
    public DaoException(String message, Throwable cause){
        super(message, cause);
    }
    
    protected DaoException (String message, Throwable cause, 
                    boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public DaoException(Throwable cause){
        super(cause);
    }
}
