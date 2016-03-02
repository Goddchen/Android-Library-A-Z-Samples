package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class UniversalImageLoaderFragment extends SampleFragment {

    public static UniversalImageLoaderFragment newInstance(Sample sample) {
        UniversalImageLoaderFragment fragment = new UniversalImageLoaderFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_uil;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageLoader.getInstance()
                .displayImage("http://www.pablopicasso.org/images/paintings/the-weeping-woman.jpg",
                        (ImageView) view.findViewById(R.id.image));
    }
}
