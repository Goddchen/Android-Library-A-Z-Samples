package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.ACRAFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public class ACRASample extends Sample {

    public ACRASample() {
        super("ACRA", "https://github.com/ACRA/acra", "Application Crash Reports");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ACRAFragment.newInstance(this), "acra")
                .addToBackStack("acra")
                .commit();
    }
}
