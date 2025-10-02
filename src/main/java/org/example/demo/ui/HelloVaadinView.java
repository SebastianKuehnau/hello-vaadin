package org.example.demo.ui;

import com.vaadin.collaborationengine.CollaborationAvatarGroup;
import com.vaadin.collaborationengine.CollaborationBinder;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.example.demo.data.Person;
import org.example.demo.data.PersonRepository;


@Route("")
public class HelloVaadinView extends HorizontalLayout {

    private final TextField name = new TextField("Name");
    private final IntegerField age = new IntegerField("Age");
    private final EmailField email = new EmailField("Email");

    public HelloVaadinView(PersonRepository repository) {

        // Collaboration Setup
        var userId = System.identityHashCode(UI.getCurrent()) + "";
        var localUser = new UserInfo(userId, "User " + userId);

        var binder = new CollaborationBinder<>(Person.class, localUser);
        binder.bindInstanceFields(this);

        var avatarGroup = new CollaborationAvatarGroup(localUser, null);
        avatarGroup.setVisible(false);

        // configure Grid
        var grid = new Grid<>(Person.class);
        grid.setColumns("id", "name", "age", "email");
        grid.setItems(repository.findAll());
        grid.asSingleSelect().addValueChangeListener(e -> {
            Person selected = e.getValue();
            avatarGroup.setVisible(selected != null);

            if (selected == null) return;

            String topic = "person-" + selected.getId();
            binder.setTopic(topic, () -> selected);
            avatarGroup.setTopic(topic);
        });

        // configure Buttons
        var saveButton = new Button("Save");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.addClickListener(e -> {
            var selected = grid.asSingleSelect().getValue();

            if (binder.writeBeanIfValid(selected)) {
                repository.save(selected);
                grid.getDataProvider().refreshItem(selected);
            }
        });

        var cancelButton = new Button("Cancel");
        cancelButton.addClickListener(e -> binder.readRecord(grid.asSingleSelect().getValue()));

        // form layout
        VerticalLayout formLayout = new VerticalLayout(avatarGroup, name, age, email,
                new HorizontalLayout(saveButton, cancelButton));
        formLayout.setSizeUndefined();

        add(grid, formLayout);
        setPadding(true);
        setSizeFull();
    }
}
