package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class PicassoFragment extends SampleFragment {

    public static PicassoFragment newInstance(Sample sample) {
        PicassoFragment fragment = new PicassoFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_picasso;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Picasso.with(getContext())
                .load("http://www.pablopicasso.org/images/paintings/the-weeping-woman.jpg")
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_close_clear_cancel)
                .into((ImageView) view.findViewById(R.id.image));
    }
}
