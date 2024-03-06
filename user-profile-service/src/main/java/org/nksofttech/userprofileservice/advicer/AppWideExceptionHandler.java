package org.nksofttech.userprofileservice.advicer;

import org.nksofttech.userprofileservice.exception.NotFoundException;
import org.nksofttech.userprofileservice.exception.WriteAbortedException;
import org.nksofttech.userprofileservice.util.StandardResponse;
import org.nksofttech.userprofileservice.util.enums.ResMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
    return new ResponseEntity<StandardResponse>(new StandardResponse(404, ResMessage.DATA_NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(WriteAbortedException.class)
  public ResponseEntity<StandardResponse> alreadyAvailableException(WriteAbortedException e) {
    return new ResponseEntity<StandardResponse>(new StandardResponse(405, ResMessage.DATA_ALREADY_IN_USE, e.getMessage()), HttpStatus.ALREADY_REPORTED);
  }
}
