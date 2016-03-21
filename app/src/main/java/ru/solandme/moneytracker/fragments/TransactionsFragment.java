package ru.solandme.moneytracker.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.solandme.moneytracker.R;
import ru.solandme.moneytracker.Transaction;
import ru.solandme.moneytracker.adapters.TransactionAdapter;

public class TransactionsFragment extends Fragment {
    List<Transaction> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_transactions, container, false);

        TransactionAdapter transactionAdapter = new TransactionAdapter(getActivity(), 0, getDataList());
        ListView listView = (ListView) inflate.findViewById(R.id.list_view);
        if (listView != null) {
            listView.setAdapter(transactionAdapter);
        }
        return inflate;
    }

    private List<Transaction> getDataList() {

        data.add(new Transaction("Food", 1000, new Date(115, 10, 23)));
        data.add(new Transaction("T-Shirts", 2000, new Date(115, 11, 1)));
        data.add(new Transaction("Jeans", 3300, new Date(115, 4, 13)));

        return data;
    }
}

