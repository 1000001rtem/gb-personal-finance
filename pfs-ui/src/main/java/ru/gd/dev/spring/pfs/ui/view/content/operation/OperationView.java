package ru.gd.dev.spring.pfs.ui.view.content.operation;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.client.OperationService;
import ru.gd.dev.spring.pfs.ui.dto.OperationDto;
import ru.gd.dev.spring.pfs.ui.view.content.operation.fragment.OperationBox;
import ru.gd.dev.spring.pfs.ui.view.menu.MenuView;

import java.util.List;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@Route(value = "operations", layout = MenuView.class)
public class OperationView extends VerticalLayout {

    @NotNull
    private MessageSource messageSource;

    @NotNull OperationService operationService;

    public OperationView(@NotNull final MessageSource messageSource, @NotNull final OperationService operationService) {
        this.operationService = operationService;
        this.messageSource = messageSource;
        getClassNames().add("contentView");
        getClassNames().add("operationView");
        final Label title =
                new Label(messageSource.getMessage("menu.links.operation", null, getLocale()));
        title.getClassNames().add("pageTitle");
        title.setId("operationLabel");
        add(title);
        final List<OperationDto> operations = getOperations();
        for (final OperationDto operation : operations) {
            add(new OperationBox(operation));
        }
    }

    private List<OperationDto> getOperations() {
        return operationService.getAll();
    }
}
