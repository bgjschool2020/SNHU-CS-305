# SNHU-CS-305

## Briefly summarize your client, Artemis Financial, and their software requirements. Who was the client? What issue did they want you to address?
Artemis Financial is a consulting company that develops financial plans for customers. These plans can include savings, retirement, investment, and insurance plans. Artemis Financial wanted to modernize their software and make it more secure for themselves and their customers. They wanted us to look closely at their web-based software to identify and resolve any security vulnerabilities that we could find. 

## What did you do very well when you found your client’s software security vulnerabilities? 
I think I did a good job at reducing the vulnerabilities I found. What started out with over `70` known vulnerabilities, was reduced to only `2` by the time I was finished.

## Why is it important to code securely? What value does software security add to a company’s overall wellbeing?
It is important to code securly so it prevents malicious attacks from taking advantage of your programs. This could include data breaches that steal customer's personal information like addresses and credit cards. In the case of Artemis Financial's overal wellbeing, if there had been a security breach on their servers, they could lose a lot of their customers. Having all of your finances leaked can be very damaging to an individual; once that trust is gone they would from Artemis Financial to another option.

## What part of the vulnerability assessment was challenging or helpful to you?
The vulnerability assessment wasn't too bad. It took a long time to get through all of the dependencies and find the solutions for the vulnerabilities. Acoording to my instructor I didn't include enough detailed screenshots to support my findings.

## How did you increase layers of security? In the future, what would you use to assess vulnerabilities and decide which mitigation techniques to use?
I increased Artemis Financial's security by recommending that they use AES-256 to store and transmit any data. I also updated all of the dependecies they used in their software; this significantly reduced the vulnerabilities they had, further improving the security of the program.
In the future, I will use the [snyk](https://snyk.io/) and [OWASP DependencyCheck](https://github.com/jeremylong/DependencyCheck) tools to assess my programs for vulnerabilities. To mitigate those vulnerabilities I would use the [Mojohaus Versions Maven Plugin](https://www.mojohaus.org/versions/versions-maven-plugin/index.html) as it helped significantly in this project.

## How did you make certain the code and software application were functional and secure? After refactoring the code, how did you check to see whether you introduced new vulnerabilities?
Well, to make sure it was functional, I ran it. It ran without errors and did what it was supposed to do. After refactoring, I ran it through the same dependency check tools I had before and it was able to determine that there were no more found vulnerabilities.

## What resources, tools, or coding practices did you use that might be helpful in future assignments or tasks?
The [Snyk](https://snyk.io/) tool was useful, and would likely be even more useful on larger projects. It also taught me more about what types of practices might cause security vulnerabilities and how to either not do those in the first place or fix them afterward.

## Employers sometimes ask for examples of work that you have successfully completed to show your skills, knowledge, and experience. What might you show future employers from this assignment?
From this assignment, I might show future employers how I arrived at solutions and problem solved to fix others. I would not be showing them any of the coding assignments, as they were honestly very buggy and caused more problems. The work from this class is very outdated and any modern company today will not have the same issues as presented in this class. For example, all software should be updated regularly and that would prevent most of the issues I had with CS-305.
