# medialibrary-app
Java backed spring boot server for media library

Steps to build and run<br>
1. mvn clean install <br>
2. This will generate a war file in target folder of medialibrary-web module<br>
3. Make sure your mongodb is up and running. To point to your remote mongo, use the property in application.properties file<br>
4. Customize the port in application.properties. After deploying the app, access the same at http://localhost:8082<br>

<br><br>
Things in progress<br>
1. Add validations so that when you select Image type media, only images can be uploaded and same for videos.<br>
2. Show error or success notifications when file upload completes.<br>
3. API to delete media<br>
4. Login/Signup screen to enable user based secure operations.<br>
5. Spring security is implemented but ROLE based api access is commented as of now because of above point<br>
