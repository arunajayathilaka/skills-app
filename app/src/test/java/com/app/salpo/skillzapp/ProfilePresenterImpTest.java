package com.app.salpo.skillzapp;

import com.app.salpo.skillzapp.models.Skill;
import com.app.salpo.skillzapp.profile.ProfilePresenterImp;
import com.app.salpo.skillzapp.profile.ProfileView;
import com.app.salpo.skillzapp.profile.adapters.SkillViewHolderPresenter;
import com.app.salpo.skillzapp.profile.adapters.SkillViewHolderView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by arunaj on 8/25/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class ProfilePresenterImpTest {
    @Mock
    ProfileView view;

    @Mock
    SkillViewHolderView skillViewHolderView;

    @Mock
    List<Skill> skillsList;

    @Mock
    SkillViewHolderPresenter skillViewHolderPresenter;

    private ProfilePresenterImp presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new ProfilePresenterImp(view);
    }

    @Test
    public void checkIfProfileViewIsDestroy() {
        presenter.onDestroy();
        assertNull(presenter.profileView);
    }

    @Test
    public void checkIfProfilefetch(){
        presenter.fetchProfile();

        verify(view, times(1)).notifySkillList();
        verify(view, times(1)).setUsername(anyString());
        verify(view,times(1)).setDesignation(anyString());
    }

   @Test
    public void checkIfBindViewHolderRow(){
       Skill s1 = new Skill("Java","mobile","12/08/2017",3);
       //presenter.setSkills(skillsList);
       when(skillsList.get(0)).thenReturn(s1);
       when(skillViewHolderView.getPresenter()).thenReturn(skillViewHolderPresenter);
       presenter.bindViewHolderRow(skillViewHolderView,0);
       verify(skillViewHolderPresenter,times(1)).showSkill(any(Skill.class));
    }


   @Test
   public void checkIfgetSkillFromSkillList(){

       Skill s1 = new Skill("Java","mobile","12/08/2017",3);
       Skill s2 = new Skill("Java","mobile","12/08/2017",3);
       List<Skill> skills = new ArrayList<>();
       skills.add(s1);
       skills.add(s2);
       presenter.setSkills(skills);
       Skill tmp=presenter.getSkillFromSkillList(0);
       assertThat(tmp.getSkillName(),is(s1.getSkillName()));

   }

   @Test
    public void checkIfGetItemCount(){
       Skill s1 = new Skill("Java","mobile","12/08/2017",3);
       Skill s2 = new Skill("Java","mobile","12/08/2017",3);
       List<Skill> skills = new ArrayList<>();
       skills.add(s1);
       skills.add(s2);
       presenter.setSkills(skills);
       int tmp = presenter.getItemCount();
       assertThat(tmp,is(2));

   }




}
