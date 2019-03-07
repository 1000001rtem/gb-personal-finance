package ru.gd.dev.spring.pfs.ui.view.menu;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@SpringComponent
@UIScope
public class PersonalInformationBox extends VerticalLayout {

    public PersonalInformationBox() {
        getClassNames().add("personalInformationBox");
        addAvatar();
        final Span span = new Span("NickName");
        add(span);
    }

    private void addAvatar() {
        final Image image = new Image("/pictures/default-avatar.png", "avatar");
        image.getClassNames().add("avatarLogo");
        add(image);
    }
}
