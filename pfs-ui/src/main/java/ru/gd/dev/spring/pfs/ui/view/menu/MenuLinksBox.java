package ru.gd.dev.spring.pfs.ui.view.menu;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.view.content.account.AccountsView;
import ru.gd.dev.spring.pfs.ui.view.content.operation.OperationView;
import ru.gd.dev.spring.pfs.ui.view.content.statistic.StatisticView;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@UIScope
@SpringComponent
public class MenuLinksBox extends VerticalLayout {

    @NotNull
    private MessageSource messageSource;

    @Autowired
    public MenuLinksBox(@NotNull final MessageSource messageSource) {
        this.messageSource = messageSource;
        getClassNames().add("menuLinksBox");
        add(createLinks());
    }

    private RouterLink[] createLinks() {
        final RouterLink accountLink = new RouterLink(
                messageSource.getMessage(
                        "menu.links.account",
                        null,
                        getLocale()),
                AccountsView.class);
        accountLink.setId("accountLink");
        final RouterLink operationLink = new RouterLink(
                messageSource.getMessage(
                        "menu.links.operation",
                        null,
                        getLocale()),
                OperationView.class);
        operationLink.setId("operationLink");
        final RouterLink statisticLink = new RouterLink(
                messageSource.getMessage(
                        "menu.links.statistic",
                        null,
                        getLocale()),
                StatisticView.class);
        statisticLink.setId("statisticLink");
        return new RouterLink[]{accountLink, operationLink, statisticLink};
    }
}
