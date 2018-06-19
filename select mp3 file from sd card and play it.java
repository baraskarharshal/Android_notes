
// Add button onclick listener to open sd card audio files.

addNewRingtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 10);

            }
        });
        
        
        
        
        
 // Setting onactivity result for selecting audio file

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK && requestCode == 10){
            Uri uriSound=data.getData();
            saveSong(getApplicationContext(), uriSound);
            Toast.makeText(getApplicationContext(), "Song selected", Toast.LENGTH_SHORT).show();
        }
    }
    
    
    
    // save song method

    private void saveSong(Context context, Uri uri) {

        try {
            //Toast.makeText(getApplicationContext(), "inside play. Uri:"+uri.toString(), Toast.LENGTH_SHORT).show();
            Log.d("AlarmInfoActivity", uri.toString());
            String[] proj = { MediaStore.Audio.Media.DATA };
            Cursor ringtoneCursor = context.getContentResolver().query(uri, proj, null, null, null);
            ringtoneCursor.moveToFirst();
            String path = ringtoneCursor.getString(ringtoneCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));

            // check if song already present in the song table or not
            queryString = "SELECT * FROM alarm_song WHERE song_path = '"+path+"'";
            c = db.rawQuery(queryString, null);
            if(c.getCount()==0) {
            /* Store song info in database table*/
                int index = path.lastIndexOf('/');
                String song_name = path.substring(index + 1, path.length() - 4);
                //dbInstance.msg(getApplicationContext(), "Song name:" + song_name);
                Log.d("AlarmInfoActivity", "path: " + path + "  song name: " + song_name);
                // insert 1 row
                ContentValues songValues = new ContentValues();
                songValues.put("song_path", path);
                songValues.put("song_name", song_name);
                Long result = db.insert("alarm_song", null, songValues);
                //dbInstance.msg(getApplicationContext(), "New song is saved in table!")  

            }
            else{
                dbInstance.msg(this, "Ringtone already present in the list!");
            }
            ringtoneCursor.close();


        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }





// Setting method on selecting ringtone from sd card to play it.

    View.OnClickListener onSelectRingtoneFromSDCard = new View.OnClickListener(){
        public void onClick(View v) {

            // stop already playing song
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }

            // Playing selected song
            RadioGroup rg = (RadioGroup) findViewById(R.id.ringOptions);
            selectedSongName = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            Log.d(TAG, selectedSongName);

            // Fetch ringtone path from song table
            queryString = "SELECT * FROM alarm_song WHERE song_name = '"+selectedSongName+"'";
            c = db.rawQuery(queryString, null);
            if(c.getCount()==0)
            {
                dbInstance.msg(getApplicationContext(), "Ringtone not found!");
            }
            alarmBuffer = new StringBuffer();
            String path = "";

            while(c.moveToNext())
            {
                path = c.getString(1);
                break;
            }

            playSongFromSDCard(path);

        }
    };








// method to play song from sd card

    public void playSongFromSDCard(String path){

        try{

            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.setLooping(true);
            Log.d(TAG, path);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer player) {
                    player.start();
                }
            });
            mediaPlayer.prepareAsync();


        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        
