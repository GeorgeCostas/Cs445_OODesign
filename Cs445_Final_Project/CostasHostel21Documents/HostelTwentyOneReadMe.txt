h21Readme

this document outlines the methods used to test the Hostel21 application.
in practice I used string arrays of the proper commands. these are now contained in my test class

below are examples of the proper command arguments to call with this program.
deviation from using the example below will result in errors.
Also note that that the first command entered must start with h21 or the program will error.



h21 admin load --file_name C:\Users\GeeCost\Downloads\hostel-inventory-1-20131117.xml
	this command loads a filepath on your pc.
h21 admin revenue --start_date 20140701 --end_date 20140703
h21 admin occupancy
	revenue and occupancy need admin to be called to run, as doall function besides user functions

h21 book add --search_id 1234 --user_id 678				
	requires a valid search id, which start at 0 and are assigned to a bed and incremented. thus search id =0-#nmber of beds searched in total
	requires a valid user. valid user id's work the same way as search id's. 
h21 book cancel --booking_id 123
h21 book view --booking_id 123

h21 user add --first_name John --last_name Doe --email john.doe@example.com --cc_number 12338789638587 --expiration_date 20130809 --security_code 1234 --phone 7736711508
h21 user change --first_name enter --last_name Different --email info --cc_number 12338789638ok7 --expiration_date 20130809 --security_code 1234 --phone 7736711508

h21 search --city "San Francisco" --start_date 20140701 --end_date 20140703  
		search by multiple days 
h21 search --city "San Francisco" --start_date 20140701 --end_date 20140702
		search by 1 day
h21 search --city Berlin --start_date 20140701 --end_date 20140703 --beds 2
		search by beds on multiple days

note that if a command has a value requiring a space like San Francisco you must quote the entry
	eg."San Francisco"

I would use patterns of these commands in order to achieve applicaton logic.

my first pattern was

h21 admin load --file_name C:\Users\GeeCost\Downloads\hostel-inventory-1-20131117.xml
h21 user add --first_name John --last_name Doe --email john.doe@example.com --cc_number 12338789638587 --expiration_date 20130809 --security_code 1234 --phone 7736711508
h21 user change --first_name enter --last_name Different --email info --cc_number 12338789638ok7 --expiration_date 20130809 --security_code 1234 --phone 7736711508
h21 search --city "San Francisco" --start_date 20140701 --end_date 20140703  
h21 book add --search_id 1234 --user_id 678				
h21 book cancel --booking_id 123
h21 book view --booking_id 123

I would call variations n this pattern using multiple dday searches and single day searches
I would book various search id's

I would add multiple users

the last twocommands I used were
h21 admin revenue --start_date 20140701 --end_date 20140703  
h21 admin occupancy