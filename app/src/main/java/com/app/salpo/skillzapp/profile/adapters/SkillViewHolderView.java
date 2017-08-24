package com.app.salpo.skillzapp.profile.adapters;

import android.widget.RatingBar;
import android.widget.TextView;

import com.app.salpo.skillzapp.R;

/**
 * Created by arunaj on 8/23/17.
 */

public interface SkillViewHolderView {

    SkillViewHolderPresenter getPresenter();

    void setSkillName(String skillName);
    void setSkillType(String skillType);
    void setSkillUpdatedTime(String skillUpdatedTime);
    void setSkillRate(String skillRate);
    void setRatingBar(String rate);
}
