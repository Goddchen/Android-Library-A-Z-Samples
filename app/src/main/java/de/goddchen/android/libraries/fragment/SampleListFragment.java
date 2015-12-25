package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Model;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public class SampleListFragment extends Fragment {

    public static SampleListFragment newInstance() {
        return new SampleListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(android.R.id.list);
        recyclerView.setAdapter(new SampleAdapter(new SampleAdapter.OnClickListener() {
            @Override
            public void onClick(Sample sample) {
                sample.launchFragment(getActivity());
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    public static class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {

        private OnClickListener mOnClickListener;

        private List<Sample> mSamples;

        public SampleAdapter(OnClickListener onClickListener) {
            this.mOnClickListener = onClickListener;
            mSamples = Model.getSamples();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_2, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final Sample sample = mSamples.get(position);
            holder.mNameTextView.setText(sample.getName());
            holder.mShortDescriptionTextView.setText(sample.getShortDescription());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnClickListener.onClick(sample);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mSamples == null ? 0 : mSamples.size();
        }

        public interface OnClickListener {
            void onClick(Sample sample);
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mNameTextView;

            public TextView mShortDescriptionTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                mNameTextView = (TextView) itemView.findViewById(android.R.id.text1);
                mShortDescriptionTextView = (TextView) itemView.findViewById(android.R.id.text2);
            }
        }
    }
}
