package management.pokemon.card.controllers.api.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import management.pokemon.card.code.ErrorCode;
import management.pokemon.card.domain.models.error.ErrorResponse;
import management.pokemon.card.exception.request.HeaderException;

@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(HeaderException.class)
  public ResponseEntity<Object> HeaderExceptionHander(HeaderException e, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();
    return super.handleExceptionInternal(e,
        new ErrorResponse(ErrorCode.BAD_REQUEST.getCode()),
        headers,
        HttpStatus.BAD_REQUEST,
        request);
  }
}
