package com.royal.myfinalapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {

    private Button btnAlert;
    private Button btnCustomAlert , btnCustomtoast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        btnAlert = findViewById(R.id.btn_alert);
        btnCustomAlert = findViewById(R.id.btn_custom_alert);
        btnCustomtoast = findViewById(R.id.btn_ctm_toast);


        btnCustomtoast.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View mytoast = layoutInflater.inflate(R.layout.raw_layout,null);
                Toast toast = new Toast(AlertActivity.this);
                toast.setView(mytoast);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        btnCustomAlert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.raw_custom_dialog,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertActivity.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                alertDialog.setView(myview);

                Button btncanel = myview.findViewById(R.id.btn_Cancel);
                EditText edtstr = myview.findViewById(R.id.edt_custom_emial);



                Button btnsearch = myview.findViewById(R.id.btn_search);

                btnsearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (alertDialog.isShowing())
                        {
                            alertDialog.dismiss();
                        }

                        String strEmial = edtstr.getText().toString();
                        View mytoast = layoutInflater.inflate(R.layout.raw_layout,null);
                        Toast toast = new Toast(AlertActivity.this);
                        TextView tvdata = mytoast.findViewById(R.id.tv_data);
                        tvdata.setText(strEmial);
                        toast.setView(mytoast);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();


                    }
                });

                btncanel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                    }
                });
                alertDialog.show();
            }
        });

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertActivity.this);
                builder.setIcon(R.drawable.customer);
                builder.setTitle("This is The Title Cant u See");
                builder.setMessage("Are u Sure You want to delete");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertActivity.this, "Yes is Clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(AlertActivity.this, "No", Toast.LENGTH_SHORT).show();
                }
            });

                builder.setNeutralButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }



        });
    }
}