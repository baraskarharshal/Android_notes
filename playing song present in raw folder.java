
// name of the song present in row folder can have lowercase letters and underscore only.
// stop already playing song
  if(mediaPlayer.isPlaying()){
      mediaPlayer.stop();
  }

  // Playing selected song
  RadioGroup rg = (RadioGroup) findViewById(R.id.ringOptions);
  //RadioButton rd = (RadioButton)ringtoneDialog.findViewById(rg.getCheckedRadioButtonId());
  selectedSongName = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
  //rg.clearCheck();
  //rd.setChecked(true);
  currentSongId = getResources().getIdentifier(selectedSongName, "raw", getPackageName());
  mediaPlayer = MediaPlayer.create(getApplicationContext(),currentSongId );
  mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
  mediaPlayer.start();
