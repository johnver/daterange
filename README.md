Outline
============

Complete the task described below
a. Create the model
b. Create associated unit test(s)

Create a Date Range model
        - The model is only valid if it has both a start and end date
        - Start date must be less than end date
        - Truncate the dates to the day: 2010­09­01 18:00 => 2010­09­01 00:00
        - It must be Immutable
Methods
        - Calculate days between : Number of days between the two dates in the date range model:
(2010­09­01, 2010­09­15) => 15
        - Calculate months between : Number of months between the two dates. If it’s less
than a month return the proportion of the months in between. For example:
                - if the dates are exactly one month apart the method will return 1:
(2010­09­01, 2010­10­01) => 1
                - If they are 1 and a half months apart it will return 1.5:
(2010­09­01, 2010­10­15) => 1.5
                - if they are half a month between return 0.5:
(2010­09­01, 2010­09­15) => 0.5
                - Approximates are fine
                - Is between a supplied date : returns true if the passed is inside the date range

Building the program
======================

1. Build the system using the standard maven command.
       	mvn clean install

Running the program
======================

1. Run the sample standalone program by issuing this command from the command line: 

        mvn exec:java