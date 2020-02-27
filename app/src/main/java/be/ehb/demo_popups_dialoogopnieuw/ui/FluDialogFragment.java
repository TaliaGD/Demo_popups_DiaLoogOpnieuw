package be.ehb.demo_popups_dialoogopnieuw.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FluDialogFragment extends DialogFragment {

    String[] flues = {"Vanilla Flu", "Corona", "Spanish Flu", "Sars"};
    private DialogInterface.OnClickListener itemSelectListene = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int i) {
            Toast.makeText(getActivity(), "you caught " + flues[i], Toast.LENGTH_LONG).show();
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Gotta catch 'em all");
        builder.setItems(flues, itemSelectListene);
        builder.setNegativeButton(android.R.string.cancel, null);

        return builder.create();
    }
}
