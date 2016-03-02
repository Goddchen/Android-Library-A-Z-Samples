package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.VectorDrawableFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class VectorDrawableSample extends Sample {


    public VectorDrawableSample() {
        super("VectorDrawable Support Library", "http://developer.android.com/tools/support-library/", "Adds support for VectorDrawable assets to apps running on API level 7 or higher. AnimatedVectorDrawable assets are also supported on API level 11 or higher.");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, VectorDrawableFragment.newInstance(this), "vector")
                .addToBackStack("vector")
                .commit();
    }
}
