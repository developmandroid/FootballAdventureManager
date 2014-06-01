/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.arnea.footballadventuremanager.wizardpager;

import android.content.Context;
import pl.arnea.footballadventuremanager.vars.GlobalData;
import pl.arnea.footballadventuremanager.wizardpager.wizard.model.*;

public class NewGameWizardModel extends AbstractWizardModel {
    public NewGameWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {

        String[] clubs1 = new String[GlobalData.allLeagues.get(0).getLeagueClubs().size()];
        for (int i = 0; i < GlobalData.allLeagues.get(0).getLeagueClubs().size(); i++) {
            clubs1[i] = GlobalData.allLeagues.get(0).getLeagueClubs().get(i).getName();
        }

        String[] clubs2 = new String[GlobalData.allLeagues.get(1).getLeagueClubs().size()];
        for (int i = 0; i < GlobalData.allLeagues.get(1).getLeagueClubs().size(); i++) {
            clubs2[i] = GlobalData.allLeagues.get(1).getLeagueClubs().get(i).getName();
        }

        String[] clubs3 = new String[GlobalData.allLeagues.get(2).getLeagueClubs().size()];
        for (int i = 0; i < GlobalData.allLeagues.get(2).getLeagueClubs().size(); i++) {
            clubs3[i] = GlobalData.allLeagues.get(2).getLeagueClubs().get(i).getName();
        }

        String[] clubs4 = new String[GlobalData.allLeagues.get(3).getLeagueClubs().size()];
        for (int i = 0; i < GlobalData.allLeagues.get(3).getLeagueClubs().size(); i++) {
            clubs4[i] = GlobalData.allLeagues.get(3).getLeagueClubs().get(i).getName();
        }

        String[] clubs5 = new String[GlobalData.allLeagues.get(4).getLeagueClubs().size()];
        for (int i = 0; i < GlobalData.allLeagues.get(4).getLeagueClubs().size(); i++) {
            clubs5[i] = GlobalData.allLeagues.get(4).getLeagueClubs().get(i).getName();
        }


        return new PageList(new BranchPage(this, "Select league (level of difficulty)")
                .addBranch(
                        "First League (Easy way)",
                        new SingleFixedChoicePage(this, "Select club")
                                .setChoices(clubs1)
                                .setRequired(true)
                )

                .addBranch(
                        "Second League (Challenge)",
                        new SingleFixedChoicePage(this, "Select club")
                                .setChoices(clubs2)
                                .setRequired(true)
                )

                .addBranch(
                        "Third League (Average)",
                        new SingleFixedChoicePage(this, "Select club")
                                .setChoices(clubs3)
                                .setRequired(true)
                )

                .addBranch(
                        "Fourth League (Explorer)",
                        new SingleFixedChoicePage(this, "Select club")
                                .setChoices(clubs4)
                                .setRequired(true)
                )

                .addBranch(
                        "Fifth (Impossible)",
                        new SingleFixedChoicePage(this, "Select club")
                                .setChoices(clubs5)
                                .setRequired(true)
                )

                .setRequired(true),

                new CustomerInfoPage(this, "Manager name").setRequired(true)
        );
    }
}
