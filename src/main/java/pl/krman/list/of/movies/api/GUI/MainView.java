package pl.krman.list.of.movies.api.GUI;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.krman.list.of.movies.dao.entity.Movie;
import pl.krman.list.of.movies.manager.MovieManager;

@Route("test")
public class MainView extends VerticalLayout {

    Grid<Movie>grid = new Grid<>(Movie.class);
    private MovieManager movieManager;

    public MainView(MovieManager movieManager){
        this.movieManager = movieManager;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(grid);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("movie-grid");
        grid.setSizeFull();
        grid.setColumns("title","genre","director", "productionYear");
    }

    private void updateList() {
        grid.setItems(movieManager.findAll());
    }
}
