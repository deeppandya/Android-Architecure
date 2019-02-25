package mainpackage.arch.networkcalls;

import io.reactivex.Observable;
import mainpackage.arch.model.MovieResultModel;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by deeppandya
 * On 2019-02-23.
 */
public interface MovieDbService {

    @GET("3/movie/now_playing?")
    Observable<MovieResultModel> getUpcomingMovies(@Query("api_key") String apiKey, @Query("page") String page, @Query("region") String region, @Query("language") String language);
}
