package ru.gd.dev.spring.pfs.ui.view.content.operation;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.client.CategoryService;
import ru.gd.dev.spring.pfs.ui.client.OperationService;
import ru.gd.dev.spring.pfs.ui.dto.AccountType;
import ru.gd.dev.spring.pfs.ui.dto.CategoryDto;
import ru.gd.dev.spring.pfs.ui.dto.OperationDto;
import ru.gd.dev.spring.pfs.ui.dto.OperationType;
import ru.gd.dev.spring.pfs.ui.view.content.account.AccountsView;
import ru.gd.dev.spring.pfs.ui.view.menu.MenuView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @autor Eremin Artem on 12.03.2019.
 */

@Route(value = "createOperation", layout = MenuView.class)
public class CreateOperationView extends VerticalLayout implements HasUrlParameter<String> {

    @NotNull
    @Autowired
    private OperationService operationService;

    @NotNull
    @Autowired
    private CategoryService categoryService;

    @NotNull
    @Autowired
    private MessageSource messageSource;

    @NotNull
    private OperationDto operationDto;

    @NotNull
    private TextField description;

    @NotNull
    private TextField amount;

    @NotNull
    private TextField comment;

    @NotNull
    private ComboBox<OperationType> type;

    @NotNull
    private ComboBox<CategoryDto> category;

    @NotNull
    private Button submitButton;

    @Override
    public void setParameter(final BeforeEvent beforeEvent, final String accountId) {
        operationDto = new OperationDto();
        operationDto.setAccountId(accountId);
        createView();
    }

    private void createView() {
        addDescriptionField();
        addAmountField();
        addCommentField();
        addTypeComboBox();
        addCategoryComboBox();
        addSubmitButton();
    }

    private void addDescriptionField() {
        description = new TextField(messageSource.getMessage("description", null, getLocale()));
        description.getClassNames().add("textField");
        description.getClassNames().add("operationDescriptionField");
        add(description);
    }

    private void addAmountField() {
        amount = new TextField(messageSource.getMessage("amount", null, getLocale()));
        amount.getClassNames().add("textField");
        amount.getClassNames().add("operationAmountField");
        add(amount);
    }

    private void addCommentField() {
        comment = new TextField(messageSource.getMessage("comment", null, getLocale()));
        comment.getClassNames().add("textField");
        comment.getClassNames().add("operationCommentField");
        add(comment);
    }

    private void addTypeComboBox() {
        type = new ComboBox<>(
                messageSource.getMessage("addaccount.choosetype",
                        null,
                        getLocale()));
        final Collection<OperationType> items = Arrays.stream(OperationType.values()).collect(Collectors.toList());
        type.setItems(items);
        type.addValueChangeListener(e -> operationDto.setType(e.getValue().name()));
        type.getClassNames().add("operationTypeComboBox");
        add(type);
    }

    private void addCategoryComboBox() {
        category = new ComboBox<>(
                messageSource.getMessage("addaccount.choosetype",
                        null,
                        getLocale()));
        final Collection<CategoryDto> items = categoryService.getAll();
        category.setItems(items);
        category.addValueChangeListener(e -> operationDto.setCategoryId(e.getValue().getId()));
        category.getClassNames().add("operationCategoryComboBox");
        add(category);
    }

    private void addSubmitButton() {
        submitButton = new Button(messageSource.getMessage("save", null, getLocale()));
        submitButton.getClassNames().add("button");
        submitButton.addClickListener(e -> {
            createOperationDto();
            operationService.post(operationDto);
            submitButton.getUI().ifPresent(ui -> ui.navigate(AccountsView.class));
        });
        add(submitButton);
    }

    private void createOperationDto() {
        operationDto.setActive(true);
        operationDto.setOperationDate(new Date());
        operationDto.setDescription(description.getValue());
        operationDto.setAmount(amount.getValue());
        operationDto.setComment(comment.getValue());
    }
}
