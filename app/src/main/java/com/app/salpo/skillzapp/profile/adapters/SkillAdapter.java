package com.app.salpo.skillzapp.profile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.salpo.skillzapp.R;
import com.app.salpo.skillzapp.profile.ProfilePresenter;
import com.app.salpo.skillzapp.profile.ProfileView;

/**
 * Created by arunaj on 8/23/17.
 */

public class SkillAdapter extends RecyclerView.Adapter<SkillViewHolder> {
    private ProfileView mProfileView;
    private ProfilePresenter mProfilePresenter;

    public SkillAdapter(ProfilePresenter profilePresenter) {
        this.mProfilePresenter = profilePresenter;
    }

    @Override
    public SkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_item_layout, parent, false);
        return new SkillViewHolder(view);
    }
    @Override
    public void onBindViewHolder(SkillViewHolder holder, int position) {
        mProfilePresenter.bindViewHolderRow(holder.getPresenter(),position);
    }

    @Override
    public int getItemCount() {
        return mProfilePresenter.getItemCount();
    }

}
