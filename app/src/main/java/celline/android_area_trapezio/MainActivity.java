package celline.android_area_trapezio;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 *@author:<Celline>
 */
public class MainActivity extends AppCompatActivity {

    private EditText etMenor;
    private EditText etMaior;
    private EditText etAltura;
    private Button btnCalcular;
    private TextView tvResultado;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etMenor = findViewById(R.id.etMenor);
        etMenor.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etMaior = findViewById(R.id.etMaior);
        etMaior.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etAltura = findViewById(R.id.etAltura);
        etAltura.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        btnCalcular.setOnClickListener(calculate -> calc());
    }
    /*
     *@author:<Celline>
     */
    private void calc(){
        float menor = Float.parseFloat(etMenor.getText().toString());
        float maior = Float.parseFloat(etMaior.getText().toString());
        float altura = Float.parseFloat(etAltura.getText().toString());
        float resultado = Float.parseFloat(tvResultado.getText().toString());
        float area = ((menor + maior) * altura)/2;

        String res = getString(R.string.area);
        tvResultado.setText(res);
    }
}