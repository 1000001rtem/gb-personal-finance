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

@Route(value = "statistic", layout = MenuView.class)
public class StatisticView extends VerticalLayout {

    @NotNull
    private MessageSource messageSource;

    public StatisticView(@NotNull final MessageSource messageSource) {
        getClassNames().add("contentView");
        getClassNames().add("statisticView");
        this.messageSource = messageSource;
        final Label title =
                new Label(messageSource.getMessage("menu.links.statistic", null, getLocale()));
        title.setId("statisticLabel");
        title.getClassNames().add("pageTitle");
        add(title);
    }
}
