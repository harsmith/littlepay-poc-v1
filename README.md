# littlepay-poc-v1
*Summary*
We need to create a Java application which when given an input file in CSV format containing a single tap on or tap off per line we can create an output file containing trips made by customers.

*Requirements*
- Maven 3.8.3+
- Java 17

*How to run the application*
Ensure the code is able to be compiled and runs all the tests by using the following command. This will also execute the code against the default trips and taps csv files.

`mvn clean install`

Executing the code with a custom input file, this needs to be an absolute path if its not with the project structure. However, if its inside the project you can use a relative path. The following command is for only suppling an example input file.

`mvn compile exec:java -Dexec.mainClass="Application" -Dexec.arguments="src/main/resources/taps.csv"`

Whereas, you can also do the following command to specify a custom input and output.

`mvn compile exec:java -Dexec.mainClass="Application" -Dexec.arguments="src/main/resources/taps-custom.csv,src/main/resources/trips-custom.csv"`



*Assumptions*
 - All cards used in transactions have enough money to pay for the fare when the initial touch on happens.
 - There are only 3 types of trips.
 - For each touch on, there is a corresponding touch off or no action. Therefore, a touch on can’t happen twice on the same bus and a touch off can’t happen without a touch on.
 - The same PAN was used in both transactions.
 - There are no technical glitches so a touch on MUST happen before a touch off in terms of time.
 - The CSV file entries are ordered by time and not randomly scattered.
 - If someone is catching multiple busses, they touch on and off on the same bus before transferring.
 - When an incomplete transaction happens, we make the to stop and from stop id to be the same.
 - When an imcomplete transaction happens, we make the touch on and touch off time to be the same.
 - All PANs are verified as valid before they're written to the CSV.
