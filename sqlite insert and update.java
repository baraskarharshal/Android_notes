

// Initializing db object
dbInstance = DBSingleton.getInstance(getApplicationContext());
db = dbInstance.getReadableDatabase();


ContentValues initialValues = new ContentValues();
initialValues.put("time",time);
initialValues.put("ampm",ampm);
initialValues.put("repeat_type",repeatType);
initialValues.put("repeat_days",repeatDays);
initialValues.put("note",note);
initialValues.put("alarm_switch","true");
initialValues.put("ringtone",ringtone);
Log.d("AlarmInfoActivity", "ringtone while saving : " +ringtone);
initialValues.put("vibrate_switch",vibrate_switch);


if(mode.equals("add")) {
    // Add new alarm
    initialValues.put("request_code","-1");
    Long result = db.insert("alarm_tbl", null, initialValues);
    id = result.toString();
    dbInstance.msg(getApplicationContext(), "New alarm is set!");
}
else{
    // Update alarm
    int result =  db.update("alarm_tbl", initialValues, "id=" + id, null);
    dbInstance.msg(getApplicationContext(), "Alarm updated!");
}
