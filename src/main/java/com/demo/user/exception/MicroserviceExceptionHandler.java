package com.demo.user.exception;
import javax.servlet.http.HttpServletRequest;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
/**
* <h1>Service Exception Handler</h1>
* The class implements a generic exception handling tecnique across the whole application.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/
@ControllerAdvice
@ResponseBody
public class MicroserviceExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex){
        ErrorResponse error = new ErrorResponse(400, "Invalid input, expected numeric value.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex){
        ErrorResponse error = new ErrorResponse(400, ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRecordNotFound(RecordNotFoundException ex){
        ErrorResponse error = new ErrorResponse(404, ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e){
          ErrorResponse error = new ErrorResponse(100, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRunTimeException(RuntimeException e, HttpServletRequest request){
        ErrorResponse error = new ErrorResponse(101, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

}