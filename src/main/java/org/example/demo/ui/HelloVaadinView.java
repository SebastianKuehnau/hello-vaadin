package org.example.demo.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.example.demo.data.Person;
import org.example.demo.data.PersonRepository;

@Route("")
public class HelloVaadinView extends HorizontalLayout {

    private final TextField name = new TextField("Name");
    private final IntegerField age = new IntegerField("Age");
    private final EmailField email = new EmailField("Email");

    public HelloVaadinView(PersonRepository repository) {
        // configure Grid
        var grid = new Grid<>(Person.class);
        grid.setColumns("id", "name", "age", "email");
        grid.setItems(repository.findAll());

        // configure Buttons
        var saveButton = new Button("Save");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        var cancelButton = new Button("Cancel");

        // form layout
        VerticalLayout formLayout = new VerticalLayout(name, age, email,
                new HorizontalLayout(saveButton, cancelButton));
        formLayout.setSizeUndefined();

        setPadding(true);

        add(grid, formLayout);
    }
}
