package com.scaler.productservice.controlleradvice;

import com.scaler.productservice.dto.ExceptionDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException() {

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Runtime exception");
        exceptionDto.setSolution("Try again");

        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic exception");
        exceptionDto.setSolution("Try again");

        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException() {

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Array index out of bounds exception");
        exceptionDto.setSolution("Try again");

        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ExceptionDto> handleNullPointerException() {
//
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage("Null pointer exception");
//        exceptionDto.setSolution("Try again");
//
//        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("No product found");
        exceptionDto.setSolution("Try again with different input");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

}
