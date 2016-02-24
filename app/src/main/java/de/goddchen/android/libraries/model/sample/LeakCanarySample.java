package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.LeakCanaryFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by goddc on 22.01.2016.
 */
public class LeakCanarySample extends Sample {
    public LeakCanarySample() {
        super("LeakCanary", "https://github.com/square/leakcanary", "A memory leak detection library for Android and Java");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, LeakCanaryFragment.newInstance(), "leakcanary")
                .addToBackStack("leakcanary")
                .commit();
    }
}
