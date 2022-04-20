package pl.krman.list.of.movies.api.GUI;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import pl.krman.list.of.movies.dao.entity.Movie;


public class MovieForm extends FormLayout {

    TextField title = new TextField("Title");
    TextField genre = new TextField("Genre");
    TextField director = new TextField("Director");
    TextField productionYear = new TextField("Production year");
    ComboBox<Movie> movie = new ComboBox<>("Movie");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

   public MovieForm() {
       addClassName("movie-form");

       add(
               title,
               genre,
               director,
               productionYear,
               createButtonsLayout()
       );
    }

    private Component createButtonsLayout() {
       save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
       delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
       close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

       save.addClickShortcut(Key.ENTER);
       close.addClickShortcut(Key.ESCAPE);

       return new HorizontalLayout(save,delete,close);
    }
}

