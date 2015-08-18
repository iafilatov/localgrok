localgrok
=========

A package of [OpenGrok](http://opengrok.github.io/OpenGrok/) with [Jetty](http://www.eclipse.org/jetty/) and a simple interface, usable as a standalone desktop application. Based on OpenGrok 0.10 and Jetty 8.0.


First of all
------------

This is my first (and to date last) Java project. If you think that it's ugly... well, that's because it is. I wrote it a few years ago because there seemed to be no decent code browsing tool for Linux at that time. And settion up OpenGrok is too much hassle for a developer.

I consider it unstable. It runs, all 3 buttons work, it indexes, and the web page opens. Other than that I've done no testing.


Prerequisites
-------------

* Java <= 1.7 (patches for 1.8 are welcome!)

* ctags

  OpenGrok needs [Exuberant Ctags](http://ctags.sourceforge.net/).

  **Linux**: ctags should be in the repositories of all major distributions.

  **Windows**: [Donwload](http://prdownloads.sourceforge.net/ctags/ctags58.zip) the Windows build and place ctags.exe somewhere in PATH.


Installation
------------

None needed. Just clone the repository and double-click localgrock.jar. Run it from command line like `java -jar localgrok.jar` to get a kind of verbose output.


Usage
-----

Simply choose the directory and click _Reindex_. After indexing has finished, click on the progress bar to open the OpenGrok web interface.

LocalGrok is configured to enable the [Projects](https://github.com/OpenGrok/OpenGrok/blob/master/README.txt#L66) feature of OpenGrok. Basically, you put all the code that you want to index in a single place, like this:

    .
    ├── work
        ├── src
            ├── my_project
            ├── my_better_project
            └── my best project

Then simply point LocalGrok to .../work/src and have your stuff neatly organized.
