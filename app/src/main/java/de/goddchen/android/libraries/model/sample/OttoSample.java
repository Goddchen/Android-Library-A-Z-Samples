package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.OttoFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class OttoSample extends Sample {
    public OttoSample() {
        super("Otto", "http://square.github.io/otto/", "An enhanced event bus with emphasis on Android support");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, OttoFragment.newInstance(this), "otto")
                .addToBackStack("otto")
                .commit();
    }
}
