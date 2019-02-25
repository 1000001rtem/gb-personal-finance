package ru.gd.dev.spring.pfs.ui.view.content;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.model.dto.AccountDto;
import ru.gd.dev.spring.pfs.ui.view.content.fragment.AccountBox;
import ru.gd.dev.spring.pfs.ui.view.content.fragment.CircleChartBox;
import ru.gd.dev.spring.pfs.ui.view.menu.MenuView;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@UIScope
@SpringComponent
@Route(value = "accounts", layout = MenuView.class)
public class AccountsView extends VerticalLayout {

    @NotNull
    private MessageSource messageSource;

    @Autowired
    public AccountsView(@NotNull final MessageSource messageSource) {
        final CircleChartBox circleChartBox = new CircleChartBox();
        final List<AccountDto> accounts = getAccounts();
        getClassNames().add("contentView");
        getClassNames().add("accountView");
        this.messageSource = messageSource;
        final Label label =
                new Label(messageSource.getMessage("menu.links.account", null, getLocale()));
        label.setId("accountLabel");
        add(label);
        add(circleChartBox);
        for (final AccountDto account : accounts) {
            add(new AccountBox(account));
        }
    }

    private List<AccountDto> getAccounts() {
        return new ArrayList<>();
    }
}