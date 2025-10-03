package org.example.demo.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HelloVaadinView extends HorizontalLayout {

    public HelloVaadinView() {
        add(new H1("Hello World"));
    }
}
