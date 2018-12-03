# Gym API 

## Prerequisites
This project is app design of a basic application that would be used by a Gym. It allows to add users, create profiles for employees and members of the gym. Additionally, it performs subsequent actions based on different profiles.

## Project Content
This program allows users to create profiles as either a Member or a Trainer of the Gym. Depending on the type of profile it allows users to accomplish different tasks and store different data. When creating any of the profile, basic info an personal information is saved such as: Name, Email, Address, Gender etc.


### Difference in functionality between a Member and a Trainer.
These are the following functions available by:

# Trainer
* Add new Member to a roster.
* Add a Member Assessment
* View Assessments of a specific Member
* Search members in their roster by Email.
* List all Members of their roster.
* List all of the Members on their roster by a specific BMI

# Member/Student Member
* Update Profile
* View Profile
* Edit Profile

### Testing
I have included JUnit testing as an example for one of the main classes "StudentMember". Which is a class of a student membership in the gym. I test the basic functionality such as the setup, setters, getters and the assessment associated with every type of profile in the system.

### Saving Data
To save data in the app such as profiles, I used Extensible Markup Language (XML). An XML document is a basic unit of XML information composed of elements and other markup in an orderly package.
