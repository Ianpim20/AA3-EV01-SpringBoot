package com.rpgo.aa3ev01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Manejo global de errores para devolver respuestas claras
 * (ideal para pruebas y evidencias con pantallazos).
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errores = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage())
        );

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("status", 400);
        respuesta.put("error", "Bad Request");
        respuesta.put("validaciones", errores);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }
}