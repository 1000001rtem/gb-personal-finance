package ru.gd.dev.spring.pfs.ui.view.content.account;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.client.AccountService;
import ru.gd.dev.spring.pfs.ui.dto.AccountDto;
import ru.gd.dev.spring.pfs.ui.dto.AccountType;
import ru.gd.dev.spring.pfs.ui.view.menu.MenuView;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@Route(value = "account", layout = MenuView.class)
public class AccountDetailView extends VerticalLayout implements HasUrlParameter<String> {

    @NotNull
    @Autowired
    private AccountService service;

    @NotNull
    @Autowired
    private MessageSource messageSource;

    @Nullable
    private AccountDto accountDto;

    @NotNull
    private TextField accountName;

    @NotNull
    private TextField accountAmount;

    @NotNull
    private ComboBox<AccountType> accountType;

    @NotNull
    private Button saveButton;

    @NotNull
    private Button cancelButton;

    @NotNull
    private Button deleteButton;

    @Override
    public void setParameter(final BeforeEvent beforeEvent, final String parameter) {
        this.accountDto = service.findOne(parameter);
        this.service = service;
        this.messageSource = messageSource;
        if (accountDto == null) add(new Label(messageSource.getMessage("error", null, getLocale())));
        else createView();
    }

    private void createView() {
        addTitle();
        addNameField();
        addAmountField();
        addAccountType();
        addCommentArea();
        addSaveButton();
        addCancelButton();
        addDeleteButton();
    }

    private void addTitle() {
        final Label title = new Label(messageSource.getMessage("account", null, getLocale()));
        title.getClassNames().add("pageTitle");
        add(title);
    }

    private void addNameField() {
        accountName = new TextField(messageSource.getMessage("addaccount.name", null, getLocale()));
        accountName.getClassNames().add("textField");
        accountName.getClassNames().add("accountName");
        accountName.setValue(accountDto.getName());
        accountName.addValueChangeListener(e -> {
            saveButton.setEnabled(true);
            cancelButton.setEnabled(true);
        });
        add(accountName);
    }

    private void addAmountField() {
        accountAmount = new TextField(messageSource.getMessage("amount", null, getLocale()));
        accountAmount.getClassNames().add("textField");
        accountAmount.getClassNames().add("accountAmount");
        accountAmount.setValue(accountDto.getAmount());
        accountAmount.setEnabled(false);
        add(accountAmount);
    }

    private void addAccountType() {
        accountType = new ComboBox<>(
                messageSource.getMessage("addaccount.choosetype",
                        null,
                        getLocale()));
        final Collection<AccountType> items = Arrays.stream(AccountType.values()).collect(Collectors.toList());
        accountType.setItems(items);
        accountType.setPlaceholder(accountDto.getType());
        accountType.addValueChangeListener(e -> {
            accountDto.setType(e.getValue().name());
            saveButton.setEnabled(true);
            cancelButton.setEnabled(true);
        });
        accountType.getClassNames().add("accountTypeComboBox");
        add(accountType);
    }

    private void addCommentArea() {
        final TextArea commentArea = new TextArea(messageSource.getMessage("comment", null, getLocale()));
        commentArea.getClassNames().add("textArea");
        commentArea.getClassNames().add("commentArea");
        add(commentArea);
    }

    private void addSaveButton() {
        saveButton = new Button(messageSource.getMessage("save", null, getLocale()));
        saveButton.setEnabled(false);
        saveButton.addClickListener(e -> {
            saveAccountDto();
            saveButton.getUI().ifPresent(ui -> ui.navigate("accounts"));
        });
        add(saveButton);
    }

    private void addCancelButton() {
        cancelButton = new Button(messageSource.getMessage("cancel", null, getLocale()));
        cancelButton.setEnabled(false);
        cancelButton.addClickListener(e -> saveButton.getUI().ifPresent(ui -> ui.navigate("accounts")));
        add(cancelButton);
    }

    private void addDeleteButton() {
        deleteButton = new Button(messageSource.getMessage("delete", null, getLocale()));
        deleteButton.addClickListener(e -> {
            service.delete(accountDto.getId());
            deleteButton.getUI().ifPresent(ui -> ui.navigate("accounts"));
        });
        add(deleteButton);
    }

    private void saveAccountDto() {
        accountDto.setName(accountName.getValue());
        service.update(accountDto, accountDto.getId());
    }

}
