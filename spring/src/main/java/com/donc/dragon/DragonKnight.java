package com.donc.dragon;

/**
 * Created by donovan on 15/05/22.
 */
public class DragonKnight implements Knight {

    private Quest quest;

    public DragonKnight(Quest quest) {
        this.quest = quest;
    }

    public void startQuest() {
        quest.embark();
    }

}
