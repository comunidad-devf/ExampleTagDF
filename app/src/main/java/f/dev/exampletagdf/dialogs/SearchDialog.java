package f.dev.exampletagdf.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;

import f.dev.exampletagdf.R;

/**
 * Created by sati on 01/07/2015.
 */
public class SearchDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View viewDialog = getActivity().getLayoutInflater().inflate(R.layout.search_dialog, null);

        builder.setTitle(R.string.app_name)
                .setView(viewDialog)
                .setPositiveButton(R.string.ok, null)
                .setNegativeButton(R.string.cancel, null);


        return builder.create();
    }
}
