# Event Planner

#### Simple CLI tool for quoting event planning services.

#### By _**Pablo Barreyro**_

## Description

This application will prompt users interested in having an event planned through a series of options and quote them for services requested. It will also accommodate special coupons users may apply toward the cost of planning services. Second generation features include:

* Special event packages/deals
* Popular packages by price range
* Dynamic pricing based on date/duration
* Dynamic event planning suggestions (_e.g._, "We think your guests will be happier if you added before dinner hors d'oeuvres")

#### Specifications

##### MVP
| Behavior | Input | Output |
| --- | --- | --- |
| Instantiate an event with unique name | "Pablo" | Pablo's Event<br>estimate:$200 base<br>guests:<br>food:<br>drink:<br>entertainment:  |
| Set guest range | "0-25" | Pablo's Event<br>price:$200 base<br>guests:0-25<br>food:<br>drink:<br>entertainment: |
| Set food service  | "hors d'oeuvres" | Pablo's Event<br>estimate:$200 base <br>guests:0-25<br>food:hors d'oeuvres ($75)<br>drink:<br>entertainment: |
| Set beverage service | "beer & wine" | Pablo's Event<br>estimate:$200 base  <br>guests:0-25<br>food:hors d'oeuvres ($75)<br>drink: beer & wine ($150)<br>entertainment: |
| Set entertainment service | "live band" | Pablo's Event<br>estimate:$200 base  <br>guests:0-25<br>food:hors d'oeuvres ($75)<br>drink: beer & wine ($150)<br>entertainment: live band ($200) |
| Set a price estimate for services requested | "get quote" | Pablo's Event<br>estimate:$200 base, $425 services<br>guests:0-25<br>food:hors d'oeuvres ($75)<br>drink: beer & wine ($150)<br>entertainment: live band ($200) |
| Reduce price estimate when user provides valid coupon | "$50 off any event above $400" | Pablo's Event<br>estimate:$575 base<br>guests:0-25<br>food:hors d'oeuvres ($75)<br>drink: beer & wine ($150)<br>entertainment: live band ($200) |

##### 2nd Gen
| Behavior | Input | Output |
| --- | --- | --- |
| Show special packages | "See packages" | Wedding package($4000 base)<br>Birthday package($1000 base)<br>Reunion package($5000 base)<br>  |
| Sort packages by price range  | "< $5000" | Birthday package($1000 base) |
| Set event date  | "6-1-2018" | Pablo's Event<br>date: June 1, 2018<br>estimate:$200 base, $425 services<br>guests:0-25<br>food:hors d'oeuvres ($75)<br>drink: beer & wine ($150)<br>entertainment: live band ($200) |
| Set event duration  | "4 hours" | Pablo's Event<br>date: June 1, 2018<br>duration: 4 hours<br>estimate:$200 base, $425 services<br>guests:0-25<br>food:hors d'oeuvres ($75)<br>drink: beer & wine ($150)<br>entertainment: live band ($200) |
| Adjust price by date and duration | "get quote" | Pablo's Event<br>date: June 1, 2018<br>duration: 4 hours<br>estimate:$400 base, $850 services <br>guests:0-25<br>food:hors d'oeuvres ($75)<br>drink: beer & wine ($150)<br>entertainment: live band ($200) |


## Setup/Installation Requirements

* Clone [this repo](https://github.com/Pabarreyro/event-planner)
* Install Java [SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) & [JRE](http://www.java.com/en/)
* Run App.java in local IDE

## Known Bugs

N/A

## Support and contact details

For questions or to report a bug, start issue in this repo.

## Technologies Used

* Java 1.8


### License

This software is licensed under the MIT license.

Copyright © 2018 **Pablo Barreyro**
