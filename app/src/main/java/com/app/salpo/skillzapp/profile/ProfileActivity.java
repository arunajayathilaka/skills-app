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

    public RecyclerView skillView;
    public TextView usernameView;
    public TextView designationView;
    public ProfilePresenter presenter;
    public SkillAdapter skillAdapter;

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

    /*@Override
    public void setPresenter(ProfilePresenter _presenter) {
        presenter = _presenter;
    }*/

    @Override
    public void showEditSkillDialog(String skillType, String skillName, String rate) {


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
