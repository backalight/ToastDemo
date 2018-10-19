package fr.formation.toastdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static fr.formation.toastdemo.Tools.affToast;

public class MainActivity extends AppCompatActivity {
TextView tvToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvToast=findViewById(R.id.tvToast);
    }


    public void lancer(View view) {
        Activity act = this;
        String msg ="Ce toast est quand même bien plus joli que le toast par default";
       affToast(act,msg);

    }
}
