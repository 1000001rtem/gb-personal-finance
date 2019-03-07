package ru.gd.dev.spring.pfs.ui.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.view.content.AccountsView;

/**
 * @autor Eremin Artem on 27.02.2019.
 */

@Route("")
@UIScope
@SpringComponent
@StyleSheet("/styles/styles.css")
public class TitleView extends VerticalLayout {

    @NotNull
    private MessageSource messageSource;

    public TitleView(@NotNull final MessageSource messageSource) {
        this.messageSource = messageSource;
        setSizeFull();
        addHeader();
        addContent();
        addFooter();
    }

    private void addHeader() {
        final Div header = new Div();
        header.getClassNames().add("header");
        final Div headerContainer = new Div();
        headerContainer.getClassNames().add("headerContainer");
        final Label title = new Label("Personal Finance");
        title.getClassNames().add("title");
        headerContainer.add(title);
        addLinks(headerContainer);
        header.add(headerContainer);
        add(header);
    }

    private void addLinks(@NotNull final Div parent) {
        final Div linksContainer = new Div();
        linksContainer.getClassNames().add("linksContainer");
        final String enterRoute = UI.getCurrent().getRouter().getUrl(AccountsView.class);
        final Anchor enterLink = new Anchor(enterRoute, messageSource.getMessage("enter", null, getLocale()));
        final String registrationRoute = UI.getCurrent().getRouter().getUrl(RegistrationView.class);
        final Anchor registrationLink =
                new Anchor(registrationRoute, messageSource.getMessage("registration", null, getLocale()));
        final Span separate = new Span("|");
        final Span separate2 = new Span("|");
        final String aboutRoute = UI.getCurrent().getRouter().getUrl(AboutView.class);
        final Anchor aboutLink = new Anchor(aboutRoute, messageSource.getMessage("about", null, getLocale()));
        linksContainer.add(enterLink, separate, registrationLink, separate2, aboutLink);
        parent.add(linksContainer);
    }

    private void addContent() {
        final Div content = new Div();
        content.getClassNames().add("content");
        final Div contentContainer = new Div();
        contentContainer.getClassNames().add("contentContainer");
        final Span descriptionTitle =
                new Span(messageSource.getMessage("title.description.title", null, getLocale()));
        descriptionTitle.getClassNames().add("descriptionTitle");
        final Paragraph description =
                new Paragraph(messageSource.getMessage("title.description", null, getLocale()));
        description.getClassNames().add("description");
        contentContainer.add(descriptionTitle, description);
        content.add(contentContainer);
        add(content);
    }

    private void addFooter() {
        final Div footer = new Div();
        footer.getClassNames().add("footer");
        final Div footerContainer = new Div();
        footerContainer.getClassNames().add("footerContainer");
        final Span copyright = new Span("&copy; 2019");
        copyright.getClassNames().add("copBox");
        footerContainer.add(copyright);
        footer.add(footerContainer);
        add(footer);
    }
}
