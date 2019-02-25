package mainpackage.arch.dependecyinjection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import mainpackage.arch.viewmodel.MovieDbViewModel;
import mainpackage.arch.viewmodel.ViewModelFactory;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieDbViewModel.class)
    abstract ViewModel bindMovieDbViewModel(MovieDbViewModel movieDbViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
