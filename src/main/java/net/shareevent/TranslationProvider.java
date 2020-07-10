package net.shareevent;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.vaadin.flow.i18n.I18NProvider;

import org.slf4j.LoggerFactory;

public class TranslationProvider implements I18NProvider {

    /**
     *
     */
    private static final long serialVersionUID = 8021923738787495449L;

    public static final String BUNDLE_PREFIX = "translate";

    public final Locale LOCALE_EN = new Locale("en", "GB");
    public final Locale LOCALE_FR = new Locale("fr", "FR");

    private List<Locale> locales = Collections
            .unmodifiableList(Arrays.asList(LOCALE_EN, LOCALE_FR));

    @Override
    public List<Locale> getProvidedLocales() {
        return locales;
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        if (key == null) {
            LoggerFactory.getLogger(TranslationProvider.class.getName())
                    .warn("Got lang request for key with null value!");
            return "";
        }

        final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_PREFIX, locale);

        String value;
        try {
            value = bundle.getString(key);
        } catch (final MissingResourceException e) {
            LoggerFactory.getLogger(TranslationProvider.class.getName())
                    .warn("Missing resource", e);
            return "!" + locale.getLanguage() + ": " + key;
        }
        if (params.length > 0) {
            value = MessageFormat.format(value, params);
        }
        return value;
    }
}