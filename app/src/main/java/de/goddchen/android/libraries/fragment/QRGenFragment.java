package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class QRGenFragment extends SampleFragment {

    public static QRGenFragment newInstance(Sample sample) {
        QRGenFragment fragment = new QRGenFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_qrgen;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*QRCode.from("Android Library A-Z").file("filename.jpg");
        QRCode.from("Android Library A-Z").to(ImageType.PNG);
        QRCode.from("Android Library A-Z").withColor(Color.BLACK, Color.RED);
        QRCode.from("Android Library A-Z").withSize(100, 100);*/
        ((ImageView) view.findViewById(R.id.image))
                .setImageBitmap(QRCode.from("Android Library A-Z").bitmap());
    }
}
