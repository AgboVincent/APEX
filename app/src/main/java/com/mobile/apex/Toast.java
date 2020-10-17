package com.mobile.apex;

import android.content.Context;

class Toast extends android.widget.Toast {
    public Toast(String watv, Context context) {
        super( context );
    }

    public void myToast (String toast, Context context) {
        String message = toast;
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
