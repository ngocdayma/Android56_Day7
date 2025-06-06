package com.example.android56_day7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android56_day7.R;
import com.example.android56_day7.interfaces.ProductClickListener;
import com.example.android56_day7.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> mlistProduct;
    private Context mContext;

    private ProductClickListener mProductClickListener;

    public ProductAdapter(ArrayList<Product> mListProduct) {
        this.mlistProduct = mListProduct;
    }

    public void setProductClickListener(ProductClickListener productClickListener) {
        mProductClickListener = productClickListener;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = mlistProduct.get(position);
        String name = product.getTitle();
        String description = product.getDescription();
        String price = product.getPrice().toString();
        String img = product.getThumbnail();

        holder.txtName.setText(name);
        holder.txtDescription.setText(description);
        holder.txtPrice.setText(price);
        Glide.with(mContext).load(img)
                .into(holder.imgProduct);

    }

    @Override
    public int getItemCount() {
        return mlistProduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgProduct;
        TextView txtName;
        TextView txtDescription;
        TextView txtPrice;
        View item;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtName = itemView.findViewById(R.id.txtName);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            itemView.findViewById(R.id.item);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.item) {
                mProductClickListener.onItemClickListener(getAdapterPosition(), mlistProduct.get(getAdapterPosition()));
            }
        }
    }

    public void updateData(List<Product> newList) {
        this.mlistProduct = new ArrayList<>(newList);
        notifyDataSetChanged();
    }
}