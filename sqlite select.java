 // Fetch Alarm data from database
  queryString = "SELECT * FROM alarm_tbl WHERE id = '"+id+"'";
  c = db.rawQuery(queryString, null);
  if(c.getCount()==0)
  {
      dbInstance.msg(this, "Alarm not found!");
  }
  alarmBuffer = new StringBuffer();

  while(c.moveToNext())
  {
  // get alarm values
  
      time = c.getString(1);
      ampm = c.getString(2);
      repeatType = c.getString(3);
      repeatDays = c.getString(4);
      note = c.getString(5);
      ringtone = c.getString(7);
      Log.d("AlarmInfoActivity", "ringtone while fetching : " +ringtone);
      vibrate_switch = c.getString(8);

   }
