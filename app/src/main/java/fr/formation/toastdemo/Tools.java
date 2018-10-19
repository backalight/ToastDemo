package fr.formation.toastdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tools  {
    public static void affToast(Activity act,String msg){
      //acceder au gonfleur d'ecran
        LayoutInflater inflater = act.getLayoutInflater();
        View v = inflater.inflate(R.layout.toast, (ViewGroup) act.findViewById(R.id.llToast));
        //Definir le texte à afficher
        TextView etToast = v.findViewById(R.id.tvToast);
        etToast.setText(msg);


        //creer le toast
        Toast toast = Toast.makeText(act,msg,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.setView(v);
        toast.show();


    }

}
