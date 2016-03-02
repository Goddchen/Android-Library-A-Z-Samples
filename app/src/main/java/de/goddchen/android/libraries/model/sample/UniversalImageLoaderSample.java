package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.UniversalImageLoaderFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class UniversalImageLoaderSample extends Sample {
    public UniversalImageLoaderSample() {
        super("UniversalImageLoader", "https://github.com/nostra13/Android-Universal-Image-Loader/", "UIL aims to provide a powerful, flexible and highly customizable instrument for image loading, caching and displaying.");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, UniversalImageLoaderFragment.newInstance(this),
                        "uil")
                .addToBackStack("uil")
                .commit();
    }
}
