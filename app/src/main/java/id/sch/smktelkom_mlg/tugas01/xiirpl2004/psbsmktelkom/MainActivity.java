package id.sch.smktelkom_mlg.tugas01.xiirpl2004.psbsmktelkom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvHasil;
    EditText etnama, ettmpLhr, etthnLhr, etasal;
    CheckBox cbrgl, cbblg, cbaksl;
    RadioGroup rgJK;
    Spinner spagama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnama = (EditText) findViewById(R.id.editTextNama);
        ettmpLhr = (EditText) findViewById(R.id.editTexttmpLhr);
        etthnLhr = (EditText) findViewById(R.id.editTextthnLhr);
        etasal = (EditText) findViewById(R.id.editTextAsal);
        cbrgl = (CheckBox) findViewById(R.id.checkBoxReguler);
        cbblg = (CheckBox) findViewById(R.id.checkBoxBilingual);
        cbaksl = (CheckBox) findViewById(R.id.checkBoxAksel);
        rgJK = (RadioGroup) findViewById(R.id.RadioGroup);
        spagama = (Spinner) findViewById(R.id.spinner);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonDaftar).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        }));
    }

    private void doClick() {

    }
}
