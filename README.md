# littlepay-poc-v1

List of Assumptions:
 - All cards used in transactions have enough money to pay for the fare when the initial touch on happens
 - There are only 3 types of trips.
 - For each touch on, there is a corresponding touch off or no action. Therefore, a touch on can’t happen twice on the same bus and a touch off can’t happen with a touch on.
 - The same PAN aka debit/credit card was used in both transactions.
 - There are no technical glitches so a touch on MUST happen before a touch off in terms of time.
 - The CSV file, entries are ordered by time and not randomly scattered.
 - If someone is catching multiple busses, they touch on and off on the same bus before transferring.
 - When an incomplete transaction happens, we leave the stop id as the same as the
 - All PANs are verified as valid before they're written to the CSV.
