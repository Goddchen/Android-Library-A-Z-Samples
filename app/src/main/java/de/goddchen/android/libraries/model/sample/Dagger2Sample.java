package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.Dagger2Fragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class Dagger2Sample extends Sample {
    public Dagger2Sample() {
        super("Dagger 2", "http://google.github.io/dagger/", "Dependency Injection");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, Dagger2Fragment.newInstance(this), "dagger2")
                .addToBackStack("dagger2")
                .commit();
    }
}
