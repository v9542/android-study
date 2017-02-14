package com.somo.test.server;


import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Omjoon on 2015. 12. 7..
 */
public interface ServerAPI {
//
//    @POST("/api/v2/phones")
//    Call<PushResponse> login(@Body RegisterPush registerAccount);

//    @POST("/api/v2/help")
//    Call<BasicResponse> postHelp(@Body HelpRequest request);

    @POST("/api/v2/guest/requirements")
    Call<BasicResponse> postRequiremnet(@Body RequirementRequest data);

    @PUT("api/v2/phones/{phone_id}")
    Call<BasicResponse> putClearTime(@Path("phone_id") int phone_id, @Body ClearTimeRequest request);
//
//    @POST("api/v2/phones/{phone_id}/location")
//    Call<BasicResponse> postLocation(@Path("phone_id") int phone_id, @Body LocationPost data);
//
//    @GET("api/v2/services/{service_class_id}/{service_id}")
//    Call<ArticleResponse> getServiceArticle(@Path("service_class_id") int list_num, @Path("service_id") int num);
//
//
    @GET("api/v2/services")
    Call<ArticleListClassResponse> getServiceArticleListClass();
//
//    @GET("api/v2/attractions/{attraction_class_id}/{attraction_id}")
//    Call<ArticleResponse> getAttractionArticle(@Path("attraction_class_id") int list_num, @Path("attraction_id") int num);
//
//
//    @GET("api/v2/attractions")
//    Call<ArticleListClassResponse> getAttractionArticleListClass();
//
//    @GET("api/v2/guest/hotel")
//    Call<HotelInfoResponse> getHotelInfo();
//
//    @GET("api/v2/guest/faqs")
//    Call<HelpFAQResponse> getHelpFAQ();
//
//    @GET("api/v2/signages")
//    Call<SignageResponse> getSignage(@Query("level") String level);
//
//    @GET("api/v2/guest/movie/{movie_name}")
//    Call<ResponseBody> getMovie(@Path("movie_name") String movie_name);
}
