package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.ZXingFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class ZXingSample extends Sample {


    public ZXingSample() {
        super("ZXing", "https://github.com/zxing/zxing", "ZXing (\"zebra crossing\") is an open-source, multi-format 1D/2D barcode image processing library implemented in Java, with ports to other languages.");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ZXingFragment.newInstance(this), "zxing")
                .addToBackStack("zxing")
                .commit();
    }
}
