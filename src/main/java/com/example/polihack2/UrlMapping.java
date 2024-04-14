package com.example.polihack2;

public class UrlMapping {
  public static final String API = "/polihack2";

  public static final String AUTH = "/auth";

  public static final String SIGN_IN =  "/sign-in";
  public static final String SIGN_UP = "/sign-up";
  public static final String ANSWER = "/answer";
  public static final String QUESTION = "/question";
  public static final String QUIZ = "/quiz";
  public static final String INTERVIEWER = "/interviewer";
  public static final String INTERVIEW = "/interview";
  public static final String CREATE_ANSWER = ANSWER + "/create";
  public static final String CREATE_INTERVIEW = INTERVIEW + "/create";
  public static final String CREATE_QUESTION = QUESTION + "/create";
  public static final String GET_INTERVIEW_BY_CLIENT_ID = INTERVIEW + "/get_interview" +"/" + "{clientId}";
  public static final String GET_QUESTIONS = QUESTION + "/get_questions";
  public static final String GET_INTERVIEW = INTERVIEW + "/get_interviews";
  public static final String CREATE_QUIZ = QUIZ + "/create";
  public static final String PROCESS_QUIZ = QUIZ + "/process" + "/" + "{quizId}" + "/" + "{clientId}";
  public static final String GET_QUIZZES = QUIZ + "/get_quizzes";
  public static final String GET_INTERVIEWER = INTERVIEWER + "/get_interviewer";
  public static final String GET_QUIZ_BY_ID = QUIZ + "/" + "{id}";

  public static final String[] AUTH_WHITE_LIST = {
          "/v3/api-docs/**",
          "/swagger-ui/**",
          "/v2/api-docs/**",
          "/swagger-resources/**",
          AUTH + "/**"
  };

}