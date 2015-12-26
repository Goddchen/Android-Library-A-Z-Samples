package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.MoshiFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class MoshiSample extends Sample {
    public MoshiSample() {
        super("Moshi", "https://github.com/square/moshi", "Modern JSON library for Android and Java");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MoshiFragment.newInstance(this), "moshi")
                .addToBackStack("moshi")
                .commit();
    }
}
