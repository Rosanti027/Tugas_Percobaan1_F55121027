package com.example.mytugas_f55121027;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private EditText edtWidht;
   private EditText edtHeight;
   private EditText edtLenght;
   private Button btnCalculate;
   private TextView tvResult;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      edtWidht = findViewById(R.id.edt_widht);
      edtHeight = findViewById(R.id.edt_height);
      edtLenght = findViewById(R.id.edt_lenght);
      btnCalculate = findViewById(R.id.btn_calculate);
      tvResult = findViewById(R.id.tv_result);

      btnCalculate.setOnClickListener(this);
   }

   @Override
   public void onClick(View view) {
      if (view.getId() == R.id.btn_calculate) {
         String inputLength = edtLenght.getText().toString().trim();
         String inputWidth = edtWidht.getText().toString().trim();
         String inputHeight = edtHeight.getText().toString().trim();

         boolean isEmptyFields = false;

         if (TextUtils.isEmpty(inputLength)) {
            isEmptyFields = true;
            edtLenght.setError("Field ini tidak boleh kosong");
         }
         if (TextUtils.isEmpty(inputWidth)) {
            isEmptyFields = true;
            edtWidht.setError("Field ini tidak boleh kosong");
         }
         if (TextUtils.isEmpty(inputHeight)) {
            isEmptyFields = true;
            edtHeight.setError("Field ini tidak boleh kosong");
         }
         if (!isEmptyFields) {

            Double volume = Double.parseDouble(inputLength) * Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
            tvResult.setText(String.valueOf(volume));
         }
      }
   }
}
