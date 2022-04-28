package pl.krman.list.of.movies.api.GUI;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import pl.krman.list.of.movies.dao.entity.Movie;
import pl.krman.list.of.movies.manager.MovieManager;

@Route("start")
public class MainView extends VerticalLayout {

    MovieForm form;
    Grid<Movie>grid = new Grid<>(Movie.class);
    TextField filterText = new TextField();

    private MovieManager movieManager;

    public MainView(MovieManager movieManager){
        this.movieManager = movieManager;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureFilter();

        form = new MovieForm();

        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();

        add(filterText, content);
        updateList();
    }

    private void configureFilter() {
        filterText.setPlaceholder("Filer by column");
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
