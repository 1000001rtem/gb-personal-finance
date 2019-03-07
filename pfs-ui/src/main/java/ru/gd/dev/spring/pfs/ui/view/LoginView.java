package ru.gd.dev.spring.pfs.ui.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;

/**
 * @autor Eremin Artem on 03.03.2019.
 */

@Route("login")
@UIScope
@SpringComponent
@StyleSheet("/styles/loginstyle.css")
public class LoginView extends Div {

    @NotNull
    private MessageSource messageSource;

    public LoginView(@NotNull final MessageSource messageSource) {
        this.messageSource = messageSource;
        getClassNames().add("loginBox");
        final VerticalLayout form = new VerticalLayout();
        form.getClassNames().add("form");
        final Label title = new Label("Personal Finance");
        title.getClassNames().add("title");
        final TextField loginField = new TextField(messageSource.getMessage("login", null, getLocale()));
        loginField.getClassNames().add("loginField");
        final PasswordField passwordField
                = new PasswordField(messageSource.getMessage("password", null, getLocale()));
        passwordField.getClassNames().add("passwordField");
        final Button enter = new Button(messageSource.getMessage("enter", null, getLocale()));
        enter.getClassNames().add("enterButton");
        enter.addClickListener(e -> login(loginField.getValue(), passwordField.getValue()));
        form.add(title, loginField, passwordField, enter);
        add(form);
    }

    private void login(final String value, final String passwordFieldValue) {
    }
}

