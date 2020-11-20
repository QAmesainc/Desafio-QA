FEATURE: Gift Cards

       SCENARIO: Access Print a Gift Card at home page
        GIVEN the user is has clicked on the Gift card button
          AND the user is in home page of the website
         WHEN the user clicks on the print at home button 
         THEN Amazon.com Print at Home Gift Card screen should be visible
        
       SCENARIO: Choose design for the Gift Card
          GIVEN the user is on the page Amazon.com Print at Home Gift Card
            AND the user clicks on standard button 
           WHEN the user clicks in one card design 
           THEN the chosen design should be visible 
        
        SCENARIO: Choose Amount for the Gift Card
           GIVEN the user is on the page Amazon.com Print at Home Gift Card
             AND the user chose the card design
            WHEN the user clicks on the $50 amount button 
            THEN the chosen amount should be visible    