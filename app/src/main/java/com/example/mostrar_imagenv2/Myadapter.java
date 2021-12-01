package com.example.mostrar_imagenv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private Context mContext;
    private List<Productos> listaProductos = new ArrayList<>();


    public Myadapter (Context context,List<Productos> products){
        this.mContext = context;
        this.listaProductos = products;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle, mPrice;
        private ImageView mImageView;
        private LinearLayout mContainer;
        private Button btncomprar;



        public MyViewHolder (View view){
            super(view);

            mTitle = view.findViewById(R.id.titulo_);
            mImageView = view.findViewById(R.id.imagen_);

            mPrice = view.findViewById(R.id.precio_);
            mContainer = view.findViewById(R.id.product_container);

            btncomprar = view.findViewById(R.id.btncomprar);




        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.lista_productos,parent,false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //  final Product variacionPrecio = order.getVariacionPrecios().get(0);
        final Productos productos = listaProductos.get(position);

        holder.mPrice.setText(" $ "+productos.getPrecio());
        holder.mTitle.setText(productos.getTitulo());
        Glide.with(mContext).
                load("https://practica.corporacionefransac.com/images/"+productos.getImagen())
                .into(holder.mImageView);

        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //int resultado=uno++;
                Intent intent = new Intent(mContext,VerDetalles.class);

                intent.putExtra("titulo",productos.getTitulo());
                intent.putExtra("precio",productos.getPrecio());
                intent.putExtra("imagen","https://practica.corporacionefransac.com/images/"+productos.getImagen());

                mContext.startActivity(intent);

            }
        });

        holder.btncomprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}

