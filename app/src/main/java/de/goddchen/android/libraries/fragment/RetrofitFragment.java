package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Goddchen on 07.01.2016.
 */
public class RetrofitFragment extends SampleFragment {

    public static RetrofitFragment newInstance(Sample sample) {
        RetrofitFragment fragment = new RetrofitFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_retrofit;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.result);
        view.findViewById(R.id.progress).setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);

        GithubAPI githubAPI = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build()
                .create(GithubAPI.class);
        githubAPI.getUserRepos("Goddchen")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Response<ResponseBody> response) {
                        try {
                            JSONArray jsonResponse = new JSONArray(response.body().string());
                            TextView textView = (TextView) view.findViewById(R.id.result);
                            textView.setText("Goddchen's Github Repositories:");
                            for (int i = 0; i < jsonResponse.length(); i++) {
                                textView.append("\n");
                                textView.append(jsonResponse.getJSONObject(i).getString("name"));
                            }
                            textView.setVisibility(View.VISIBLE);
                            view.findViewById(R.id.progress).setVisibility(View.GONE);
                        } catch (Exception e) {
                            Log.e("Retrofit Sample", "Error getting user repos", e);
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("Retrofit Sample", "Error getting user repos", t);
                    }
                });
    }


    interface GithubAPI {
        // Normally you would create a POJO for the response and let Retrofit parse it with Gson or something
        // But we want to only show one library at a time, so we just use the String response
        @GET("users/{user}/repos")
        Call<ResponseBody> getUserRepos(@Path("user") String user);
    }
}
