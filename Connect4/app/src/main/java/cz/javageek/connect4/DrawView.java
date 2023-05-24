package cz.javageek.connect4;

import android.view.View;

public class DrawView extends View {

    private char[][] table;

    public DrawView(Connect4 mainActivity, char[][] table) {
        super(mainActivity);
        this.table = table;
    }

}
