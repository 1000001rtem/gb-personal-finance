package ru.gd.dev.spring.pfs.ui.view.content.operation;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

/**
 * @autor Eremin Artem on 12.03.2019.
 */

@Route(value = "operation")
public class OperationDetailView extends VerticalLayout implements HasUrlParameter<String> {
    @Override
    public void setParameter(final BeforeEvent beforeEvent, final String s) {

    }
}
