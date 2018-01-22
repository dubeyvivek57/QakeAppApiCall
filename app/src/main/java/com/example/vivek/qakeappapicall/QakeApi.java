package com.example.vivek.qakeappapicall;

import com.example.vivek.qakeappapicall.model.Feed;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vivek on 18-01-2018.
 */

public interface QakeApi {

    String BSAE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";

    @GET("query?format=geojson&starttime=2014-01-01&endtime=2014-01-02&minmagnitude=3")
    Call<Feed> getEarthqakeResult();

    @GET("query?format=geojson&starttime=2014-01-01&endtime=2014-01-02&minmagnitude=3")
    Observable<Feed> getEarthqakeResultObs();

//    @POST("{user}")
//    Call<ResponseBody> login(
//
//            @Path("query") String query,
//            @Query("format") String geojson,
//            @Query("starttime") String starttime,
//            @Query("endtime") String endtime,
//            @Query("minmagnitude") int mag
//    );
}
