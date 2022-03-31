package pl.krman.list.of.movies.api.GUI;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.krman.list.of.movies.dao.MovieRepo;
import pl.krman.list.of.movies.dao.entity.Movie;

@Route("play")
public class CrudView extends SplitLayout {

    private Grid<Movie> grid;
    private final EditorLayout editorLayout;
    private Movie movie;

    ListDataProvider<Movie> dataProvider;

    private final MovieRepo repo;

    private BeanValidationBinder<Movie> binder;

    public CrudView(@Autowired MovieRepo repo) {
        this.repo = repo;

        configureGrid();

        editorLayout = new EditorLayout();
        configureBinding();

        setSizeFull();

        addToPrimary(grid);
        addToSecondary(editorLayout);
    }

    private void configureGrid() {
        grid = new Grid<>(Movie.class, true);
        grid.setSizeFull();

       dataProvider = DataProvider.ofCollection(repo.findAll());

        grid.asSingleSelect().addValueChangeListener(event -> {
            Movie movie = event.getValue();
            if (movie != null) {
                populateForm(movie);
            } else {
                clearForm();
            }
        });
    }

    private void configureBinding() {
        binder = new BeanValidationBinder<>(Movie.class);

        binder.bindInstanceFields(editorLayout);

        editorLayout.getDeleteButton().addClickListener(e -> {
            if (this.movie != null) {
                repo.delete(this.movie);
                dataProvider.getItems().remove(movie);

                clearForm();
                refreshGrid();
                Notification.show("Movie deleted.");
            }
        });

        editorLayout.getCancelButton().addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        editorLayout.getSaveButton().addClickListener(e -> {
            try {
                if (this.movie == null) {
                    this.movie = new Movie();
                }
                binder.writeBean(this.movie);

                repo.save(this.movie);
                dataProvider.getItems().add(movie);

                clearForm();
                refreshGrid();
                Notification.show("Person details stored.");
            } catch (ValidationException validationException) {
                Notification.show("Please enter a valid movie details.");
            }
        });
    }

    void clearForm() {
        populateForm(null);
    }

    void populateForm(Movie movie) {
        this.movie = movie;
        binder.readBean(this.movie);
    }

    public void refreshGrid() {
        grid.select(null);
        dataProvider.refreshAll();
    }
}

