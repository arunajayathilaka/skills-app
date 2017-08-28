package com.app.salpo.skillzapp.profile.editskill;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;

import com.app.salpo.skillzapp.R;
import com.app.salpo.skillzapp.profile.ProfilePresenter;
import com.app.salpo.skillzapp.profile.editskill.EditSkillView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arunaj on 8/25/17.
 */

public class EditSkillViewDialog implements EditSkillView {

    public Spinner skillNameSpinner;
    public RatingBar ratingBar;
    public ArrayAdapter<String> dataAdapter;
    public Context context;
    public EditSkillViewPresenter editSkillViewPresenter;
    public ProfilePresenter profilePresenter;

    public EditSkillViewDialog(Context context) {
        this.context = context;
        editSkillViewPresenter = new EditSkillViewPresenterImp(this);

    }

    @Override
    public void onCreate() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.add_rem_skill_layout, null);

        skillNameSpinner = (Spinner) subView.findViewById(R.id.spinner);
        ratingBar = (RatingBar) subView.findViewById(R.id.ratingBar);

        List<String> categories = new ArrayList<String>();
        categories.add("Java");
        categories.add("C#");
        categories.add("PHP");
        categories.add("Docker");
        categories.add("C");
        categories.add("AngularJS");

        dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        skillNameSpinner.setAdapter(dataAdapter);

        //skillNameSpinner.setSelection(dataAdapter.getPosition(skillName));
        //ratingBar.setRating(Float.parseFloat(rate));

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Edit Skill");
        builder.setView(subView);
        builder.create();
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    @Override
    public void setSkillName(String skillName) {
        skillNameSpinner.setSelection(dataAdapter.getPosition(skillName));
    }

    @Override
    public void setRate(String rate) {
        ratingBar.setRating(Float.parseFloat(rate));
    }

    public EditSkillViewPresenter getPresenter(){
        return editSkillViewPresenter;
    }
}
