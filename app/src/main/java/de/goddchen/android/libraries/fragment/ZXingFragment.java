package de.goddchen.android.libraries.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class ZXingFragment extends SampleFragment {

    public static ZXingFragment newInstance(Sample sample) {
        ZXingFragment fragment = new ZXingFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_zxing;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
        intentIntegrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            String scannedCode = intentResult.getContents();
            if (getView() != null) {
                ((TextView) getView().findViewById(R.id.text))
                        .setText(scannedCode);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
