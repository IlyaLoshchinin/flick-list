package com.bestflicklist.app.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonValue;
import sun.security.provider.SHA;

/**
 * Created by Illia Loshchinin on 16.02.2018.
 */

public enum Genre {
  Action, Adventure, Animation, Biography, Comedy, Crime,
  Drama, Family, Fantasy, Film_Noir, History, Horror, Music,
  Musical, Mystery, Romance, Sci_Fi, Sport, Thriller, War, Western;


//  @JsonValue
//  public String toString() {
//    return super.toString().toLowerCase();
//  }

}
