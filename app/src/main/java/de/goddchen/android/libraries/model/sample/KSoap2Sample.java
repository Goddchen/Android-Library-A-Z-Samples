package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.KSoap2Fragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class KSoap2Sample extends Sample {
    public KSoap2Sample() {
        super("ksoap2-android", "http://simpligility.github.io/ksoap2-android/", "The ksoap2-android project provides a lightweight and efficient SOAP client library for the Android platform.");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, KSoap2Fragment.newInstance(), "ksoap2")
                .addToBackStack("ksoap2")
                .commit();
    }
}
