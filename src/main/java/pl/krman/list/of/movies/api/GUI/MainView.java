package pl.krman.list.of.movies.api.GUI;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import pl.krman.list.of.movies.dao.entity.Movie;
import pl.krman.list.of.movies.manager.MovieManager;

@Route("test")
public class MainView extends VerticalLayout {

    Grid<Movie>grid = new Grid<>(Movie.class);
    TextField filterText = new TextField();

    private MovieManager movieManager;

    public MainView(MovieManager movieManager){
        this.movieManager = movieManager;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureFilter();

        add(filterText, grid);
        updateList();
    }

    private void configureFilter() {
        filterText.setPlaceholder("Filer by genre...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
    }

    private void configureGrid() {
        grid.addClassName("movie-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("id");
        grid.setColumns("title","genre","director", "productionYear");
        grid.getColumns().forEach(col -> col.setAutoWidth(true) );
    }

    private void updateList() {
        grid.setItems(movieManager.findAll(filterText.getValue()));
    }
}
