package com.example.animacioncrossfade;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvLorem;
    ProgressBar pbLoading;
    private int duracionAnimacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLorem = findViewById(R.id.tvContenido);
        pbLoading = findViewById(R.id.progressBar);
        duracionAnimacion = getResources().getInteger(android.R.integer.config_longAnimTime);

        tvLorem.setVisibility(View.GONE);

        pbLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossFadeAnimation();
            }
        });
    }

    private void crossFadeAnimation() {
        //Se muestra progresivamente el texto
        tvLorem.setAlpha(0f);
        tvLorem.setVisibility(View.VISIBLE);

        tvLorem.animate()
                .alpha(1f)
                .setDuration(duracionAnimacion);

        //Ocultar progresivamente la barra de carga.
        pbLoading.animate()
                .alpha(0f)
                .setDuration(duracionAnimacion)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        pbLoading.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }
}
