package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.ButterknifeFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public class ButterknifeSample extends Sample {
    public ButterknifeSample() {
        super("Butterknife", "https://github.com/JakeWharton/butterknife", "View \"injection\" library");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ButterknifeFragment.newInstance(this), "butterknife")
                .addToBackStack("butterknife")
                .commit();
    }
}
