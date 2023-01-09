package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ErrorEntity;

public class DALException extends Exception{
    private Exception innerException;
    private String errorMessage;
    private ErrorEntity errorEntity;

    public DALException(Exception innerException, String errorMessage){
        this.innerException = innerException;
        this.errorMessage = errorMessage;
    }

    public ErrorEntity getErrorEntity(){
        return this.errorEntity;
    }
}
