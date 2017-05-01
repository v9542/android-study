package com.somo.test.server.serverinterface;

import com.somo.test.server.ArticleListClassResponse;
import com.somo.test.server.BasicResponse;
import com.somo.test.server.ClearTimeRequest;
import com.somo.test.server.RequirementRequest;
import com.somo.test.server.model.Person;
import com.somo.test.server.model.PersonResponse;

import retrofit.Call;

/**
 * Created by Omjoon on 2015. 12. 7..
 */
public class ServerQuery {
//    public static void login(RegisterPush request, retrofit.Callback callback){
//        Call<PushResponse> call = ServiceGenerator.createService(ServerAPI.class).login(request);
//        call.enqueue(callback);
//    }


    public static void postRequirement(RequirementRequest request, retrofit.Callback callback) {
        Call<BasicResponse> call = ServiceGenerator.createService(ServerAPI.class, false).postRequiremnet(request);
        call.enqueue(callback);
    }

//    public static void postHelp(HelpRequest request, retrofit.Callback callback) {
//        Call<BasicResponse> call = ServiceGenerator.createService(ServerAPI.class).postHelp(request);
//        call.enqueue(callback);
//    }
//
    public static void putClearTime(int phone_id, ClearTimeRequest request, retrofit.Callback callback) {
        Call<BasicResponse> call = ServiceGenerator.createService(ServerAPI.class, false).putClearTime(phone_id, request);
        call.enqueue(callback);
    }
//
//    public static void postLocation(int phone_id, LocationPost data, retrofit.Callback callback) {
//        Call<BasicResponse> call = ServiceGenerator.createService(ServerAPI.class).postLocation(phone_id, data);
//        call.enqueue(callback);
//    }
//
//    public static void getServiceArticle(int listNum, int num, retrofit.Callback callback) {
//        Call<ArticleResponse> call = ServiceGenerator.createService(ServerAPI.class).getServiceArticle(listNum, num);
//        call.enqueue(callback);
//    }
//
    public static void getServiceArticleClass(retrofit.Callback callback) {
        Call<ArticleListClassResponse> call = ServiceGenerator.createService(ServerAPI.class, false).getServiceArticleListClass();
        call.enqueue(callback);
    }
//
//    public static void getAttractionArticle(int listNum, int num, retrofit.Callback callback) {
//        Call<ArticleResponse> call = ServiceGenerator.createService(ServerAPI.class).getAttractionArticle(listNum, num);
//        call.enqueue(callback);
//    }
//
//    public static void getAttractionArticleClass(retrofit.Callback callback) {
//        Call<ArticleListClassResponse> call = ServiceGenerator.createService(ServerAPI.class).getAttractionArticleListClass();
//        call.enqueue(callback);
//    }
//
//    public static void getHotelInfo(retrofit.Callback callback) {
//        Call<HotelInfoResponse> call = ServiceGenerator.createService(ServerAPI.class).getHotelInfo();
//        call.enqueue(callback);
//    }
//
//    public static void getHelpFAQ(retrofit.Callback callback) {
//        Call<HelpFAQResponse> call = ServiceGenerator.createService(ServerAPI.class).getHelpFAQ();
//        call.enqueue(callback);
//    }
//
//    public static void getSignage(retrofit.Callback callback) {
//        Call<SignageResponse> call = ServiceGenerator.createService(ServerAPI.class).getSignage("android");
//        call.enqueue(callback);
//    }
//    public static void getMovie(String movie_name, retrofit.Callback callback) {
//        Call<ResponseBody> call = ServiceGenerator.createService(ServerAPI.class).getMovie(movie_name);
//        call.enqueue(callback);
//    }

    public static void postPerson(Person p, retrofit.Callback callback) {
        Call<PersonResponse> call = ServiceGenerator.createService(ServerAPI.class, false).postPerson(p);
        call.enqueue(callback);
    }
}
