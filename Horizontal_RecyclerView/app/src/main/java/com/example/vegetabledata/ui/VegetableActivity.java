package com.example.vegetabledata.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vegetabledata.util.OnClickListener;
import com.example.vegetabledata.R;
import com.example.vegetabledata.RecyclerViewClickListener;
import com.example.vegetabledata.adapter.CustomRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class VegetableActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> mVegetables = new ArrayList<>();

    private RecyclerView recyclerView;

    CustomRecyclerviewAdapter recyclerviewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);
        initWidgets();
        initVegetables();
        initRecyclerView();
        recyclerviewListener();
    }

    private void recyclerviewListener() {
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(VegetableActivity.this,
                recyclerView, new OnClickListener() {
            @Override
            public void onClick(View view, final int position) {
                HashMap<String, String> item = recyclerviewAdapter.getList()
                        .get(position);
                Toast.makeText(VegetableActivity.this, item.get("name") + "\n" + item.get("price")+ "\n" + item.get("desc"), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(VegetableActivity.this,
                        "Long press on position :" + position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }

    private void initWidgets() {
        recyclerView = findViewById(R.id.recycler_view);

    }

    private void initVegetables() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Stawberry");
        map.put("price", "790.00");
        map.put("desc", "The garden strawberry is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness");
        map.put("image", R.drawable.b1 + "");
        mVegetables.add(map);

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name", "Kiwi");
        map1.put("price", "170.00");
        map1.put("desc", "Kiwifruit or Chinese gooseberry is the edible berry of several species of woody vines in the genus Actinidia. The most common cultivar group of kiwifruit is oval, about the size of a large hen's egg: 5–8 centimetres in length and 4.5–5.5 cm in diameter.\n");
        map1.put("image", R.drawable.b2 + "");
        mVegetables.add(map1);

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("name", "Papaya");
        map2.put("price", "230.00");
        map2.put("desc", "The papaya, papaw, or pawpaw is the plant Carica papaya, one of the 22 accepted species in the genus Carica of the family Caricaceae. Its origin is in the tropics of the Americas, perhaps from Central America and southern Mexico.\n");
        map2.put("image", R.drawable.b3 + "");
        mVegetables.add(map2);

        HashMap<String, String> map3 = new HashMap<>();
        map3.put("name", "Water Melon");
        map3.put("price", "430.00");
        map3.put("desc", "Watermelon is a plant species in the family Cucurbitaceae, a vine-like flowering plant originally domesticated in Africa. It is a highly cultivated fruit worldwide, having more than 1,000 varieties. Watermelon is a scrambling and trailing vine in the flowering plant family Cucurbitaceae.\n");
        map3.put("image", R.drawable.b4 + "");
        mVegetables.add(map3);

        HashMap<String, String> map4 = new HashMap<>();
        map4.put("name", "Fruits");
        map4.put("price", "740.00");
        map4.put("desc", "Fruits are the means by which angiosperms disseminate seeds. Edible fruits, in particular, have propagated with the movements of humans and animals in a symbiotic relationship as a means for seed dispersal and nutrition; in fact, humans and many animals have become dependent on fruits as a source of food");
        map4.put("image", R.drawable.b5 + "");
        mVegetables.add(map4);


    }

    private void initRecyclerView() {
        recyclerviewAdapter =
                new CustomRecyclerviewAdapter(this, mVegetables);
        LinearLayoutManager staggeredGridLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(recyclerviewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bottom_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
