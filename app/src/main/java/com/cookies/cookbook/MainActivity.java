package com.cookies.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.TextView;

import com.cookies.cookbook.api.model.Category;
import com.cookies.cookbook.network.ApiClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.result);
        Call<List<Category>> result = ApiClient.getInstance()
                .getCategoryJsonApi()
                .getAll();
        result.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (!response.isSuccessful()) {
                    textView.setText(response.code());
                }

                List<Category> categories = response.body();

                for (Category category : categories) {
                    String content = "";
                    content += "ID: " + category.getId() + '\n';
                    content += "Name: " + category.getName() + "\n\n";
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}