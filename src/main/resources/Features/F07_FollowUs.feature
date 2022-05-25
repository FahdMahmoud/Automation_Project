@SmokeTest

  @FollowUs
    Feature:

      Background:
        Given Open The Browser
        And Navigate To HomePage

        #Scenario 1 ( facebook Link )
      Scenario: user opens facebook link

        When click the facebook link

        Then Facebook opened in new tab


        #Scenario 2 ( twitter Link )
      Scenario: user opens twitter link

        When user click on the twitter link

        Then Twitter opened in new tab

               #Scenario 3 ( rss Link )
      Scenario: user opens rss link

        When user click on the rss link

        Then Rss opened in new tab


        #Scenario 4 ( youtube Link )
      Scenario: user opens youtube link

        When user click on the youtube link

        Then Youtube opened in new tab
