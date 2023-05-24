package es.ieslavereda.android_recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConsultaActivity extends AppCompatActivity {
    private TextView nombreTV;
    private TextView oficioTV;
    private ImageView viewOficio;
    private Button bVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        Bundle extras = getIntent().getExtras();
        Usuario usuario = (Usuario) extras.getSerializable("usuario");

        nombreTV = findViewById(R.id.nombreTV);
        oficioTV = findViewById(R.id.oficioTV);
        viewOficio = findViewById(R.id.oficioImagen);
        bVolver = findViewById(R.id.volverButton);

        //Cargamos las vistas con la información adecuada
        nombreTV.setText(usuario.getApellidos() + ", " + usuario.getNombre());
        Profesion profesion = ProfesionRepository.getInstance().getProfesionByImage(usuario.getIdProfesion());
        oficioTV.setText(profesion.getNombre());
        viewOficio.setImageResource(profesion.getImg());

        //gestionamos el botón cancelar comunicando que el resultado se canceló
        bVolver.setOnClickListener(v -> {
            Intent i = new Intent();
            setResult(RESULT_CANCELED,i);
            finish();
        });

    }
}
