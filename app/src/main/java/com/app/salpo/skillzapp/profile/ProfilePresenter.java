package com.app.salpo.skillzapp.profile;

import com.app.salpo.skillzapp.models.Skill;
import com.app.salpo.skillzapp.profile.adapters.SkillViewHolder;
import com.app.salpo.skillzapp.profile.adapters.SkillViewHolderPresenter;
import com.app.salpo.skillzapp.profile.adapters.SkillViewHolderView;

import java.util.List;

/**
 * Created by arunaj on 8/23/17.
 */

public interface ProfilePresenter {

    //void onItemClicked(int position);

    void onDestroy();

    void bindViewHolderRow(SkillViewHolderView skillViewHolderView, int position);

    int getItemCount();

    void fetchProfile();

    Skill getSkillFromSkillList(int position);

    void setSkills(List<Skill> skillList);
}
