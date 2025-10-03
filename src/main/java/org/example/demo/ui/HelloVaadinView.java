package org.example.demo.ui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.example.demo.data.Person;
import org.example.demo.data.PersonRepository;

@Route("")
public class HelloVaadinView extends HorizontalLayout {

    public HelloVaadinView(PersonRepository repository) {
        // configure Grid
        var grid = new Grid<>(Person.class);
        grid.setColumns("id", "name", "age", "email");
        grid.setItems(repository.findAll());

        setPadding(true);

        add(grid);
    }
}
