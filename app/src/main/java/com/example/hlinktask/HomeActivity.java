package com.example.hlinktask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hlinktask.ApiRequest;
import com.example.hlinktask.Article;
import com.example.hlinktask.MainActivity;
import com.example.hlinktask.MovieArticleAdapter;
import com.example.hlinktask.R;
import com.example.hlinktask.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView=findViewById(R.id.rcv_list);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
     //   recyclerView.setLayoutManager(new StaggeredGridLayoutManager(this));



        getImage();
    }

    public void getImage(){

        ApiRequest service = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
        Call<Article> call = service.getMovieArticles();
        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
//                progressDoalog.dismiss();
//                generateDataList(response.body());
                assert response.body() != null;
                List<Article.Image> heroList = response.body().getImage();

              //  StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
           //     stagg.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
              //  recyclerView.setLayoutManager(layoutManager);
              //  recyclerView.setHasFixedSize(true);

                MovieArticleAdapter adapter=new MovieArticleAdapter(HomeActivity.this,heroList);
                recyclerView.setAdapter(adapter);


                Log.e("List_Data",String.valueOf(heroList.size()));
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
//                progressDoalog.dismiss();
                Toast.makeText(HomeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
//        ApiRequest api = retrofit.create(ApiRequest.class);
//
//
//        Call<Article> call = api.getMovieArticles();
//
//        call.enqueue(new Callback<Article>() {
//            @Override
//            public void onResponse(Call<Article> call, Response<Article> response) {



    //Creating an String array for the ListView
    //String[] heroes = new String[heroList.size()];

    //looping through all the heroes and inserting the names inside the string array
//                for (int i = 0; i < heroList.size(); i++) {
//                    heroes[i] = heroList.get(i).getName();
//                }


    //displaying the string array into listview
//                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));

//            }

//            @Override
//            public void onFailure(Call<Article> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

}
