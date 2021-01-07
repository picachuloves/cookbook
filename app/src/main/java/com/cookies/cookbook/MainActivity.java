package com.cookies.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cookies.cookbook.api.model.BaseRecipe;
import com.cookies.cookbook.api.model.Category;
import com.cookies.cookbook.api.model.Recipe;
import com.cookies.cookbook.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView = findViewById(R.id.result);
        listView = findViewById(R.id.lvRecipes);
        Call<List<BaseRecipe>> res = ApiClient.getInstance()
                .getRecipeJsonApi()
                .getAll();
        ArrayList<String> resi = new ArrayList<>();
        res.enqueue(new Callback<List<BaseRecipe>>() {
            @Override
            public void onResponse(Call<List<BaseRecipe>> call, Response<List<BaseRecipe>> response) {
                if (!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            Integer.toString(response.code()),
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

                List<BaseRecipe> recipes = response.body();

                for (BaseRecipe recipe : recipes) {
                    resi.add(recipe.getId() + ":" + recipe.getName());
                }
            }

            @Override
            public void onFailure(Call<List<BaseRecipe>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        t.getMessage(),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resi);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("r_id", ((TextView)view).getText().toString());
                startActivity(intent);
            }
        });
    }
}