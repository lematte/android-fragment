package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;


public class MainActivity extends AppCompatActivity implements InfoFragment.OnEtudiantEventListener {

    ArrayList listEtudiants;
    int index = 0;
    InfoFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listEtudiants = new ArrayList();

        Vector itemValues = new Vector();

        itemValues.add("Saibi ");
        itemValues.add("Oussama ");
        itemValues.add("1");
        listEtudiants.add(itemValues);

        Vector itemValues2 = new Vector();
        itemValues2.add("Ben Ammar ");
        itemValues2.add("Med Amine ");
        itemValues2.add("2");
        listEtudiants.add(itemValues2);

        Vector itemValues3 = new Vector();
        itemValues3.add("Test");
        itemValues3.add("Test");
        itemValues3.add("3");
        listEtudiants.add(itemValues3);

        fragment = new InfoFragment();
        Bundle params = new Bundle();
        params.putString("nom", itemValues.get(0).toString());
        params.putString("prnom", itemValues.get(1).toString());
        params.putString("formation", itemValues.get(2).toString());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.llInfoContainr, fragment);
        ft.commit();
        fragment.setArguments(params);
    }

    @Override
    public void onSupprimerClicked() {

        if(listEtudiants.size()<=1)
        {
            listEtudiants.clear();
            fragment.afficherEtudiant("","","");
            return;
        }
        listEtudiants.remove(index);
        if(index>= listEtudiants.size())
            index =0;
        Vector vector = (Vector)listEtudiants.get(index);
        fragment.afficherEtudiant(vector.get(0).toString(),vector.get(1).toString(),vector.get(2).toString());
    }

    @Override
    public void onSuivantClicked() {
        if(listEtudiants.size()==0)
            return;
        index++;
        if(index>=listEtudiants.size())
            index=0;
        Vector vector = (Vector)listEtudiants.get(index);
        fragment.afficherEtudiant(vector.get(0).toString(),vector.get(1).toString(),vector.get(2).toString());
    }
}
