package com.if4a.footballplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PostActivity extends AppCompatActivity {
    private EditText etNama , etNomor , etKlub;
    private Button btnPost;

    private MyDatabaseHelper myDB = new MyDatabaseHelper(PostActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        etNama = findViewById(R.id.et_nama);
        etNomor = findViewById(R.id.et_nomor);
        etKlub = findViewById(R.id.et_klub);
        btnPost = findViewById(R.id.btn_add);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama,nomor,klub;

                nama = etNama.getText().toString();
                nomor = etNomor.getText().toString();
                klub= etKlub.getText().toString();

                if(nama.trim().equals("")){
                    etNama.setError("Nama Player Tidak Boleh Kosong");
                }
                else if(nomor.trim().equals("")){
                    etNama.setError("Nomor Player Tidak Boleh Kosong");
                }
                else if(klub.trim().equals("")){
                    etNama.setError("Klub Player Tidak Boleh Kosong");
                }
                else{
                    long exe = myDB.postPlayer(nama,nomor,klub);
                    if(exe == -1){
                        Toast.makeText(PostActivity.this,"Gagal Menambahkan Data",Toast.LENGTH_SHORT).show();
                        etNama.requestFocus();
                    }
                    else{
                        Toast.makeText(PostActivity.this,"Berhasil Menambahkan Data",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}