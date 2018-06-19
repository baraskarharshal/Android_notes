
// repeatDays is the array of days which needs to be checked.
repeatDays = repeatDays.trim();
    Log.d("AlarmInfoActivity","day:"+repeatDays, null);
    String[] days = repeatDays.split(" ");
    int j;
    String checkBox;
    CheckBox checkDay;
    for(j = 0; j < days.length; j++){
        checkBox = days[j];
        Log.d("AlarmInfoActivity","day:"+checkBox, null);
        checkDay = (CheckBox) findViewById(getResources().getIdentifier(checkBox, "id", getPackageName()));
        if(checkDay != null) {
            checkDay.setChecked(true);
        }
    }
