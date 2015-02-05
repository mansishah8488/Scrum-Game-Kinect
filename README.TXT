------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Scrum Game using Kinect & Green foot
PURPOSE OF PROJECT: To better understand the concpets of Scrum principles through the use of an interactive tool using software design patterns
VERSION or DATE: 1.0 December 5th 2014
HOW TO START THIS PROJECT: 
- Download greenfoot and import the project in the greenfoot environment. 
- Setup kinect with greenfoot. Following are the steps to implement

There are several steps required for installing the Greenfoot/Kinect software on Mac OS X. We have found the OpenNI software to be slightly less stable on Mac OS X than Windows or Linux, but we give the instructions here to install and try it.

1. Install Xcode
The first thing you need to do is install Xcode (if it is not already installed). If you have your Apple install CDs that came with the machine, you can install Xcode from those. If you don't have those and you are on Lion, you can download Xcode from the Mac App Store. If you don't have your CDs, and you're not on Lion, you can download it from Apple's site, but you will need to create a free account to do so: http://developer.apple.com/xcode/

2. Install MacPorts
The second thing to do is to install MacPorts (if it is not already installed). You can do this using the appropriate installer for your OS X:
MacPorts allows you to easily install the bits of open source software necessary for OpenNI and the Greenfoot KinectServer.

3. Install Prerequisite Libraries
Issue these commands in a Terminal to install various required libraries:


4. Install OpenNI
Once you have all the pre-requisites installed, you need to install OpenNI. For each of these files in turn you need to do the same three steps: download them, unzip them, and then in a Terminal, go into the unzipped directory and run sudo ./install.sh:
OpenNI
Kinect Driver
This last one will also ask you for a licence key. Give it: 0KOIk2JeIBYClPWVnMoRKn5cdY4= (including that trailing equals sign): NITE

5. Test OpenNI
Now you'll have OpenNI installed. You can do a quick test by plugging in the Kinect, and then going into the directory where you unzipped OpenNI, then going into the Samples/Bin/Release sub-directory and running ./Sample-NiSimpleViewer. When this runs, press "3" on your keyboard to get the RGB view, and wave at the Kinect to check it's working. Press Escape to exit.
6. Install Greenfoot KinectServer
The next step is to download the Greenfoot KinectServer. Download and unzip kinectserver-1.2.tar.gz -- then in the Terminal, go into the unzipped directory and issue these commands:
This will build and install a program called "kinectserver" -- the Greenfoot Kinect Server. Run it by typing kinectserver in a terminal. That will put a little Greenfoot icon in your top-right taskbar on your machine. Leave the Terminal window open that it's running in and minimise it. Now you just need a Greenfoot Kinect scenario, which you can get in the main instructions.

- Complie and its ready to be executed.

AUTHORS: Mansi Shah
USER INSTRUCTIONS:
This particular projet 
