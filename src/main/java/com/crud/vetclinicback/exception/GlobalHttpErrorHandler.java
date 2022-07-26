package com.crud.vetclinicback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OwnerNotFoundException.class)
    public ResponseEntity<Object> handleOwnerNotFoundException(OwnerNotFoundException exception) {
        return new ResponseEntity<>("Owner with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<Object> handlePetNotFoundException(PetNotFoundException exception) {
        return new ResponseEntity<>("Pet with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PetTypeNotFoundException.class)
    public ResponseEntity<Object> handlePetTypeNotFoundException(PetTypeNotFoundException exception) {
        return new ResponseEntity<>("Pet type with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SpecialisationNotFoundException.class)
    public ResponseEntity<Object> handleSpecialisationNotFoundException(SpecialisationNotFoundException exception) {
        return new ResponseEntity<>("Specialisation with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VetNotFoundException.class)
    public ResponseEntity<Object> handleVetNotFoundException(VetNotFoundException exception) {
        return new ResponseEntity<>("Vet with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VisitNotFoundException.class)
    public ResponseEntity<Object> handleVisitNotFoundException(VisitNotFoundException exception) {
        return new ResponseEntity<>("Visit wth given id doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
