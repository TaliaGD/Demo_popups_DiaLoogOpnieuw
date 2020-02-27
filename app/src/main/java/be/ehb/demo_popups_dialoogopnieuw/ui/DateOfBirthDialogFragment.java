package be.ehb.demo_popups_dialoogopnieuw.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateOfBirthDialogFragment extends DialogFragment {

    private Calendar calendar;

    private Context mContext;

    private DatePickerDialog.OnDateSetListener dateSelectedListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            calendar.set(year, month, day);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            //geen getDate maar wel getTime om een date te krijgen
            String dateAsText = simpleDateFormat.format(calendar.getTime());

           // Toast.makeText(getActivity(), calendar.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(), dateAsText, Toast.LENGTH_LONG).show();
            //de toast geeft nu te veel informatie
        }
    };

    //nodige om nategaan of het aan de juiste activity wordt gekoppeld
        @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            mContext = context;
        }catch (RuntimeException re){
            throw new RuntimeException("Can only be opened in an Activity");
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //op welke datum start de calender
        calendar = Calendar.getInstance(Locale.getDefault());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);



       // return new DatePickerDialog(getActivity(), dateSelectedListener, year, month, day) ;
        return new DatePickerDialog(mContext, dateSelectedListener, year, month, day) ;
    }
}
