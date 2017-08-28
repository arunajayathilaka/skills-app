package com.app.salpo.skillzapp.profile.editskill;

import android.content.Context;

import com.app.salpo.skillzapp.models.Skill;
import com.app.salpo.skillzapp.profile.ProfilePresenter;

import java.util.List;

/**
 * Created by arunaj on 8/25/17.
 */

public class EditSkillViewPresenterImp implements EditSkillViewPresenter {

    public EditSkillView editSkillView;

    public ProfilePresenter profilePresenter;


    public EditSkillViewPresenterImp(EditSkillView editSkillView) {
        this.editSkillView = editSkillView;

    }

    @Override
    public void showEditDialog(int position) {
        Skill singleSkill = profilePresenter.getSkillFromSkillList(position);
        editSkillView.onCreate();
        editSkillView.setSkillName(singleSkill.getSkillName());
        editSkillView.setRate(singleSkill.getRate());

    }

    @Override
    public void getSkill() {

    }

    @Override
    public void setSkill(Skill skill) {
        editSkillView.setSkillName(skill.getSkillName());
        editSkillView.setRate(skill.getRate());
    }

    @Override
    public void setupBridgeForProfile(ProfilePresenter profilePresenter) {
        this.profilePresenter = profilePresenter;
    }
}
