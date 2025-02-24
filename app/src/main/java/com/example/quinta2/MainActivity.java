package com.example.quinta2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtener las dimensiones de la pantalla
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int alturaPantalla = metrics.heightPixels; // Altura total en píxeles
        int withScreen = metrics.widthPixels; // Anchura total en píxeles

        // Calcular dimensiones de los contenedores con respecto a la pantalla
        int with90 = (int) (withScreen*0.9);            // 90% de anchura
        int with80 = (int) (withScreen * 0.8);          // 80% de anchura
        int altura80 = (int) (alturaPantalla * 0.8);    // 80% de altura
        int heigt70 = (int) (alturaPantalla * 0.7);     // 70% de altura
        int heigtBottom = (int) (alturaPantalla * 0.1);     // 30% de altura

        // Crear un contenedor principal (FrameLayout)
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        mainLayout.setGravity(Gravity.CENTER);

        // Crear un contenedor (LinearLayout) para la lista de elementos
        LinearLayout layoutList = new LinearLayout(this);
        layoutList.setOrientation(LinearLayout.VERTICAL);
        layoutList.setGravity(Gravity.CENTER);
        //layoutList.setBackgroundColor(Color.LTGRAY); // Color de fondo opcional

        // Establecer el tamaño del contenedor
        FrameLayout.LayoutParams listParams = new FrameLayout.LayoutParams(
                with90,
                heigt70
        );
        //listParams.gravity = Gravity.CENTER;
        layoutList.setLayoutParams(listParams);

        //crear un contenedor para el botón
        LinearLayout layoutButton = new LinearLayout(this);
        layoutButton.setOrientation(LinearLayout.VERTICAL);
        layoutButton.setGravity(Gravity.CENTER);
        //layoutButton.setBackgroundColor(Color.LTGRAY); // Color de fondo opcional

        // Establecer el tamaño del contenedor
        FrameLayout.LayoutParams buttonParams = new FrameLayout.LayoutParams(
                with90,
                heigtBottom
        );
        //buttonParams.gravity = Gravity.CENTER;
        layoutButton.setLayoutParams(buttonParams);

        // Crear un botón dentro del contenedor
        Button btnClick = new Button(this);
        btnClick.setBackgroundColor(Color.parseColor("#3ec2ff")); // Naranja
        btnClick.setText("Buscar");
        layoutButton.addView(btnClick);


        // Agregar el contenedor secundario al contenedor principal
        mainLayout.addView(layoutList);
        mainLayout.addView(layoutButton);


        // Agregar el contenedor a la pantalla
        setContentView(mainLayout);






        // Crear RecyclerView programáticamente
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.MATCH_PARENT
        ));

        // Establecer GridLayoutManager con 2 columnas
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        int[] imagenes = new int[43];
        String[] nombres = new String[43];
        int idImg;

        for (int i = 0; i < 43; i++) {
            idImg = getResources().getIdentifier("img_" + (i+1), "drawable", getPackageName());
            if(idImg != 0) {
                imagenes[i] = idImg;
                nombres[i] = "imagen";
            } else {
                //imagenes[i] = imagen;
            }
        }



        // Configurar el adaptador
        ImageAdapter adapter = new ImageAdapter(imagenes, nombres);
        recyclerView.setAdapter(adapter);

        layoutList.addView(recyclerView);



        // Crear el botón
       /* Button btnClick = new Button(this);
        btnClick.setText("Haz clic aquí");
        btnClick.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        layoutList.addView(btnClick);*/


        // Mostrar RecyclerView
        //setContentView(layoutList);
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