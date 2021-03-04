package com.demo.imageapidemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.demo.imageapidemo.DataAdapter.ProfileDataAdapter;
import com.demo.imageapidemo.Model.ProfileResponse;
import com.demo.imageapidemo.R;
import com.demo.imageapidemo.rest.ApiClient;
import com.demo.imageapidemo.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<ProfileResponse> profileDataList = new ArrayList<ProfileResponse>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<List<ProfileResponse>> call = apiInterface.getProfileDetails();
        call.enqueue(new Callback<List<ProfileResponse>>() {
            @Override
            public void onResponse(Call<List<ProfileResponse>> call, Response<List<ProfileResponse>> response) {
                if (response.isSuccessful()){
                    ProfileDataAdapter adapter = new ProfileDataAdapter(MainActivity.this,response.body());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {

            }
        });
    }
}
