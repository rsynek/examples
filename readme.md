BPM-Taxi
=======================

Example illustrating using BPM Suite to model process of ordering taxi.

Getting started
-----------------------
1. unzip EAP 6.4.x or JBoss AS 7
2. install BPM Suite 6.3.x
3. create a new user with roles: admin, analyst, operators
4. setup REST endpoints
5. login to Business Central
6. switch to Administration and clone this repository


Setting up REST services
------------------------
OrderTaxi.bpmn2 process contains two REST tasks that expect following endpoints running:
GET <URL can be passed to the process via form as a variable or configured in REST task>, content-type:application/xml
  Expected content is org.jboss.qa.examples.bpm_taxi.Registry serialized to XML. Test data are generated in /tmp/testRegistry.xml by running 'mvn test'.
POST <URL can be configured in REST task>

http://www.mocky.io/ can be used for mocking REST endpoints.
