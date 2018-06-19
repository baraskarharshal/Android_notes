


// Convert date time to 24 hour format 
// here time is in format: 01:20 

        Date d = getDateIn24HrFormat(time, ampm);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        min = cal.get(Calendar.MINUTE);

        Calendar calendar = Calendar.getInstance(); // Alarm time
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 0);

        Calendar calendar2 = Calendar.getInstance(); // Current time

        Long current = calendar2.getTimeInMillis();
        Long alarmTime = calendar.getTimeInMillis();
        timeToAlarmMillis = alarmTime - current; // difference is the exact milliseconds to alarm

        if(timeToAlarmMillis < 0){
            Calendar tomorrow = Calendar.getInstance();
            tomorrow.add(tomorrow.DAY_OF_YEAR, 1);
            tomorrow.set(tomorrow.HOUR_OF_DAY, hour);
            tomorrow.set(tomorrow.MINUTE, min);
            tomorrow.set(tomorrow.SECOND, 0);

            alarmTime = tomorrow.getTimeInMillis();
            timeToAlarmMillis = alarmTime - current;
        }

        Log.d("SetAlarm", "Alarm Time millis: " +timeToAlarmMillis);
