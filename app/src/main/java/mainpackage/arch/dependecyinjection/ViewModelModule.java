package mainpackage.arch.dependecyinjection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import mainpackage.arch.viewmodel.ViewModelFactory;
import mainpackage.arch.viewmodel.UnsplashPhotosViewModel;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UnsplashPhotosViewModel.class)
    abstract ViewModel bindUnsplashPhotosViewModel(UnsplashPhotosViewModel unsplashPhotosViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
