# Is there a 'Glass Ceiling' at UVA?

## Code Description
  * [GenderFinder.java] (https://github.com/NipunSingh/UVA-Glass-Ceiling-Analysis/blob/master/GenderFinder.java) - reads from a csv which contains faculty data and salary. Passes the first name of the faculty member to the [Gender API] (https://gender-api.com/) to get the best guess of the gender. Writes the output to a new CSV file.
  * [faculty_salaries_with_gender.csv] (https://github.com/NipunSingh/UVA-Glass-Ceiling-Analysis/blob/master/faculty_salaries_with_gender.csv) - csv file containing the salary data of 3,225 UVA professors and their gender. 

## Background 
  For a Systems Engineering class, we were asked to see whether there was a pay disparity between male and female faculty members at the University of Virginia. We were given a csv file with the names of the faculty, their department, their title, and their salary. Pretty much everything except their gender! Some teams went through and manually assigned a gender to each faculty memember. Because I am ~~lazy~~ efficient I decided to write a quick program in Java which interfaced with the Gender API to get the genders of each professor. 

## Results
   The algorithm found 1,106 female faculty memembers and 2,072 male faculty members. 77 of the 3,225 names were not able to be assigned a gender. The average salary for a female was $90,000 and $112,000 for a male. We ran a Mann-Whitney test in Minitab on the resulting data and found that the difference between male salaries and female salaries was statistically significant (p = ~0.00). 
![alt text](https://github.com/NipunSingh/UVA-Glass-Ceiling-Analysis/blob/master/MannWhitneyResults.png "Mann Whtiney Results")

Looking at the data by school, we found that females made significantly less in the School of Medicine and in the College of Arts and Sciences. There was no significant difference between the genders in the School of Engineering and Applied Sciences. Further work needs to be done in looking at salary differences after controlling for years of experience and job title.  

