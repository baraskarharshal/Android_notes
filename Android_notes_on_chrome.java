# Using Log

import android.util.Log;

private static final String TAG = "activity_name";

Log.d(TAG, "view name is: " + view);
------------------------------------------------------------

# Creating custom dialog with forms

// Setting repeat dialog layouts
        repeatDialog = new Dialog(this);
        repeatDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        repeatDialog.setContentView(R.layout.activity_repeat);
        setDialogAttributes(repeatDialog);
        repeatGroup = (RadioGroup) repeatDialog.findViewById(R.id.repeatOptions);
        customRepeat = (RadioButton) repeatDialog.findViewById(R.id.custom);
        repeatOkButton = (Button) repeatDialog.findViewById(R.id.okButton);
        repeatCancelButton = (Button) repeatDialog.findViewById(R.id.cancelButton);



// Designing above dialog

// Method to set default attributes of dialog

    public void setDialogAttributes(Dialog d){

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(d.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;

        d.getWindow().setAttributes(lp);
    }



