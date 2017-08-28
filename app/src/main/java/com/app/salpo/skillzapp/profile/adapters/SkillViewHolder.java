package com.app.salpo.skillzapp.profile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.app.salpo.skillzapp.R;
import com.app.salpo.skillzapp.profile.ProfilePresenter;
import com.app.salpo.skillzapp.profile.editskill.EditSkillViewDialog;
import com.app.salpo.skillzapp.profile.editskill.EditSkillViewPresenter;

/**
 * Created by arunaj on 8/23/17.
 */

public class SkillViewHolder extends RecyclerView.ViewHolder implements SkillViewHolderView, View.OnClickListener{

    public TextView TxtSkillName;
    public TextView updatedTime;
    public TextView TxtSkillType;
    public TextView rating;
    public RatingBar ratingBar;
    ProfilePresenter profilePresenter;

    private SkillViewHolderPresenter viewHolderPresenter;

    public SkillViewHolder (View itemView, ProfilePresenter profilePresenter) {
        super(itemView);
        this.profilePresenter = profilePresenter;

        viewHolderPresenter = new SkillViewHolderPresenterImpl(this);

        TxtSkillName = (TextView) itemView.findViewById(R.id.skill_name);
        updatedTime = (TextView) itemView.findViewById(R.id.updated_time);
        TxtSkillType = (TextView) itemView.findViewById(R.id.skill_type);
        rating = (TextView) itemView.findViewById(R.id.rating);
        ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);

        itemView.setOnClickListener(this);

    }


    @Override
    public void setSkillName(String skillName) {
        TxtSkillName.setText(skillName);
    }

    @Override
    public void setSkillType(String type) {
        TxtSkillType.setText(type);
    }

    @Override
    public void setSkillUpdatedTime(String skillUpdatedTime) {
        updatedTime.setText(skillUpdatedTime);
    }

    @Override
    public void setSkillRate(String skillRate) {
        rating.setText(skillRate);
    }

    @Override
    public void setRatingBar(String rate) {
        ratingBar.setRating(Float.parseFloat(rate));
    }

    @Override
    public SkillViewHolderPresenter getPresenter() {
        return viewHolderPresenter;
    }

    @Override
    public void onClick(View view) {
        EditSkillViewDialog editDialog=new EditSkillViewDialog(view.getContext());
        EditSkillViewPresenter presenter =editDialog.getPresenter();
        presenter.setupBridgeForProfile(profilePresenter);
        presenter.showEditDialog(getAdapterPosition());
    }
}
