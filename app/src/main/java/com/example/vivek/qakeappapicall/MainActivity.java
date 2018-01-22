package com.example.vivek.qakeappapicall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.vivek.qakeappapicall.model.Feature;
import com.example.vivek.qakeappapicall.model.Feed;
import com.example.vivek.qakeappapicall.feature.Properties;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(QakeApi.BSAE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        QakeApi api = retrofit.create(QakeApi.class);

        final Call<Feed> feature = api.getEarthqakeResult();

        //  final Call<List<Properties>> listCall = api.getEarthqakeResult();

        /*feature.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {

                List<Feature> features = response.body().getFeatures();
                //List<Properties> earthquakeList = response.body();

                for (int i = 0; i < features.size(); i++){
                    Log.d("Earthqake Locations : ", features.get(i).getProperties().getPlace());
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e("Problem with", t.getMessage());

            }
        });*/

        api.getEarthqakeResultObs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Feed>() {
            @Override
            public void accept(Feed feed) throws Exception {
                List<Feature> features = feed.getFeatures();
                //List<Properties> earthquakeList = response.body();

                for (int i = 0; i < features.size(); i++) {
                    Log.d("Earthqake Locations : ", features.get(i).getProperties().getPlace());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("Problem with", throwable.getMessage());
            }
        });
    }
}
