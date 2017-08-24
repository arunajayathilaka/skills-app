package com.app.salpo.skillzapp.profile.adapters;

import com.app.salpo.skillzapp.models.Skill;

/**
 * Created by arunaj on 8/23/17.
 */

public class SkillViewHolderPresenterImpl implements SkillViewHolderPresenter{
    private SkillViewHolderView mSkillViewHolderView;

    public SkillViewHolderPresenterImpl(SkillViewHolderView skillViewHolderView) {
        this.mSkillViewHolderView = skillViewHolderView;
    }

    @Override
    public void showSkill(Skill skill) {
        mSkillViewHolderView.setSkillName(skill.getSkillName());
        mSkillViewHolderView.setSkillType(skill.getSkillType());
        mSkillViewHolderView.setSkillUpdatedTime(skill.getUpdatedTime());
        mSkillViewHolderView.setSkillRate(skill.getRate()+"/10");
        mSkillViewHolderView.setRatingBar(skill.getRate());
    }
}
