package com.ralphevmanzano.friendlychat;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/**
 * Created by ralphemerson on 12/15/2017.
 */

public class DoneOnEditorActionListener implements TextView.OnEditorActionListener {
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            return true;
        }
        return false;
    }
}

