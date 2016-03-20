package ru.solandme.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.solandme.moneytracker.adapters.TransactionAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TransactionAdapter transactionAdapter;

    List<Transaction> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        transactionAdapter = new TransactionAdapter(getApplicationContext(), 0, getDataList());

        listView.setAdapter(transactionAdapter);


    }

    private List<Transaction> getDataList(){

        data.add(new Transaction("Food", 1000, new Date(115, 10, 23)));
        data.add(new Transaction("T-Shirts", 2000, new Date(115, 11, 1)));
        data.add(new Transaction("Jeans", 3300, new Date(115, 4, 13)));

        return data;
    }
}
