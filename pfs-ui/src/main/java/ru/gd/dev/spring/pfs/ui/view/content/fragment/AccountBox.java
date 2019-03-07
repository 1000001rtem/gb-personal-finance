package ru.gd.dev.spring.pfs.ui.view.content.fragment;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.jetbrains.annotations.Nullable;
import ru.gd.dev.spring.pfs.ui.dto.AccountDto;
import ru.gd.dev.spring.pfs.ui.dto.AccountType;
import ru.gd.dev.spring.pfs.ui.view.content.AccountDetailView;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

public class AccountBox extends HorizontalLayout {

    public AccountBox(@Nullable final AccountDto accountDto) {
        if (accountDto == null) return;
        if (accountDto.getName().isEmpty()) return;
        if (accountDto.getAmount().isEmpty()) return;
        getClassNames().add("accountBox");
        final Image icon = new Image(AccountType.valueOf(accountDto.getType()).getIcon(), "account");
        final String route = UI.getCurrent().getRouter().getUrl(AccountDetailView.class, accountDto.getId());
        final Anchor name = new Anchor(route, accountDto.getName());
        final Div amountBox = new Div();
        amountBox.getClassNames().add("amountBox");
        final Label amount = new Label(accountDto.getAmount());
        final Label currency = new Label("руб");
        amountBox.add(amount, currency);
        add(icon, name, amountBox);
    }
}
