

switch (repeatType) {
      case "Everyday":
          repeatGroup.check(repeatGroup.getChildAt(0).getId());
          break;
      case "Once":
          repeatGroup.check(repeatGroup.getChildAt(1).getId());
          break;
      case "Monday to Friday":
          repeatGroup.check(repeatGroup.getChildAt(2).getId());
          break;
      case "Custom":
          repeatGroup.check(repeatGroup.getChildAt(3).getId());
          break;
  }
