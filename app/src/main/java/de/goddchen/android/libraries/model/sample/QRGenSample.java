package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.QRGenFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class QRGenSample extends Sample {
    public QRGenSample() {
        super("QRGen", "https://github.com/kenglxn/QRGen", "A simple QRCode generation api for java built on top ZXING");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, QRGenFragment.newInstance(this), "qrgen")
                .addToBackStack("qrgen")
                .commit();
    }
}
