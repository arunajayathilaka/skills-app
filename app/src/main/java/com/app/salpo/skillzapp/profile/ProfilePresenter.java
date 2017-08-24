package com.app.salpo.skillzapp.profile;

import com.app.salpo.skillzapp.profile.adapters.SkillViewHolderPresenter;
import com.app.salpo.skillzapp.profile.adapters.SkillViewHolderView;

/**
 * Created by arunaj on 8/23/17.
 */

public interface ProfilePresenter {

    //void onItemClicked(int position);

    void onDestroy();

    void onSkillClicked(int position);

    void bindViewHolderRow(SkillViewHolderPresenter skillViewHolderPresenter,int position);

    int getItemCount();

    void fetchProfile();
}
