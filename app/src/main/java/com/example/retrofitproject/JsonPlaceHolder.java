package com.example.retrofitproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId")Integer [] userId,@Query("_sort")String sort,@Query("_order")String order);
    @GET("posts/{id}/comments")
    Call<List<CommentClass>> getComment(@Path("id") int postId);
    @POST("posts")
    Call<Post> onCreate (@Body Post post);
    @PUT("posts/{id}")
    Call<Post> postCreate(@Path("id")int id, @Body Post post);
    @PATCH("posts/{id}")
    Call<Post> patchCreate(@Path("id") int id,@Body Post post);

}
