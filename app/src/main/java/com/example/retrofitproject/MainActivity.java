package com.example.retrofitproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private JsonPlaceHolder jsonPlaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_show_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
         sendPost();
        // getPosts();
        //  getComments();
       // updatePost();
     //   updatePatch();

    }

    private void updatePatch() {
        Post post = new Post(5,null,"sam");
        Call<Post> postCall = jsonPlaceHolder.patchCreate(7,post);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code:"+response.code());
                }
                Post post1 = response.body();
                String content = "";
                content += "code:" + response.code() + "\n";
                content += "USER ID :" + post1.getUserId() + "\n";
                content += "Text Body" + post1.getText() + "\n";
                content += "Title" + post1.getTitle() + "\n\n";
                textView.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });
    }

    private void updatePost() {
        Post post = new Post(5, " \t nothing", "\t sami");
        Call<Post> postCall = jsonPlaceHolder.postCreate(10, post);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textView.setText("COde:" + response.code());
                }
                Post post1 = response.body();
                String content = "";
                content += "code:" + response.code() + "\n";
                content += "USER ID :" + post1.getUserId() + "\n";
                content += "Text Body" + post1.getText() + "\n";
                content += "Title" + post1.getTitle() + "\n\n";
                textView.append(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });
    }

    private void sendPost() {
        Post post = new Post(25, "sam", "salam");
        Call<Post> postCall = jsonPlaceHolder.onCreate(post);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textView.setText("code:" + response.code());
                    return;
                }
                Post post1 = response.body();
                String content = "";
                content += "code:" + response.code() + "\n";
                content += "USER ID :" + post1.getUserId() + "\n";
                content += "Text Body" + post1.getText() + "\n";
                content += "Title" + post1.getTitle() + "\n\n";
                textView.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });


    }

    private void getComments() {
        Call<List<CommentClass>> comment = jsonPlaceHolder.getComment(3);
        comment.enqueue(new Callback<List<CommentClass>>() {
            @Override
            public void onResponse(Call<List<CommentClass>> call, Response<List<CommentClass>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code" + response.code());
                }
                List<CommentClass> commentClassList = response.body();
                for (CommentClass commentClass : commentClassList) {
                    String contentComment = "";
                    contentComment += "Post Id :" + commentClass.getPostId() + "\n";
                    contentComment += "Id :" + commentClass.getId() + "\n";
                    contentComment += "Name :" + commentClass.getName() + "\n";
                    contentComment += "Email :" + commentClass.getEmail() + "\n";
                    contentComment += "Body :" + commentClass.getText() + "\n\n";
                    textView.append(contentComment);
                }
            }

            @Override
            public void onFailure(Call<List<CommentClass>> call, Throwable t) {
                textView.setText("message:" + t.getMessage());

            }
        });
    }

    private void getPosts() {

        Call<List<Post>> post = jsonPlaceHolder.getPosts(new Integer[]{2, 3, 4}, "id", "desc");
        post.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code :" + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post1 : posts) {
                    String content = "";
                    content += " ID:" + post1.getId() + "\n";
                    content += "USER ID :" + post1.getUserId() + "\n";
                    content += "Text Body" + post1.getText() + "\n";
                    content += "Title" + post1.getTitle() + "\n\n";
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textView.setText("message :" + t.getMessage());

            }
        });

    }
}
