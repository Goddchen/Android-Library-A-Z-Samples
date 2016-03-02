package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.WireFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by goddc on 19.01.2016.
 */
public class WireSample extends Sample {
    public WireSample() {
        super("Wire", "https://github.com/square/wire", "Clean, lightweight protocol buffers for Android and Java.");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, WireFragment.newInstance(this), "wire")
                .addToBackStack("wire")
                .commit();
    }
}
