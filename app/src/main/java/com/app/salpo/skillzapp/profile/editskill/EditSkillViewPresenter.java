package com.app.salpo.skillzapp.profile.editskill;

import android.content.Context;

import com.app.salpo.skillzapp.models.Skill;
import com.app.salpo.skillzapp.profile.ProfilePresenter;

/**
 * Created by arunaj on 8/25/17.
 */

public interface EditSkillViewPresenter {
    void showEditDialog(int position);
    void getSkill();
    void setSkill(Skill skill);
    void setupBridgeForProfile(ProfilePresenter profilePresenter);
}
