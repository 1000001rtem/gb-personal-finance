package ru.gd.dev.spring.pfs.ui.view.content.operation.fragment;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.jetbrains.annotations.Nullable;
import ru.gd.dev.spring.pfs.ui.dto.OperationDto;
import ru.gd.dev.spring.pfs.ui.dto.OperationType;
import ru.gd.dev.spring.pfs.ui.view.content.operation.OperationDetailView;

/**
 * @autor Eremin Artem on 10.03.2019.
 */

public class OperationBox extends HorizontalLayout {

    public OperationBox(@Nullable final OperationDto operationDto) {
        if (operationDto == null) return;
        if (operationDto.getDescription().isEmpty()) return;
        if (operationDto.getAmount().isEmpty()) return;
        getClassNames().add("operationBox");
        final Image icon = new Image(OperationType.valueOf(operationDto.getType()).getIcon(), "logo");
        final String route = UI.getCurrent().getRouter().getUrl(OperationDetailView.class, operationDto.getId());
        final Anchor name = new Anchor(route, operationDto.getDescription());
        final Div amountBox = new Div();
        amountBox.getClassNames().add("amountBox");
        final Label amount = new Label(operationDto.getAmount());
        final Label currency = new Label("руб");
        amountBox.add(amount, currency);
        add(icon, name, amountBox);
    }
}
