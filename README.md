# Tal'Ass (Webice) ![CI status](https://img.shields.io/badge/build-passing-brightgreen.svg)
JEE Webservices Project | Master 1 Miage 2018

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
IDE     :   Eclipse for Java EE Developers
Library :   JSTL 1.2
Server  :   Tomcat 9
VCS     :   Git 2.17
```

### Installing

A step by step series of examples that tell you how to get a development env running

1. Create a new project in Eclipse

2. Go to your project's root folder and launch Git Bash

3. Clone the project

    ```
    $ git clone https://github.com/lincolninnocent/Webice.git
    ```

4. Download the [Java Server Pages Standard Tag Library](http://central.maven.org/maven2/javax/servlet/jstl/1.2/jstl-1.2.jar)

5. Import the library in the project

    ```
    ...\Webice\web\WEB-INF\lib\jstl-1.2.jar
    ```

6. Edit local directory path in Web XML file

    ```xml
    <context-param>
        <param-name>localDirectoryPath</param-name>
        <param-value>C:\Users\Marine\Etude\Miage\M1\S8\Webservices\Projet\Webice\web\WEB-INF\database</param-value>
    </context-param>
    ```

7. Done! Now you can start using the project

## Built With

* [Material Components](https://material.io/develop/web/) - Alternative to Bootstrap

## Version Control

We use [Git](http://semver.org/) for version control.

## Authors

* **Frantz Toussaint** - [GitHub Profile](https://github.com/FrantZoe)
* **Marine Guillocheau** - [GitHub Profile](https://github.com/MarineGuillocheau)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* **Jenny Benois-Pineau**
* **Luc Gracianette**

## Modification History

```
Frantz Toussaint        :       May 14, 2018        :       Auto Generated
Frantz Toussaint        :       May 31, 2018        :       Properly Written
```
