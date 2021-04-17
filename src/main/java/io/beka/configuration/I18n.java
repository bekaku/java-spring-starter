package io.beka.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
public class I18n {

    /** Optionally pass to getMessage */
    public static final Object[] NO_ARGS = new String[] {};

    @Autowired
    private MessageSource messageSource;
    private MessageSourceAccessor accessor;

    @Value("${spring.mvc.locale}")
    String defaultLocale;

    @PostConstruct
    private void init() {
//        accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
//        accessor = new MessageSourceAccessor(messageSource);
        accessor = new MessageSourceAccessor(messageSource, new Locale(defaultLocale));
    }

    public String getMessage(String code, Object... args) {
        return accessor.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    public String getMessage(String code) {
        return getMessage(code, NO_ARGS);
    }
}
