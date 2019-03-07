package ru.gd.dev.spring.pfs.ui.view;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@StyleSheet("/styles/styles.css")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class MainView extends VerticalLayout implements RouterLayout {

    public MainView() {
        setId("mainView");
        setSizeFull();
    }

}
