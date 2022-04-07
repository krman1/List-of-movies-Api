package pl.krman.list.of.movies.api.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class EditorLayout extends VerticalLayout {

    private TextField title;
    private TextField genre;
    private TextField director;
    private TextField productionYear;

    private Button deleteButton = new Button("Delete...");
    private Button cancelButton = new Button("Cancel");
    private Button saveButton = new Button("Save");

    public EditorLayout() {
        FormLayout formLayout = new FormLayout();

        title = new TextField("Title");
        genre = new TextField("Genre");
        director = new TextField("Director");
        productionYear = new TextField("ProductionYear");

        formLayout.add(title, genre, director, productionYear);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        deleteButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_ERROR);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.setWidthFull();
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        buttonLayout.setSpacing(false);
        buttonLayout.add(deleteButton, new HorizontalLayout(cancelButton, saveButton));

        add(formLayout, buttonLayout);
        setWidth("600px");
        setMinWidth("300px");
        setFlexGrow(0);
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }
}
