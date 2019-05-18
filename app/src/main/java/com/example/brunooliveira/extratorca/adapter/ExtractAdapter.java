package com.example.brunooliveira.extratorca.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.brunooliveira.extratorca.R;
import com.example.brunooliveira.extratorca.models.Installments;

import java.util.ArrayList;

public class ExtractAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<Installments> installmentsArrayList;
    private LayoutInflater inflater;
    private OnExtractClickListener clickListener;
    private Button btnData;


    public ExtractAdapter(Context context, ArrayList<Installments> installments){
        this.context = context;
        this.installmentsArrayList = installments;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View extractView = inflater.inflate(R.layout.recycler_view, parent, false);
        ExtractListViewHolder viewHolder = new ExtractListViewHolder(extractView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final Installments item = installmentsArrayList.get(position);
        ExtractListViewHolder holder = (ExtractListViewHolder) viewHolder;
        holder.past_due.setText(item.getPast_due());
        holder.carnet.setText(item.getCarnet());
        holder.installment.setText(item.getInstallment());
        holder.value.setText(item.getValue());

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Vencimento em: " + item.getPast_due(), Toast.LENGTH_SHORT).show();

            }
        });*/


    }

    @Override
    public int getItemViewType(int position){
        Installments item = installmentsArrayList.get(position);
        if(item instanceof Installments) {
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return installmentsArrayList.size();
    }


    public void setOnItemClickListener(OnExtractClickListener listener){
        this.clickListener = listener;
    }

    //INTERFACE PARA CLICK
    public interface OnExtractClickListener {

        void onExtractClick(View view, int position);
    }


    //VIEWHOLDER
    public class ExtractListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView past_due;
        TextView carnet;
        TextView installment;
        TextView value;
        ConstraintLayout clItem;


        public ExtractListViewHolder(@NonNull View itemView) {
            super(itemView);

            clItem = itemView.findViewById(R.id.clItem);
            clItem.setOnClickListener(this);
            past_due = itemView.findViewById(R.id.main_line_text_date);
            carnet = itemView.findViewById(R.id.main_line_text_code);
            installment = itemView.findViewById(R.id.main_line_text_num);
            value = itemView.findViewById(R.id.main_line_text_value);


        }


        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onExtractClick(v, getAdapterPosition());
            }
        }
    }

}
