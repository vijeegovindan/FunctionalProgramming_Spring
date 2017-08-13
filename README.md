# FunctionalProgramming_Spring\
Create HTML Files  

Add the following HTML templates:

home.html
now-playing.html
medium-popular-long-name.html
overview-mashup.html (EXTRA)
You can have IntelliJ generate these files for you but remember to close the tags (Thymeleaf). Add some text to distinguish them. "Home" should have links to /now-playing and /medium-popular-long-name. Add a simple @Controller class to serve up these three HTML views. (/ should lead to home.html, and the others to their respective routes). Run your program and test that you can see all three HTML pages.

Query the TMBD API  

Leave IntelliJ alone for now. Using curl or Postman, query the TMDB API. You will need to have an access token. You can either sign up for a free account and get your own, or use this one:

?api_key=be2a38521a7859c95e2d73c48786e4bb

Try to access curl or Postman to this route:

https://api.themoviedb.org/3/movie/now_playing

and you should get a JSON response back with data about movies that are currently playing.

Now, let's access the API through Java. Write a public static List<Movie> getMovies(String route) method in your controller. It should use the restTemplate.getForObject(URL, class) method to query the same route. (As a troubleshooting step, you may wish to add code to print the data you receive from the API to the console). Change your /now-playing endpoint to call the method and add the resulting list of movies to the Model.

Add a block of Thymeleaf templated code to your now-playing.html file. Your template should show each movie poster along with its title. (Changing ??? to some Thymeleaf statements).
