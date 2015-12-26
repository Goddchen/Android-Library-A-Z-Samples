package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.PicassoFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class PicassoSample extends Sample {
    public PicassoSample() {
        super("Picasso", "http://square.github.io/picasso/", "A powerful image downloading and caching library for Android");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, PicassoFragment.newInstance(this), "picasso")
                .addToBackStack("picasso")
                .commit();
    }
}
