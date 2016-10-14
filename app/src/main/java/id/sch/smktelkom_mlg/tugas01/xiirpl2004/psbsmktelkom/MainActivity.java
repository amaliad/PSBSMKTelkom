package id.sch.smktelkom_mlg.tugas01.xiirpl2004.psbsmktelkom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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
        spagama = (Spinner) findViewById(R.id.spinneragama);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonDaftar).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        }));
    }

    private void doClick() {
        if (isValid()) {
            StringBuilder builder = new StringBuilder();
            String nama = etnama.getText().toString();
            String tmpLhr = ettmpLhr.getText().toString();
            int thnLhr = Integer.parseInt(etthnLhr.getText().toString());
            int usia = 2016 - thnLhr;
            String hasil = null;
            if (rgJK.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgJK.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvHasil.setText("Anda belum memilih Jenis Kelamin\n");
            } else {
                String asal = etasal.getText().toString();
                String program = "Program yang dipilih : \n";
                int startlen = program.length();
                if (cbrgl.isChecked()) program += "\t " + cbrgl.getText() + "\n";
                if (cbblg.isChecked()) program += "\t " + cbrgl.getText() + "\n";
                if (cbaksl.isChecked()) program += "\t " + cbrgl.getText() + "\n";
                if (program.length() == startlen) {
                    tvHasil.setText("Tidak ada Program yang dipilih\n");
                } else {
                    builder.append("\nPSB SMK TELKOM MALANG");
                    builder.append("\n" + program);
                    builder.append("Nama : " + nama + "\n");
                    builder.append("Jenis Kelamin : " + hasil + "\n");
                    builder.append("Tempat Lahir : " + tmpLhr + "\n");
                    builder.append("Tahun Lahir : " + thnLhr + "\n");
                    builder.append("Umur : " + usia + "\n");
                    builder.append("Agama : ");
                    builder.append(spagama.getSelectedItem().toString() + "\n");
                    builder.append("Asal Sekolah : " + asal + "\n");

                    tvHasil.setText(builder);
                }
            }
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etnama.getText().toString();
        String tmpLhr = ettmpLhr.getText().toString();
        String thnLhr = etthnLhr.getText().toString();
        String asal = etasal.getText().toString();

        if (nama.isEmpty()) {
            etnama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etnama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etnama.setError(null);
        }
        if (tmpLhr.isEmpty()) {
            ettmpLhr.setError("Tempat Lahir belum diisi");
            valid = false;
        } else {
            ettmpLhr.setError(null);
        }
        if (thnLhr.isEmpty()) {
            etthnLhr.setError("Tahun belum diisi");
            valid = false;
        } else if (thnLhr.length() != 4) {
            etthnLhr.setError("Format Tahun bukan yyyy");
            valid = false;
        } else {
            etthnLhr.setError(null);
        }
        if (asal.isEmpty()) {
            etasal.setError("Asal Sekolah belum diisi");
            valid = false;
        } else if (asal.length() < 5) {
            etasal.setError("Nama Asal Sekolah minimal 5 karakter");
            valid = false;
        } else {
            etasal.setError(null);
        }
        return valid;
    }

}
