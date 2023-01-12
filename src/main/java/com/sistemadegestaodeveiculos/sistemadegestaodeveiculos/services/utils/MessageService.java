package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import io.swagger.models.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MessageService {
    
    private final MessageSource messageSource;

    public String getMessage(String key) {
        return this.messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public String getMessage(FieldError fieldError) {
        return messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
    }

    public String getMessage(Path path) {
        String message;
        try {
            message = messageSource.getMessage(path.toString(), null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            message = path.toString();
        }
        return message;
    }
}
