package com.example.quinta2;

import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private final int[] images;
    private final String[] names;

    public ImageAdapter(int[] images, String[] names) {
        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Crear un LinearLayout para contener la imagen y el texto
        LinearLayout layout = new LinearLayout(parent.getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(20, 20, 20, 20);
        layout.setBackgroundColor(Color.LTGRAY);

        // Crear un ImageView
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Crear un TextView
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        //Crear un CheckBox
        CheckBox checkBox = new CheckBox(parent.getContext());
        checkBox.setText("Imagen " +2);

        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);

        // Agregar las vistas al layout
        layout.addView(imageView);
        layout.addView(textView);
        layout.addView(checkBox);

        return new ViewHolder(layout, imageView, textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull LinearLayout itemView, ImageView imageView, TextView textView) {
            super(itemView);
            this.imageView = imageView;
            this.textView = textView;
        }
    }
}