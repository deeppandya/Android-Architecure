package mainpackage.arch.dependecyinjection;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mainpackage.arch.view.MainActivity;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
