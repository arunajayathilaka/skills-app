package com.app.salpo.skillzapp.profile;

import com.app.salpo.skillzapp.models.Skill;
import com.app.salpo.skillzapp.models.User;

import java.util.List;

/**
 * Created by arunaj on 8/23/17.
 */

public interface ProfileView {
    /*void showProgress();

    void hideProgress();*/

    void setUsername(String username);

    void setDesignation(String designation);

    void notifySkillList();

    void showEditSkillDialog(String skillType, String skillName, String rate);

    /*void setImage();

    void showAddButton();

    void hideAddButton();

    void enableEditSkill();

    void disableEditSkill();

    void enableDeleteSkill();

    void disableDeleteSkill();*/

}
