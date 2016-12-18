package com.market.handler;

import com.market.domain.MessageType;
import com.market.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class ControllerValidationHandler {

    @Autowired
    private MessageSource msgSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<MessageDTO> processValidationError(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        return processErrors(errors);
    }

    private List<MessageDTO> processErrors(List<FieldError> errors) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        List<MessageDTO> messages = new ArrayList<>();

        if (errors != null && !errors.isEmpty()) {
            errors.stream().forEach(error -> {
                String msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
                messages.add(new MessageDTO(msg, MessageType.ERROR));
            });
        }

        return messages;
    }
}
