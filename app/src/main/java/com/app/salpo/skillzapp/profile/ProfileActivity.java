package com.app.salpo.skillzapp.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.salpo.skillzapp.R;
import com.app.salpo.skillzapp.profile.adapters.SkillAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements ProfileView, AdapterView.OnItemClickListener {

    public RecyclerView     skillView;
    public TextView         usernameView;
    public TextView         designationView;
    public ProfilePresenter presenter;
    public SkillAdapter     skillAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        usernameView = (TextView) findViewById(R.id.username);
        designationView = (TextView) findViewById(R.id.designation);
        skillView = (RecyclerView) findViewById(R.id.skill_list);

        presenter = new ProfilePresenterImp(this);

        skillAdapter = new SkillAdapter(presenter);
        skillView.setAdapter(skillAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        skillView.setLayoutManager(linearLayoutManager);
        skillView.setHasFixedSize(true);


    }

    @Override
    public void notifySkillList() {
        skillAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEditSkillDialog(String skillType, String skillName, String rate) {
        Toast.makeText(getApplicationContext(), "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
       /* LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View subView = inflater.inflate(R.layout.add_rem_skill_layout, null);

        Spinner skillNameSpinner = (Spinner) findViewById(R.id.spinner);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        List<String> categories = new ArrayList<String>();
        categories.add("Java");
        categories.add("C#");
        categories.add("PHP");
        categories.add("Docker");
        categories.add("C");
        categories.add("AngularJS");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        skillNameSpinner.setAdapter(dataAdapter);

        skillNameSpinner.setSelection(dataAdapter.getPosition(skillName));
        ratingBar.setRating(Float.parseFloat(rate));
*/

    }

    @Override protected void onResume() {

        super.onResume();
        presenter.fetchProfile();

    }

    @Override
    public void setUsername(String username) {

        usernameView.setText(username);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void setDesignation(String designation) {

        designationView.setText(designation);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        //presenter.onSkillClicked(i);
       /* switch (adapterView.getId()) {

            case R.id.skill_list:
                presenter.onSkillClicked(i);
                break;
            case R.id.spinner:


        }*/
    }
}
