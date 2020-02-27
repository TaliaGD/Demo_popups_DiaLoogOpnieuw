package be.ehb.demo_popups_dialoogopnieuw.ui;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import be.ehb.demo_popups_dialoogopnieuw.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private View.OnClickListener toastListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //wat gebeurt er on klik we gaan een toast maken
            Toast toasty = Toast.makeText(getActivity(), "Hello popup", Toast.LENGTH_LONG);
            //om de toast van plaats te veranderen
            // toasty.setGravity(Gravity.TOP,0,0);
            toasty.show();
        }
    };
    private View.OnClickListener simpleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new SimpleDialogFragment().show(getParentFragmentManager(), "sdf");

        }
    };
    private View.OnClickListener fluListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new FluDialogFragment().show(getParentFragmentManager(), "fdf");
        }
    };
    private View.OnClickListener dateListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new DateOfBirthDialogFragment().show(getParentFragmentManager(),"fdd");
        }
    };
    private View.OnClickListener snackListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar snackbar =  Snackbar.make(rootView.findViewById(R.id.frag_container), "Warum? ", Snackbar.LENGTH_INDEFINITE);
//om popover te sluiten moet er nog een actie toegevoegd worden
            snackbar.setAction("Durum!", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //ok dan
                }
            });
            snackbar.setActionTextColor(Color.CYAN);
            snackbar.show();
        }
    };
    private View rootView;

    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //verwijzing naar knop
        Button btnToast = rootView.findViewById(R.id.btn_toast);

        //listener naar knop
        btnToast.setOnClickListener(toastListener);
           //hier stond eerst de onCliklistener maar aangezien we deze meermaals gaan gebruiken gaan we deze algemeen aanschrijfbaar maken

        Button btnSimple = rootView.findViewById(R.id.btn_simple);
        btnSimple.setOnClickListener(simpleListener);

        Button btnFlu = rootView.findViewById(R.id.btn_flu);
        btnFlu.setOnClickListener(fluListener);


        Button btnDate = rootView.findViewById(R.id.btn_date);
        btnDate.setOnClickListener(dateListener);

        FloatingActionButton fabSnackBar = rootView.findViewById(R.id.fab_snackbar);
        fabSnackBar.setOnClickListener(snackListener);
        return rootView;
    }

}
