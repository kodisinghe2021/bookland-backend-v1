package org.nksofttech.userprofileservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class WriteAbortedException extends RuntimeException{
  public WriteAbortedException(String message){super(message);}
}
