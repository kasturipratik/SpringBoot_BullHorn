# SPRING BOOT APPLICATION FOR USER TWITS
- Simple application to ask user inputs and display in the next html page
- Added file upload option for images 
- Processed the user uploaded images to cloudinary and imported the url from cloudinary 
## Steps to add upload image function in the application

<<<<<<< HEAD
#### Add cloudinary dependency to maven 
####		<dependency>
####			<groupId>com.cloudinary</groupId>
####			<artifactId>cloudinary-taglib</artifactId>
####			<version>1.2.1</version>
####		</dependency>
####		<dependency>
####			<groupId>com.cloudinary</groupId>
####			<artifactId>cloudinary-http44</artifactId>
####			<version>1.2.1</version>
####		</dependency>
#### Create CloudinaryConfig.java  file and add the codes for cloudinary configuration (codes are available with this repo..)
#### Add codes to the @PostMapping path to connect to the cloudinary and set the file and get the url
#### Add enctype="multipart/form-data" on the form attribute where the user can upload images
#### Add the input tag and set the name attribute to the name the @PostMapping will process.
=======
- Add cloudinary dependency to maven 

```		<dependency>
		<groupId>com.cloudinary</groupId>
			<artifactId>cloudinary-taglib</artifactId>
			<version>1.2.1</version>
		</dependency>
		<dependency>
			<groupId>com.cloudinary</groupId>
			<artifactId>cloudinary-http44</artifactId>
		</dependency>

```
- Create CloudinaryConfig.java  file and add the codes for cloudinary configuration (codes are available with this repo..)
- Add codes to the @PostMapping path to connect to the cloudinary and set the file and get the url
- Add enctype="multipart/form-data" on the form attribute where the user can upload images
- Add the input tag and set the name attribute to the name the @PostMapping will process.
>>>>>>> 6b66969d62d14a6cb8a808477889035d45b3145f
