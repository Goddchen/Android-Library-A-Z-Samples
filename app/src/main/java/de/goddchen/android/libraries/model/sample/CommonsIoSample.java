package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.CommonsIoFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class CommonsIoSample extends Sample {

    public CommonsIoSample() {
        super("Commons IO", "https://commons.apache.org/io/", "Library of utilities to assist with developing IO functionality");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, CommonsIoFragment.newInstance(this), "commons-io")
                .addToBackStack("commons-io")
                .commit();
    }
}
