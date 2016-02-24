package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.TimberFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by goddc on 20.01.2016.
 */
public class TimberSample extends Sample {
    public TimberSample() {
        super("Timber", "https://github.com/JakeWharton/timber", "A logger with a small, extensible API which provides utility on top of Android's normal Log class.");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, TimberFragment.newInstance(), "timber")
                .addToBackStack("timber")
                .commit();
    }
}
