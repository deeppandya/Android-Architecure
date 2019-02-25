package mainpackage.arch.datarepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mainpackage.arch.BuildConfig;
import mainpackage.arch.database.MoviesDbDao;
import mainpackage.arch.model.MovieResultModel;
import mainpackage.arch.networkcalls.MovieDbService;
import mainpackage.arch.utils.Connection;


/**
 * Created by deeppandya
 * On 2019-02-23.
 */

@Singleton
public class MovieDbRepository {

    private MovieDbService movieDbService;
    private MoviesDbDao moviesDbDao;
    private Connection connection;

    @Inject
    MovieDbRepository(MovieDbService movieDbService, MoviesDbDao moviesDbDao, Connection connection) {
        this.movieDbService = movieDbService;
        this.moviesDbDao = moviesDbDao;
        this.connection = connection;
    }

    public Observable<MovieResultModel> getUpcomingMovies(String page) {

        boolean hasConnection = connection.isConnectedToInternet();
        Observable<MovieResultModel> observableFromApi = null;

        if (hasConnection)
            observableFromApi = getMoviesFromApi(page);
        Observable<MovieResultModel> observableFromLocal = getMoviesFromLocals(page);

        if (hasConnection)
            return Observable.concatArrayEager(observableFromApi, observableFromLocal);
        else return observableFromLocal;
    }

    private Observable<MovieResultModel> getMoviesFromApi(String page) {
        return movieDbService.getUpcomingMovies(BuildConfig.MOVIE_DB_API_KEY, page, "us", "en-US").doOnNext(movieResultModel -> moviesDbDao.insert(movieResultModel));
    }

    private Observable<MovieResultModel> getMoviesFromLocals(String page) {
        return moviesDbDao.getAllMovieResults(Integer.parseInt(page)).toObservable().doOnNext(movieResultModel -> {

        });
    }
}
