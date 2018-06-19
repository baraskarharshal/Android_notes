 
 
 public Date getDateIn24HrFormat(String time, String ampm){
        //Input 12 hour format date
        //Output 24 hour format date

        Date date24 = new Date();
        SimpleDateFormat dateFormat12 = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat dateFormat24 = new SimpleDateFormat("HH:mm");

        try {
            date24 = dateFormat12.parse(time + " " + ampm);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date24;

    } // End of method
