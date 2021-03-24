package com.example.tp3;


import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */


public class InfoFragment extends Fragment
{

    TextView nomTV;
    TextView prnomTV;
    TextView formationTV;

    public interface OnEtudiantEventListener{
        public void onSupprimerClicked();
        public void  onSuivantClicked();
    }

    public InfoFragment() {
        // Required empty public constructor
    }


    public void afficherEtudiant(String nom,String prnom,String formation)
    {
        try {
            nomTV.setText(nom);
            prnomTV.setText(prnom);
            formationTV.setText(formation);
        }catch (Exception ex)
        {
            Toast.makeText(getActivity(), "Not able to get TextView objects!", Toast.LENGTH_SHORT).show();
        }

    }

    public void  Suivant()
    {
        ((OnEtudiantEventListener)getActivity()).onSuivantClicked();
    }

    public void Supprimer()
    {
        ((OnEtudiantEventListener)getActivity()).onSupprimerClicked();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle params = getArguments();
        String nom = params.getString("nom");
        String prenom = params.getString("prnom");
        String formation = params.getString("formation");


        View view = inflater.inflate(R.layout.fragment_info,
                container, false);

        nomTV = (TextView) view.findViewById(R.id.nomTV);

        prnomTV = (TextView)view.findViewById(R.id.prnomTV);

        formationTV = (TextView)view.findViewById(R.id.formationTV);

        afficherEtudiant(nom,prenom,formation);
        Button btnSuivant = view.findViewById(R.id.suivantBTN);

        Button btnSupprim = view.findViewById(R.id.supprimerBTN);

            btnSuivant.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Suivant();
                }
            });
        btnSupprim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Supprimer();
            }
        });


        return view;
    }

}
