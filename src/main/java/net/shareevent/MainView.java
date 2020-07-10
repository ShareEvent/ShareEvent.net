package net.shareevent;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import net.shareevent.gestionevent.FormEvent;

/**
 * The main view contains a button and a click listener.
 */
@Route("form")
@PWA(name = "ShareEvent.net", shortName = "ShareEvent", enableInstallPrompt = true)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    public MainView() {
        add(new FormEvent());
    }
}
