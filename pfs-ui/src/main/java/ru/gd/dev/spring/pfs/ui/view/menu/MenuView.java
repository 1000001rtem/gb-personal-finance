package ru.gd.dev.spring.pfs.ui.view.menu;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gd.dev.spring.pfs.ui.view.MainView;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@ParentLayout(MainView.class)
public class MenuView extends HorizontalLayout implements RouterLayout {

    @NotNull
    private PersonalInformationBox personalInformationBox;

    @NotNull
    private MenuLinksBox menuLinksBox;


    @Autowired
    public MenuView(@NotNull final PersonalInformationBox personalInformationBox,
                    @NotNull final MenuLinksBox menuLinksBox) {
        this.personalInformationBox = personalInformationBox;
        this.menuLinksBox = menuLinksBox;
        setSizeFull();
        getClassNames().add("rootView");
        final VerticalLayout menuView = new VerticalLayout(personalInformationBox, menuLinksBox);
        menuView.getClassNames().add("menuView");
        add(menuView);
    }
}
