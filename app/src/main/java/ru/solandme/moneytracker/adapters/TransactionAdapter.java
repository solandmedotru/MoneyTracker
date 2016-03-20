package ru.solandme.moneytracker.adapters;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.List;

import ru.solandme.moneytracker.R;
import ru.solandme.moneytracker.Transaction;

public class TransactionAdapter extends ArrayAdapter<Transaction>{
    public TransactionAdapter(Context context, int resource, List<Transaction> transactions) {
        super(context, resource, transactions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Transaction transactions = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView sum = (TextView) convertView.findViewById(R.id.sum);
        TextView data = (TextView) convertView.findViewById(R.id.data);

        title.setText(transactions.getTitle());
        sum.setText(Integer.toString(transactions.getSum()));


        String dateInStringFormat = DateFormat.getDateInstance().format(transactions.getDate());
        data.setText(dateInStringFormat);

        if(position % 2 == 0){
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.listBg));
        }else {
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.listBgLight));
        }



        return convertView;
    }
}
