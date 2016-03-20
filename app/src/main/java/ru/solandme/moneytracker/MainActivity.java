package ru.solandme.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.solandme.moneytracker.adapters.TransactionAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TransactionAdapter transactionAdapter;

    List<Transactions> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        transactionAdapter = new TransactionAdapter(getApplicationContext(), 0, getDataList());

        listView.setAdapter(transactionAdapter);


    }

    private List<Transactions> getDataList(){
        data.add(new Transactions("Food", "1000"));
        data.add(new Transactions("T-Shirts", "2000"));
        data.add(new Transactions("Jeans", "3300"));

        return data;
    }
}
