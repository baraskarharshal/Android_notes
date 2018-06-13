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

------------------------------------------------------------------------------------------
        
# Using Toast

import android.widget.Toast;

Toast.makeText(getApplicationContext(), "Loging out...", Toast.LENGTH_SHORT).show();
-----------------------------------------------------------------------------------------
        
# ImageView

view: ImageView
scaleType: center -- centers the image without changing size.
 : centerCrop  -- centers the image and fits to the screen.

ImageView eg.

<ImageView
    android:src="@drawble/image"
    android:scaleType="centerCrop"
/>

# All kind of views can have id

eg. android:id="@+id/photo_image_view"
-----------------------------------------------------------------------------------------
        
# Using Progress Dialogue

import android.app.ProgressDialog;

private ProgressDialog progressDialog;
progressDialog = new ProgressDialog(this);

progressDialog.setMessage("Registration in progress...");
progressDialog.show();
-----------------------------------------------------------------------------------------

# Layouts

1. Linear Layout
- Can arrange items either in horizontal or vertical line
- for this you have to give value of orientation
<LinearLayout
    android:orientation="horizontal/vertical"
/>

2. Relative Layout
- It arranges items relative to each other.
eg. Header is at top side and footer is at bottom side of relative layout.
            
-----------------------------------------------------------------------------------------            

# To display preview in device screen

In preview window click F on keyboard.
-----------------------------------------------------------------------------------------                       
# Errors

1. Always user small letters in the name of xml files.
-----------------------------------------------------------------------------------------             

# when hash key prints pound on keyboard.

got to desktop. press alt+shift. problem solved.

You have accidentally switched from the UK to the US keyboard in Microsoft Windows. In fact, you can toggle between the two layouts by pressing Alt-Shift. It's easy to do this by accident so the problem comes up often. If you turn your PC off at night, it will restart with the correct settings, so the problem may appear self-correcting.            
-----------------------------------------------------------------------------------------           
            
# Change API Level

Right click on your project file
Select "Open Module Settings"
Go to the "Flavors" tab.
Select the Min SDK Version from the drop down list
----------------------------------------------------------------------------------------- 
# To remove action bar

change theme name in manifest file to below one

android:theme="@style/Theme.AppCompat.DayNight.NoActionBar" 
----------------------------------------------------------------------------------------- 

 # android.databinding.DataBindingUtil package not found error

Add below code in app graddle build file and rebuild project.

dataBinding {
        enabled = true
    }

Make sure your complete layout design in inside tag <layout>. If not then databinding package not found error comes.
----------------------------------------------------------------------------------------- 
        
# ListView 

to get string array in resources 

getResources().getStringArray(R.array.<arrayName>)

returns string array
----------------------------------------------------------------------------------------- 
        
# Disable keypad on focus edit text

EditText edittxt = (EditText) findViewById(R.id.editText);
edittxt.setShowSoftInputOnFocus(false);
----------------------------------------------------------------------------------------- 
        
Back button in action bar

Add below in manifest file 

<activity android:name=".MovieInfoActivity" android:parentActivityName=".MainActivity">

        </activity>

Add below line in onCreate() of activity

getSupportActionBar().setDisplayHomeAsUpEnabled(true);
----------------------------------------------------------------------------------------- 
        
# minSdkVersion means minimum Android OS version that will support your app

targetSdkVersion means the version for which you are actually developing your application.

Your app will be compatible with all the version of android which are falling between minimum level SDK and target SDK.
----------------------------------------------------------------------------------------- 
        
# Snackbar


Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
----------------------------------------------------------------------------------------- 
        
Relative layout

# Child view attributes

android:layout_alignParentTop="true"
android:layout_alignParentBottom
android:layout_alignParentLeft
android:layout_alignParentRight

eg. To fix an image view at top side of layout, then we need following values
android:layout_alignParentTop="true"
android:layout_alignParentBottom="false"
android:layout_alignParentLeft="true"
android:layout_alignParentRight="true"
-------------------------------------------------

# To position one view relative to other view
eg. i want view A positioned to the left of view B, then use following attribute.
android:layuout_toLeftOf="<id of view>"

similarly, we can use
toRightOf, above, below
-------------------------------------------------

# Shape corner, background color and border design

<shape xmlns:android="http://schemas.android.com/apk/res/android" android:shape="rectangle" >
    <corners
        android:radius="8dp"
        />
   <this is background> <solid
        android:color="#BDBDBD"
        />
    
   <this is background> <stroke
        android:width="0.1dp"
        android:color="#BDBDBD"
        />
</shape>
-------------------------------------------------

# Dynamically generate view id to use in findviewbyid

notes = (TextView)findViewById(getResources().getIdentifier(VIEW_NAME, "id", getPackageName()));

-------------------------------------------------
        
# Dialog title with color and divider

private String HALLOWEEN_ORANGE = "#FF7F27";

QustomDialogBuilder qustomDialogBuilder = new QustomDialogBuilder(v.getContext()).
    setTitle("Set IP Address").
    setTitleColor(HALLOWEEN_ORANGE).
    setDividerColor(HALLOWEEN_ORANGE).
    setMessage("You are now entering the 10th dimension.");

qustomDialogBuilder.show();        
-------------------------------------------------

# For dialogue activity

@android:style/Theme.Dialog

add this in manifest file for the activity which need to be a gialogue  
-------------------------------------------------

# Setting static item in listview


View itemView = View.inflate(alarmContext, R.layout.list_activity, null);
        TextView alarmTime = (TextView) itemView.findViewById(R.id.alarmTime);
        TextView alarmAmPm = (TextView) itemView.findViewById(R.id.ampm);
        TextView alarmNote = (TextView) itemView.findViewById(R.id.alarmNote);
        TextView alarmState = (TextView) itemView.findViewById(R.id.state);

        // set values

        alarmTime.setText(alarmItemList.get(position).getTime());
        alarmAmPm.setText(alarmItemList.get(position).getAmpm());
        alarmNote.setText(alarmItemList.get(position).getNote());
        alarmState.setText(alarmItemList.get(position).getSwitchState());
-------------------------------------------------
        
# duplicate attribute error

Remove xmlns from child layouts and keep only one at parent level.    
-------------------------------------------------
        
Preview rendering issue

1. Click on show warnings and errors icon just right to the hand icon in preview window.
2. First error shows the reason of error. Expand it. Click on refresh. This will solve the rendering issue.
-------------------------------------------------
        
 # Android Measures

dp: stands for density independent pixels
- It keeps size of view same regardless of resolution of device.
- usually used for layout
eg.
android:layout_width="20dp"

sp: scale independent pixels

- used to set text size. It make app look consistent regardless of resolution of device.

eg. android:textSize="20sp"

# wrap_content
- it adjust the size of of view according to content inside.

# parent_match
- It adjust the size of child view and matches with parent. not small or bigger, just fit to the parent.
-------------------------------------------------
        
For Rtl fashion of writing in text use below.

android:gravity="right"   
-------------------------------------------------        
# Dependency conflict error between test and original app.
To resolve this we can force to use specified version of dependency. Add below lines in app.gradle file.
        
 configurations.all {
        resolutionStrategy.force "com.android.support:support-annotations:26.1.0" // replace by the dependency which is creating conflict.
    }
      
        





        
        
        
            
