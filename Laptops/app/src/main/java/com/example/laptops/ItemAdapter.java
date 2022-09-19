package com.example.laptops;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {
    ArrayList<Laptops> myList =new ArrayList<>();
    Context context;

    public ItemAdapter(ArrayList<Laptops> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        ViewHolder vh =new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ((ViewHolder)holder).img.setImageResource(myList.get(position).getImg());
        ((ViewHolder)holder).name.setText(myList.get(position).getName());
        ((ViewHolder)holder).price.setText(myList.get(position).getPrice()+"KD");
        ((ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,DetailsActivity.class);
                intent.putExtra("laptop",myList.get(position));
                context.startActivity(intent);
            }
        });
        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert =new AlertDialog.Builder(context)
                        .setTitle("Attention")
                        .setMessage("Are you sure you want to delete")
                        .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                myList.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img, delete;
        TextView name, price;
        View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v= itemView;
            img=v.findViewById(R.id.imageViewItem);
            name=v.findViewById(R.id.textViewName1);
            price=v.findViewById(R.id.textViewPrice1);
            delete =v.findViewById(R.id.imageViewDelete);

        }
    }

}
