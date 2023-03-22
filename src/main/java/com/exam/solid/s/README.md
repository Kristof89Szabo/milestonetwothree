### Single Responsibility principle

Every software component should have one and only one responsibility. 
Component can be: 
- module
- class
- method

Example: Controller, Service, Repository
We want to achieve loose coupling. If we change mySQL to Mongo we have to modify the repository layer/class.(Which only
deals with database operations.)


