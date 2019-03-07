package ru.gd.dev.spring.pfs.ui.view.content;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.view.menu.MenuView;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@Route(value = "operations", layout = MenuView.class)
public class OperationView extends VerticalLayout {

    @NotNull
    private MessageSource messageSource;

    public OperationView(@NotNull final MessageSource messageSource) {
        getClassNames().add("contentView");
        getClassNames().add("operationView");
        this.messageSource = messageSource;
        final Label title =
                new Label(messageSource.getMessage("menu.links.operation", null, getLocale()));
        title.getClassNames().add("pageTitle");
        title.setId("operationLabel");
        add(title);
    }
}
