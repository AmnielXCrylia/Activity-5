package com.example.quinta2;

import android.os.Bundle;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crear RecyclerView programáticamente
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.MATCH_PARENT
        ));

        // Establecer GridLayoutManager con 2 columnas
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        //int[] imagenes = new int[43];
        String[] nombres = new String[43];

        int imagenes = getResources().getIdentifier("img_" + 1, "drawable", getPackageName());
        /*for (int i = 0; i <= 43; i++) {
            imagenes[i] = getResources().getIdentifier("img_" + i, "drawable", getPackageName());
            System.out.println(imagenes[i]);
            nombres[i] = "nombres";
        }*/

        // Datos de ejemplo
        int[] images = {imagenes, imagenes,imagenes,imagenes,imagenes,imagenes,imagenes,imagenes,};
        String[] names = {"Cámara", "Galería", "Configuración", "Ayuda", "Configuración", "Ayuda", "Configuración", "Ayuda"};

        // Configurar el adaptador
        ImageAdapter adapter = new ImageAdapter(images, names);
        recyclerView.setAdapter(adapter);

        // Mostrar RecyclerView
        setContentView(recyclerView);
    }
}



/*
*
* ScrollView scrollView = new ScrollView(this);

        scrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));


        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setPadding(20, 20, 20, 20);

        layout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        layout.setBackgroundColor(Color.LTGRAY);


        for (int i = 1; i <= 43; i++) {

            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);

            itemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            itemLayout.setPadding(10, 10, 10, 10);

            // Obtener imagenes de la carpeta "drawable/"
            int imageResId = getResources().getIdentifier("img_" + i, "drawable", getPackageName());

            // Crear ImageView para mostrar la imagen
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 200));

            // Asignar ID
            if (imageResId != 0) {

                imageView.setImageResource(imageResId);

            } else {

                imageView.setImageResource(android.R.drawable.ic_delete);

            }


            CheckBox checkBox = new CheckBox(this);
            checkBox.setText("Imagen " + i);


            itemLayout.addView(imageView);
            itemLayout.addView(checkBox);


            layout.addView(itemLayout);

        }


        scrollView.addView(layout);


        setContentView(scrollView);
*
*
*
*
*
*
*
*
* */